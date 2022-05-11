package com.example.service;

import java.util.List;

import com.example.model.Student;
import com.example.model.StudentSubjectTopper;

public interface SchoolService {
	
	public List<Student> getTopThreeStudents();
	public StudentSubjectTopper subjectTopper(String subject) throws Exception;

}
