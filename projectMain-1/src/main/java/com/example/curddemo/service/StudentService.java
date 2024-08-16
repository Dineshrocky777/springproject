package com.example.curddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curddemo.Exacption.StudentNotFoundException;
import com.example.curddemo.Repository.StudentRepo;
import com.example.curddemo.entity.Student;



@Service
public class StudentService {
	
	@Autowired
	StudentRepo studentRepo;
	
	public void add(Student student) {
		studentRepo.save(student);
	}

	public Student read(int id) {
		if(!studentRepo.existsById( id)) {
			 
			 throw new StudentNotFoundException("Student with ID " + id + " not found.");
       }
		
		Optional<Student> s= studentRepo.findById(id);
		
		return s.orElse(null);
		
	
	}
	

	public List<Student> readall() {
		
		return studentRepo.findAll();
	}
	
	
	

	public void deleteall() {
		 
		studentRepo.deleteAll();
		
	}

	public void deleteById(int id) {
		
		if(!studentRepo.existsById( id)) {
			 
			 throw new StudentNotFoundException("Student with ID " + id + " not found.");
        }
		
		
		studentRepo.deleteById(id);
		
	}
	
	//update

	public void update(Student student) {
		studentRepo.save(student);
		
	}

	


	

	



	
		
		
	}

	

	
	


