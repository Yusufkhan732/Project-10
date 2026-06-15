package com.rays.common;

/**
 * Thread-local holder for UserContext.
 * Used to store user info per request/thread.
 * 
 * @author Yusuf Khan
 */
public class UserContextHolder {

	private static final ThreadLocal<UserContext> threadLocal = new ThreadLocal<>();

	/**
	 * Set user context in current thread.
	 */
	public static void setContext(UserContext context) {
		threadLocal.set(context);
	}

	/**
	 * Get user context of current thread.
	 */
	public static UserContext getContext() {
		return threadLocal.get();
	}

	/**
	 * Clear user context from thread.
	 */
	public static void clear() {
		threadLocal.remove();
	}

}