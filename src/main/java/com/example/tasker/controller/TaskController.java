package com.example.tasker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tasker.dto.TaskDTO;
import com.example.tasker.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping(value="/tasks")
	public ResponseEntity<List<TaskDTO>> getAllTasks(){
		return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
	}
	
	@PostMapping(value="/addTask")
	public ResponseEntity<Boolean> addTask(@RequestBody TaskDTO taskDto){
		
		boolean added = taskService.addTask(taskDto);
		
		return new ResponseEntity<>(added, HttpStatus.OK);
	}

}
