package dhw.exception;

import dhw.consts.ErrorEnum;

public class MyException extends Exception{
	/**
	 * 2017年11月29日 下午6:35:27 段华微  
	 */
	private static final long serialVersionUID = 1L;
	
	private ErrorEnum errorMsg;
	
	public MyException() {
		super();
	}
	public ErrorEnum getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(ErrorEnum errorMsg) {
		this.errorMsg = errorMsg;
	}
	public MyException(ErrorEnum err) {
		super(err.getEcode() + "");
		this.errorMsg = err;
	}
	
	
}
