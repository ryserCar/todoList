package com.app.todolist.Services;

import com.app.todolist.Domain.Task;

import java.util.List;

public interface TaskServiceInterface {

    List<Task> getAllUserTasks(String userName);

    void add(Task task, String userName);

    void update(Long id);

    void delete(Long id);
}
