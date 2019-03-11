package com.app.todolist.Controllers;

import com.app.todolist.Domain.Task;
import com.app.todolist.Services.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller()
@RequestMapping("todo")
public class TodoController {

    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);
    private TaskService taskService;

    public TodoController(@Autowired TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model, Authentication authentication) {
        model.addAttribute("newTask", new Task());
        model.addAttribute("taskList", taskService.getAllUserTasks(authentication.getName()));
        return "list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid Task task, BindingResult result, Authentication authentication) {
        if (!result.hasErrors()) {
            taskService.add(task, authentication.getName());
        }
        return "redirect:/todo/list";
    }

    @RequestMapping(value = "/update/{taskId}", method = RequestMethod.POST)
    public String update(@PathVariable Long taskId) {
        taskService.update(taskId);
        return "redirect:/todo/list";
    }

    @RequestMapping(value = "/delete/{taskId}", method = RequestMethod.POST)
    public String delete(@PathVariable Long taskId) {
        taskService.delete(taskId);
        return "redirect:/todo/list";
    }
}
