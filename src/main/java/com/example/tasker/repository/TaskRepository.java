package com.example.tasker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tasker.entity.Tasks;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Integer>{

}
