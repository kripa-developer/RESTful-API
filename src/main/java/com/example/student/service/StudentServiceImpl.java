package com.example.student.service;

import java.util.Optional;

import org.apache.catalina.authenticator.SavedRequest;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.student.entity.Student;
import com.example.student.exception.RecordNotFoundException;
import com.example.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		Student entity = new Student();
		entity.setStudentId(student.getStudentId());
		entity.setName(student.getName());
		entity.setAge(student.getAge());
		entity.setAddress(student.getAddress());
		entity.setGrade(student.getGrade());
		entity.setPhoneNumber(student.getPhoneNumber());

		Student savedEntity = studentRepository.save(entity);

		return savedEntity;

	}

	@Override
	public Student getStudent(String studentId) throws RecordNotFoundException {
		Optional<Student> entity=studentRepository.findById(studentId);
		if(entity.isPresent()) {
			return entity.get();
		}
		else {
			throw new RecordNotFoundException("Record Not found");
		}
		
	}

	@Override
	public Student updateStudent(Student student) throws RecordNotFoundException {
	
		Optional<Student> entity=studentRepository.findById(student.getStudentId());
		if(entity.isPresent()) {
			Student existingStud=entity.get(); 
			existingStud.setAddress(student.getAddress());
			existingStud.setAge(student.getAge());
			existingStud.setGrade(student.getGrade());
			existingStud.setName(student.getName());
			existingStud.setPhoneNumber(student.getPhoneNumber());
			
			Student savedEntity=studentRepository.save(existingStud);
			return savedEntity;
		}
		else {
			throw new RecordNotFoundException("Record not found");
		}
		
	}

	@Override
	public Student deleteStudent(String studentId) throws RecordNotFoundException {
		Optional<Student> student=studentRepository.findById(studentId);
		if(student.isPresent()) {
			studentRepository.deleteById(studentId);
		}
		else {
			throw new RecordNotFoundException("Not found");
		}
		return null;
	}

}
