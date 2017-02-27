package com.dominus.dominus;

//exception class for invalid input
public class InvalidInputException extends Exception {


	public InvalidInputException () {

    }

    public InvalidInputException (String message) {
        super (message);
    }

    public InvalidInputException (Throwable cause) {
        super (cause);
    }

    public InvalidInputException (String message, Throwable cause) {
        super (message, cause);
    }
}
