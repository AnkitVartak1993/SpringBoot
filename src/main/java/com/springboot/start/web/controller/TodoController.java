package com.springboot.start.web.controller;

import com.springboot.start.web.model.Todo;
import com.springboot.start.web.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {
    @Autowired
    TodoService todoService;

    @RequestMapping(value="/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model) {
        String username = (String) model.get("name");
        model.put("todos", todoService.retrieveTodos(username));
        return "list-todos";
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.GET)
    public String addTodo(ModelMap model) {
        model.addAttribute("todo",new Todo(0,(String) model.get("name"),"", new Date(), false));
        return "add-todo";
    }

    @RequestMapping(value="/add-todo", method= RequestMethod.POST)
    public String showAddTodo(ModelMap model, Todo todo) {
        String username = (String) model.get("name");
        todoService.addTodo(username, todo.getDesc(), new Date(), false);
        return "redirect:/list-todos";
    }

    @RequestMapping(value="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }

}
