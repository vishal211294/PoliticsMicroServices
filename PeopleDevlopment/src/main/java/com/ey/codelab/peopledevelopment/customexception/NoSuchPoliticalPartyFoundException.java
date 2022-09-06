package com.ey.codelab.peopledevelopment.customexception;

public class NoSuchPoliticalPartyFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoSuchPoliticalPartyFoundException() {
		super();
	}

	public NoSuchPoliticalPartyFoundException(String message) {
		super(message);
	}

}
