package com.example.tasker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tasks {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private boolean completed;
	private String description;
	
	public Tasks() {}
	
	public Tasks(int id, boolean completed, String description) {
		this.id = id;
		this.completed = completed;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

