package com.company.todo;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
public class TodoService {
	
	private final TodoRepository repository;
	
	public TodoService(TodoRepository repository) {
		this.repository = repository;
	}
	
	public Todo save(Todo todo) {return repository.save(todo);}
	public List<Todo> getAll() {return repository.findAll();}
	public Todo update(Todo todo) {return repository.save(todo);}
	public void delete(Long id) {repository.deleteById(id);}
	
	}
