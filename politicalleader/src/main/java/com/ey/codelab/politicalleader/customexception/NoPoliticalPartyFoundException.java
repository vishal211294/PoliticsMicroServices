package com.ey.codelab.politicalleader.customexception;

public class NoPoliticalPartyFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoPoliticalPartyFoundException() {
		super();
	}

	public NoPoliticalPartyFoundException(String message) {
		super(message);
	}

}
