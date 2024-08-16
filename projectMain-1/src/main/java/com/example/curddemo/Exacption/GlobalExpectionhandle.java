package com.example.curddemo.Exacption;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
@ControllerAdvice
public class GlobalExpectionhandle {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ModelAndView StudentNotFound(StudentNotFoundException ex , Model model) {
		
		
		ModelAndView mav = new ModelAndView("error");  //Display error page
		
		mav.addObject("message",ex.getMessage());
		
		return mav;
		
	}

}
