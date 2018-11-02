package org.almansa.web.intercepter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Controller
public class ContollerExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception ex) {
		ex.printStackTrace();
		return "error";
	}
}
