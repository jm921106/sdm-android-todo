package com.todo.sdm.sdm_android_todo.data;

import com.todo.sdm.sdm_android_todo.models.Todo;

import java.util.ArrayList;
import java.util.List;

public class DataTodo {

    public static List<Todo> getDataTodo(){
        List<Todo> todos = new ArrayList();

        todos.add(new Todo("A","contents A"));
        todos.add(new Todo("B","contents B"));
        todos.add(new Todo("C","contents C"));
        todos.add(new Todo("D","contents D"));

        return todos;
    }
}
