package com.app.todolist.Services;

import com.app.todolist.Domain.Task;
import com.app.todolist.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService implements TaskServiceInterface {

    private TaskRepository taskRepository;

    public TaskService(@Autowired TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllUserTasks(String userName) {
        List<Task> taskList = new ArrayList<>();
        taskRepository.findAllByUserName(userName).forEach(task -> taskList.add(task));
        return taskList;
    }

    public void add(Task task, String userName) {
        Task taskToSave = new Task(task.getDescription(), task.isCompleted(), userName);
        taskRepository.save(taskToSave);
    }

    public void update(Long id) {
        Task task = taskRepository.findById(id).get();
        if (task.isCompleted()) {
            task.setCompleted(false);
        } else {
            task.setCompleted(true);
        }
        taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

}
