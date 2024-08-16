package com.example.curddemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Student_ID")
	private Integer id;
	
	@Column(name="Student_Name")
	private String name;
	
	@Column(name="Student_course")
	private String course;
	
	@Column(name="Student_fess")
	private Integer fees;

	
}
