package com.jsp.springBoot_actor.utility;

public class ErrorStructure {

	private int status;
	private String message;
	private String rootcause;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRootcause() {
		return rootcause;
	}
	public void setRootcause(String rootcause) {
		this.rootcause = rootcause;
	}


	public  static ErrorStructure create(int status,String message,String rootcause) {
		ErrorStructure structure = new ErrorStructure();
		structure.setRootcause(rootcause);
		structure.setMessage(message);
		structure.setStatus(status);


		return structure;
		
	}
}
