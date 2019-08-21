/**
 * @author sundonglin
 * @date 2018年9月27日 下午3:38:55
 */
package com.sdl.swagger.exception;

/**
 * @author sundonglin
 * @date 2018年9月27日 下午3:38:55
 */
public class BusinessException extends Exception {

	private String code;
	
	private String message;
	
	

	public BusinessException() {
		super();
	}

	public BusinessException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
}
