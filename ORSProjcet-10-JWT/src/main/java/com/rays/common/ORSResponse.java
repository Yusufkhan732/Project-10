package com.rays.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Standard response wrapper for API.
 * Holds success flag and result data (message, data, errors).
 * 
 * @author Yusuf Khan
 */
public class ORSResponse {

	public static final String INPUT_ERROR = "inputerror";
	public static final String MESSAGE = "message";
	public static final String DATA = "data";

	private Map<String, Object> result = new HashMap<String, Object>();

	public boolean success = false;

	/**
	 * Default constructor.
	 */
	public ORSResponse() {
	}

	/**
	 * Constructor with success flag.
	 */
	public ORSResponse(boolean success) {
		this.success = success;
	}

	/**
	 * Constructor with success and message.
	 */
	public ORSResponse(boolean success, String message) {
		this.success = success;
		addMessage(message);
	}

	/**
	 * Constructor with success, message and data.
	 */
	public ORSResponse(boolean success, String message, Object value) {
		this.success = success;
		addMessage(message);
		addData(value);
	}

	/**
	 * Check success status.
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Set success status.
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * Get result map.
	 */
	public Map<String, Object> getResult() {
		return result;
	}

	/**
	 * Set result map.
	 */
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	/**
	 * Add validation errors.
	 */
	public void addInputError(Object value) {
		result.put(INPUT_ERROR, value);
	}

	/**
	 * Add message.
	 */
	public void addMessage(Object value) {
		result.put(MESSAGE, value);
	}

	/**
	 * Add data.
	 */
	public void addData(Object value) {
		result.put(DATA, value);
	}

	/**
	 * Add custom result key-value.
	 */
	public void addResult(String key, Object value) {
		result.put(key, value);
	}
}