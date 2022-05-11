package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.SchoolDAO;
import com.example.model.Student;
import com.example.model.StudentSubjectTopper;

@Transactional
@Service
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	private SchoolDAO schoolDao;
	

	@Override
	public List<Student> getTopThreeStudents() {
		
		List <Student> list = schoolDao.getAllStudentDetails();
		List <Student> result = list.stream().sorted((x,y) -> y.getTotalMarks() - x.getTotalMarks())
									.limit(3).toList();
		
		result.get(0).setRank(1);
		result.get(1).setRank(2);
		result.get(2).setRank(3);
		
		return result;
	}


	@Override
	public StudentSubjectTopper subjectTopper(String subject) throws Exception {
		
		if(!(subject.equalsIgnoreCase("Physics") || subject.equalsIgnoreCase("Chemistry") || subject.equalsIgnoreCase("Maths")))
			throw new Exception("SchoolService.INVALID_SUBJECT");
		
		List <Student> list = schoolDao.getAllStudentDetails();
		
		Stream <Student> str = list.stream();
		Student s = null;
		
		StudentSubjectTopper ss = new StudentSubjectTopper();
		
		if(subject.equalsIgnoreCase("Physics"))
			s = str.max((x,y) -> x.getPhyMarks()-y.getPhyMarks()).get();
		else if(subject.equalsIgnoreCase("Chemistry"))
			s = str.max((x,y) -> x.getChemMarks()-y.getChemMarks()).get();
		else
			s = str.max((x,y) -> x.getMathMarks()-y.getMathMarks()).get();
		
		ss.setId(s.getId());
		ss.setName(s.getName());
		ss.setSubjectTopperIn(subject);
		
		if(subject.equalsIgnoreCase("Physics"))
			ss.setSubjectMarks(s.getPhyMarks());
		else if(subject.equalsIgnoreCase("Chemistry"))
			ss.setSubjectMarks(s.getChemMarks());
		else
			ss.setSubjectMarks(s.getMathMarks());
		
		return ss;
	}

}
