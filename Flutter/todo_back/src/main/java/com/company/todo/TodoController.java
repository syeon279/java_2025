package com.company.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/todos")
public class TodoController {
	private final TodoService service;

	public TodoController(TodoService service) {
		this.service = service;
	}
	
	//GET http://localhost:8080/api/todos
	@GetMapping
	public List<Todo> getTodos(){
		return service.getAll();
	}
	
	//Post http://localhost:8080/api/todos
	//		headers : Contents-type : application/json body(raw/json) {"title":"1" , "completed":false}
	@PostMapping
	public Todo createTodo(@RequestBody Todo todo) {
		return service.save(todo);
	}
	
	//Put http://localhost:8080/api/todos/3
	@PutMapping("/{id}")
	public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
		todo.setId(id);
		return service.save(todo);
	}

	//Delete http://localhost:8080/api/todos/1
	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable Long id) {
		service.delete(id);
	}
	
}
