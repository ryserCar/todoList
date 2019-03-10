package com.app.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(@Autowired TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllUserTasks() {
        List<Task> taskList = new ArrayList<>();
        taskRepository.findAll().forEach(task -> taskList.add(task));
        return taskList;
    }

    public void add(Task task) {
        Task taskToSave = new Task(task.getDescription(), task.isCompleted());
        taskRepository.save(taskToSave);
    }

    public void update(Task task) {
        taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

}
