
package com.example.student.exception;


public class RecordNotFoundException extends Exception {

	public RecordNotFoundException() {
		super();
	}

	public RecordNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public RecordNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public RecordNotFoundException(String arg0) {
		super(arg0);
	}

	public RecordNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
