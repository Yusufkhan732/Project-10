package com.rays.common;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rays.exception.UnauthorizedException;

/**
 * Handles application propagated exceptions
 * 
 * Yusuf Khan
 *
 */

@RestControllerAdvice
public class ApplicationExceptionHandlerCtl {

	// 401
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<ORSResponse> handleUnauthorized(UnauthorizedException e) {

		ORSResponse res = new ORSResponse(false);
		res.addMessage(e.getMessage());

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
	}

	// 403
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ORSResponse> handleAccessDenied(AccessDeniedException e) {

		ORSResponse res = new ORSResponse(false);
		res.addMessage("Access denied");

		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(res);
	}

	// 503
	@ExceptionHandler({ CannotCreateTransactionException.class, DataAccessResourceFailureException.class,
			JDBCConnectionException.class })
	public ResponseEntity<ORSResponse> handleDatabaseException(Exception e) {

		ORSResponse res = new ORSResponse(false);
		res.addMessage("Database server is down try after some time...");

		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(res);
	}

	// 500
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ORSResponse> handleException(Exception e) {

		ORSResponse res = new ORSResponse(false);
		res.addMessage("Internal server error");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
	}
}