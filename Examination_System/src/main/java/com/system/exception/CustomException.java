package com.system.exception;
/**
 * 系统自定义异常类，针对预期异常，需要在程序中抛出此类的异常
 * @author 李鹏龙
 *
 */
public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;
	//异常信息
    public String message;

    public CustomException(String message) {
        super(message);
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
