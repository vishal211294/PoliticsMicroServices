package com.ey.codelab.politicalparty.model;


public class InvalidArgumentDTO {
	
	private java.util.List<String> reasons;

	public java.util.List<String> getReasons() {
		return reasons;
	}

	public void setReasons(java.util.List<String> reasons) {
		this.reasons = reasons;
	}

	@Override
	public String toString() {
		return "InvalidArgumentDTO [reasons=" + reasons + "]";
	}
	
}
