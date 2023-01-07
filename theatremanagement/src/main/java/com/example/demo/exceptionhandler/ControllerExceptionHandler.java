package com.example.demo.exceptionhandler;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorMessage> NotFoundException(NotFoundException ex, WebRequest webRequest) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(),
				webRequest.getDescription(false));
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);

	}

//	@ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
//    public ResponseEntity<ErrorMessage> handleBindingErrors(MethodArgumentNotValidException ex) {
//		List<String> errorList = ex
//                .getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(fieldError -> fieldError.getDefaultMessage())
//                .collect(Collectors.toList());
//		ErrorMessage errorResponse = new ErrorMessage(errorList.toString(), HttpStatus.BAD_REQUEST.toString());
//		return new ErrorMessage<ErrorMessage>(errorResponse, HttpStatus.BAD_REQUEST);
//    }

}
