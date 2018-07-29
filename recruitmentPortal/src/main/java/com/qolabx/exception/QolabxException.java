package com.qolabx.exception;

public class QolabxException extends Exception {

	private static final long serialVersionUID = 1L;
	private Long errorId;
	private String errorMessage;

	public QolabxException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QolabxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public QolabxException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public QolabxException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public QolabxException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public QolabxException(Long errorId, String errorMessage) {
		super();
		this.errorId = errorId;
		this.errorMessage = errorMessage;
	}

	public Long getErrorId() {
		return errorId;
	}

	public void setErrorId(Long errorId) {
		this.errorId = errorId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
