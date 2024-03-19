package com.jpa.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.dao.StudentRepository;
import com.jpa.test.entities.Student;
@RestController
@RequestMapping("/student")
public class Controller {
 @Autowired
	private StudentRepository studentRepository;
	
	@GetMapping()
	public List<Student> getStudent() {
		return studentRepository.findAll();
	}
	@PostMapping()
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public Optional<Student> getById(@PathVariable int id) {
		Optional<Student> byId = studentRepository.findById(id);
		if(byId.isEmpty()) {
			return null;
		}
		return byId;
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable int id){
	Optional<Student> optionalStudent = studentRepository.findById(id);
		if(optionalStudent.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		
		studentRepository.deleteById(id);
		return new ResponseEntity<>("deleted",HttpStatus.OK);
	
	}
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable int id ,@RequestBody Student student){
		Optional<Student> byId = studentRepository.findById(id);
		if(byId.isEmpty()) {
			return null;
		}
		Student student2 = byId.get();
		student2.setId(student.getId());
		student2.setName(student.getName());
		student2.setCity(student.getCity());
		student2.setStatus(student.getStatus());
		Student save = studentRepository.save(student2);
		return save;
	 
	}

}
