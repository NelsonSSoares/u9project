package com.ibmshop.userapi.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.PropertyNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.common.net.HttpHeaders;

import jakarta.transaction.TransactionalException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "GLOBAL_EXCEPTION_HANDLER")
@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private boolean printStackTrace;

	//private final MessageSource msgSource;
	
	
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException methodArgumentNotValidException, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),
				"Validation error. Check 'errors' field for details.");
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			errorResponse.addValidationError(fieldError.getField(), "Verifique se o campo foi preenchido corretamente!");
		}
		return ResponseEntity.unprocessableEntity().body(errorResponse);
	}
	//PropertyNotFoundException
	@ExceptionHandler(PropertyNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleIPropertyException(PropertyNotFoundException ex,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
				"Validation error. Check 'errors' field for details.");
		errorResponse.addValidationError("argument", ex.getMessage());
		return ResponseEntity.badRequest().body(errorResponse);
	}
	
	@ExceptionHandler(TransactionalException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleITransactionException(TransactionalException ex,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
				"Validation error. Check 'errors' field for details.");
		errorResponse.addValidationError("argument", ex.getMessage());
		return ResponseEntity.badRequest().body(errorResponse);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
				"Validation error. Check 'errors' field for details.");
		errorResponse.addValidationError("argument", ex.getMessage());
		return ResponseEntity.badRequest().body(errorResponse);
	}

//	@ExceptionHandler(Exception.class)
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	public ResponseEntity<Object> handleAllUncaughtException(Exception exception, WebRequest request) {
//		final String errorMessage = "Unknown error occurred";
//		log.error(errorMessage, exception);
//		return buildErrorResponse(exception, errorMessage, HttpStatus.INTERNAL_SERVER_ERROR, request);
//	}

	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleNullPointerException(Exception exception, WebRequest request) {
		final String errorMessage = "Invalid Args or Params";
		log.error(errorMessage, exception);
		return buildErrorResponse(exception, errorMessage, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ResponseEntity<Object> handleDataIntegrityViolationException(
			DataIntegrityViolationException dataIntegrityViolationException, WebRequest request) {
		String errorMessage = dataIntegrityViolationException.getMostSpecificCause().getMessage();
		log.error("Failed to save entity with integrity problems: " + errorMessage, dataIntegrityViolationException);
		return buildErrorResponse(dataIntegrityViolationException, errorMessage, HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public ResponseEntity<Object> handleConstraintViolationException(
			ConstraintViolationException constraintViolationException, WebRequest request) {
		log.error("Failed to validate element", constraintViolationException.getConstraintViolations());
		return buildErrorResponse(constraintViolationException, HttpStatus.UNPROCESSABLE_ENTITY, request);
	}

	@ExceptionHandler(ObjectNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handleObjectNotFoundException(ObjectNotFoundException objectNotFoundException,
			WebRequest request) {
		log.error("Failed to find the requested element", objectNotFoundException);
		return buildErrorResponse(objectNotFoundException, HttpStatus.NOT_FOUND, request);
	}
	
	private ResponseEntity<Object> buildErrorResponse(Exception exception, HttpStatus httpStatus, WebRequest request) {
		return buildErrorResponse(exception, exception.getMessage(), httpStatus, request);
	}

	private ResponseEntity<Object> buildErrorResponse(Exception exception, String message, HttpStatus httpStatus,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), message);
		if (this.printStackTrace) {
			errorResponse.setStackTrace(ExceptionUtils.getStackTrace(exception));
		}
		return ResponseEntity.status(httpStatus).body(errorResponse);
	}
	
	
	

}

//
////@ExceptionHandler(DataBindingViolationException.class)
////@ResponseStatus(HttpStatus.CONFLICT)
////public ResponseEntity<Object> handleDataBindingViolationException(
////      DataBindingViolationException dataBindingViolationException,
////      WebRequest request) {
////  log.error("Failed to save entity with associated data", dataBindingViolationException);
////  return buildErrorResponse(
////          dataBindingViolationException,
////          HttpStatus.CONFLICT,
////          request);
////}
////
////@ExceptionHandler(AuthenticationException.class)
////@ResponseStatus(HttpStatus.UNAUTHORIZED)
////public ResponseEntity<Object> handleAuthenticationException(
////      AuthenticationException authenticationException,
////      WebRequest request) {
////  log.error("Authentication error ", authenticationException);
////  return buildErrorResponse(
////          authenticationException,
////          HttpStatus.UNAUTHORIZED,
////          request);
////}
////
////@ExceptionHandler(AccessDeniedException.class)
////@ResponseStatus(HttpStatus.FORBIDDEN)
////public ResponseEntity<Object> handleAccessDeniedException(
////      AccessDeniedException accessDeniedException,
////      WebRequest request) {
////  log.error("Authorization error ", accessDeniedException);
////  return buildErrorResponse(
////          accessDeniedException,
////          HttpStatus.FORBIDDEN,
////          request);
////}
////
////@ExceptionHandler(AuthorizationException.class)
////@ResponseStatus(HttpStatus.FORBIDDEN)
////public ResponseEntity<Object> handleAuthorizationException(
////      AuthorizationException authorizationException,
////      WebRequest request) {
////  log.error("Authorization error ", authorizationException);
////  return buildErrorResponse(
////          authorizationException,
////          HttpStatus.FORBIDDEN,
////          request);
////}
//

////
////@Override
////public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
////      AuthenticationException exception) throws IOException, ServletException {
////  Integer status = HttpStatus.UNAUTHORIZED.value();
////  response.setStatus(status);
////  response.setContentType("application/json");
////  ErrorResponse errorResponse = new ErrorResponse(status, "Username or password are invalid");
////  response.getWriter().append(errorResponse.toJson());
////}
//@Override
//protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//		org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//
//	List<Problem.Campo> campos = new ArrayList<>();
//
//	for (ObjectError error : ex.getBindingResult().getAllErrors()) {
//		String nome = ((FieldError) error).getField();
//		String mensagem = msgSource.getMessage(error, LocaleContextHolder.getLocale());
//		campos.add(new Problem.Campo(nome, mensagem));
//	}
//
//	Problem problem = new Problem();
//	problem.setStatus(status.value());
//	problem.setDatahora(LocalDateTime.now());
//	problem.setTitulo("Não foi possível cadastrar o usuário. O campo é obrigatório. Verifique e tente novamente.");
//	problem.setCampos(campos);
//	return handleExceptionInternal(ex, problem, headers, status, request);
//}
//
//
//
//protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,
//		org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request, Problem... problem2) {
//
//	List<Problem.Campo> campos = new ArrayList<>();
//
//	for (ConstraintViolation<?> error : ex.getConstraintViolations()) {
//		String nome = ((FieldError) error).getField();
//		String mensagem = msgSource.getMessage((MessageSourceResolvable) error, LocaleContextHolder.getLocale());
//		campos.add(new Problem.Campo(nome, mensagem));
//	}
//
//	Problem problem = new Problem();
//	problem.setStatus(status.value());
//	problem.setDatahora(LocalDateTime.now());
//	problem.setTitulo("Não foi possível cadastrar o usuário. O campo é obrigatório. Verifique e tente novamente.");
//	problem.setCampos(campos);
//	return handleExceptionInternal(ex, problem, headers, status, request);
//}
