package com.thesischecker.extractor;

/**
 * PDF extractor exception
 * @author Bartlomiej Sadkiewicz
 */
public class TextExtractorException extends Exception {
	
	/**
	 * @see Exception#Exception()
	 */
	public TextExtractorException() {
		super();
	}

	/**
	 * @see Exception#Exception(String message)
	 */
	public TextExtractorException(String message) {
		super(message);
	}

	/**
	 * @see Exception#Exception(String message, Throwable cause)
	 */
	public TextExtractorException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @see Exception#Exception(Throwable cause)
	 */
	public TextExtractorException(Throwable cause) {
		super(cause);
	}
}