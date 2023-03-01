package com.example.demo.controller;

import org.springframework.ui.Model;
import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public ModelAndView getAll(ModelAndView modelAndView) {
        List<Task> taskList = taskService.getAll();
        modelAndView.setViewName("index");
        modelAndView.getModel().put("taskList", taskList);
        modelAndView.getModel().put("taskSize", taskList.size());
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        taskService.save(task);
        return "redirect:/";
    }

    @PostMapping("/projects")
    public ModelAndView viewProjects(ModelAndView modelAndView) {
        modelAndView.setViewName("projects");
        modelAndView.getModel().put("info", "ThisIsProjectsPage");
        return modelAndView;
    }
}
