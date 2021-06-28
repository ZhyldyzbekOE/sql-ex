package com.example.sqlex.controllers;

import com.example.sqlex.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/exec/{task_num}")
    public Object execute(@PathVariable String task_num){ // Вот тут можно было бы использовать @RequestParam
        return taskService.execute(task_num);            // и передовать как параметр метода task_num

    }

}
