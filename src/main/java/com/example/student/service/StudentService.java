package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.exception.RecordNotFoundException;

public interface StudentService {

	Student createStudent(Student student);

	Student getStudent(String studentId) throws RecordNotFoundException;

	Student updateStudent(Student student) throws RecordNotFoundException;

	Student deleteStudent(String studentId) throws RecordNotFoundException;

}
