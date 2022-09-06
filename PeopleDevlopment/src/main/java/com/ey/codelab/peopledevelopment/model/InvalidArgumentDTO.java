package com.ey.codelab.peopledevelopment.model;

import java.util.List;

public class InvalidArgumentDTO {
	private List<String> reasons;
	
	public List<String> getReasons() {
		return reasons;
	}
	
	public void setReasons(List<String> reasons) {
		this.reasons = reasons;
	}
	
	@Override
	public String toString() {
		return "InvalidArgumentDTO [reasons=" + reasons + "]";
	}
}
