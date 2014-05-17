package com.thesischecker.extractor;

public class DocumentInformationException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = -3641575933111330831L;

    /**
     * @see Exception#Exception()
     */
    public DocumentInformationException() {
        super();
    }

    /**
     * @see Exception#Exception(String message)
     */
    public DocumentInformationException(String message) {
        super(message);
    }

    /**
     * @see Exception#Exception(String message, Throwable cause)
     */
    public DocumentInformationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @see Exception#Exception(Throwable cause)
     */
    public DocumentInformationException(Throwable cause) {
        super(cause);
    }
}