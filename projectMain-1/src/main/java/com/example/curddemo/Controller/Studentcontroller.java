package com.example.curddemo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.curddemo.entity.Student;
import com.example.curddemo.service.StudentService;

import org.springframework.ui.Model;




@Controller
public class Studentcontroller {
	
	@Autowired
    private StudentService studentService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/adduser")
    public String adduser() {
        return "adduser";
    }

    @GetMapping("/add")
    public String add(Student student) {
        studentService.add(student);
        return "added";
    }

    @GetMapping("/viewuser")
    public String viewuser() {
        return "viewuser";
    }
    
    
    
    //read user   model to used to view ans in fronend
    
    @GetMapping("/readuser")
     public  String readuser(@RequestParam("id") int id, Model model) {
    	
    Student student=studentService.read(id);
    	
    	model.addAttribute("Show",student);  // this used to get Show.id

    	  return "show";
    	
    }
    
 //delete by id
    
    @GetMapping("/delete")
    public String deletePage() {
        return "deletebyid";  // Render the delete page with a form to enter student ID
    }

    
    @GetMapping("/deletemain")
    public String Delete(@RequestParam("id") int id,Model model) {
    	
    	studentService.deleteById(id);
    	
		return "deleted";
    	
    }
    

  
  
       
    
    @GetMapping("/readAlluser")
    
    public String Readall(Model model) {
    	
    	List<Student> student = studentService.readall();
    	
    	model.addAttribute("all", student);
    	
    	
		return "readall";
    	
    }
   
    //update student 
    @GetMapping("/updatemain")
    public String editStudent(@RequestParam("id")int id,Model model) {
    	
    	Student student =studentService.read(id);
    	
    	model.addAttribute("student",student);
    	
		return "editStudent";
    }	
    
       @GetMapping("/update")
		public String updateStudent(@ModelAttribute Student student,Model model) {
			
			studentService.update(student);
			return "updated";
	}
    	
    
    
   
    
    
  //delete all
  @GetMapping("/deleteAll")
    
    public String deleteall() {
	  studentService.deleteall();
		return "deleteall";
	  
  }
    
    
}
