package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.SchoolDAO;
import com.example.model.Student;

@Transactional
@Service
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	private SchoolDAO schoolDao;

	@Override
	public List<Student> getTopThreeStudents() {
		
		List <Student> list = schoolDao.getAllStudentDetails();
		List <Student> result = list.stream().sorted((x,y) -> (y.getChemMarks() + y.getMathMarks() + y.getPhyMarks()) - (x.getChemMarks() + x.getMathMarks() + x.getPhyMarks()))
									.limit(3).toList();
		
		return result;
	}

	@Override
	public Student subjectTopper(String subject) throws Exception {
		
		if(!(subject.equalsIgnoreCase("Physics") || subject.equalsIgnoreCase("Chemistry") || subject.equalsIgnoreCase("Maths")))
			throw new Exception("SchoolService.INVALID_SUBJECT");
		
		List <Student> list = schoolDao.getAllStudentDetails();
		
		Stream <Student> str = list.stream();
		Student s = null;
		
		if(subject.equalsIgnoreCase("Physics"))
			s = str.max((x,y) -> x.getPhyMarks()-y.getPhyMarks()).get();
		else if(subject.equalsIgnoreCase("Chemistry"))
			s = str.max((x,y) -> x.getChemMarks()-y.getChemMarks()).get();
		else
			s = str.max((x,y) -> x.getMathMarks()-y.getMathMarks()).get();
		
		return s;
	}

}
