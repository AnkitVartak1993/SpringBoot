package com.springboot.start.web.controller;

import com.springboot.start.web.model.Todo;
import com.springboot.start.web.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {
    @Autowired
    TodoService todoService;

    //Binds custom date format for date class throughout
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    @RequestMapping(value="/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model) {
        String username = getLoggedInUserName(model);
        model.put("todos", todoService.retrieveTodos(username));
        return "list-todos";
    }

    private String getLoggedInUserName(ModelMap model) {
        return (String) model.get("name");
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.GET)
    public String addTodo(ModelMap model) {
        model.addAttribute("todo",new Todo(0, getLoggedInUserName(model),"", new Date(), false));
        return "todos";
    }

    @RequestMapping(value="/add-todo", method= RequestMethod.POST)
    public String showAddTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()){
            return "todos";
        }
        String username = getLoggedInUserName(model);
        todoService.addTodo(username, todo.getDesc(), new Date(), false);
        return "redirect:/list-todos";
    }

    @RequestMapping(value="/update-todo", method=RequestMethod.GET)
    public String showUpdateTodo(ModelMap model, @RequestParam int id) {
        Todo todo = todoService.retrieveTodo(id);
        model.put("todo",todo);
        return "todos";
    }

    @RequestMapping(value="/update-todo", method= RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "todos";
        }
        todo.setUser(getLoggedInUserName(model));
        todoService.updateTodo(todo);
        return "redirect:/list-todos";
    }

    @RequestMapping(value="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }

}
