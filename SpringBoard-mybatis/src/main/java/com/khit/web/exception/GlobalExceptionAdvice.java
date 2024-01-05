package com.khit.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice // ������ ó���ϴ� �ֿ� Ŭ����
public class GlobalExceptionAdvice {	
	
	// ���� ó��(�ڵ� �� ���� ����) 500
	@ExceptionHandler(Exception.class)
	public String handleException(Exception exception, Model model) {
		model.addAttribute("exception", exception);
		return "/exception/global_error";
	}

	// ���� ó��(������ ã�� �� ����) 404
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		return "/exception/error_404";
	}
}
