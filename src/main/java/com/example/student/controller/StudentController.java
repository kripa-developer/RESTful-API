package com.example.student.controller;

import org.json.simple.JSONObject;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.entity.Student;
import com.example.student.exception.RecordNotFoundException;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

//Returning the Student Object
	
	@PostMapping("/create")
	public ResponseEntity<Student> create(@RequestBody Student student) {
		return new ResponseEntity<>(studentService.createStudent(student),HttpStatus.CREATED);
//		return ResponseEntity.ok(studentService.createStudent(student));  //it is also a valid return.
	}
	
//For custom JSON instead of using JSON Object.
	
//	@PostMapping("/create")
//	public ResponseEntity<Map<String, Object>> create(@RequestBody Student student) {
//	    Student savedStudent = studentService.createStudent(student);
//
//	    Map<String, Object> response = new HashMap<>();
//	    response.put("message", "Student successfully created");
//	    response.put("data", savedStudent);
//
//	    return new ResponseEntity<>(response, HttpStatus.CREATED);
//	}
	
	@GetMapping("/getStudent/{studentId}")
	public ResponseEntity<Student> getStudent(@PathVariable String studentId ) throws RecordNotFoundException{
		return new ResponseEntity<>(studentService.getStudent(studentId),HttpStatus.FOUND);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws RecordNotFoundException{
		return new ResponseEntity<>(studentService.updateStudent(student),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<Student>deleteStudent(@PathVariable String studentId) throws RecordNotFoundException{
		return new ResponseEntity<>(studentService.deleteStudent(studentId),HttpStatus.OK);
		
	}

}
