package com.example.tasker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tasker.dto.TaskDTO;
import com.example.tasker.entity.Tasks;
import com.example.tasker.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepo;
	
	public List<TaskDTO> getTasks(){
		
		List<TaskDTO> arrList = convertToDto(taskRepo.findAll());
		
		return arrList;
	}
	
	public boolean addTask(TaskDTO task) {
		
		if(task.getDescription().length() > 122 || task.getDescription().isBlank())
			return false;
		
		if(task.isCompleted())
			return false;
		
		Tasks tasks = convertToEntity(task);
		
		try {
			taskRepo.save(tasks);
		}
		catch(Exception e) {
			System.out.println("Task did not get added!");
			return false;
		}
		
		return true;
	}
	
	private List<TaskDTO> convertToDto(List<Tasks> arr) {
		
		List<TaskDTO> newArr = new ArrayList<>();
		
		arr.forEach( task -> {
			TaskDTO taskDto = new TaskDTO(task.getId(), task.isCompleted(), task.getDescription());
			newArr.add(taskDto);
		});
		
		return newArr;
	}
	
	private Tasks convertToEntity(TaskDTO taskDto) {
		
		Tasks tasks = new Tasks();
		tasks.setCompleted(taskDto.isCompleted());
		tasks.setDescription(taskDto.getDescription());
		
		return tasks;
	}
}
