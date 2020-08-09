package com.springboot.start.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.springboot.start.web.model.Todo;
import org.springframework.stereotype.Service;


@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "test", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2, "test", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "test", "Learn Hibernate", new Date(),
                false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public Todo retrieveTodo(int id) {
        for (Todo todo: todos) {
            if(todo.getId() == id) {
                return todo;
            }
        }
       return null;
    }

    public void updateTodo(Todo todo) {
        for(int i=0; i<todos.size(); i++) {
            Todo Objtodo = todos.get(i);
            if(Objtodo.getId() == todo.getId()) {
                todos.remove(i);
                todos.add(i,todo);
                break;
            }
        }
//        todos.remove(todo);
//        todos.add(todo);
    }

    public void addTodo(String name, String desc, Date targetDate,
            boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }

}