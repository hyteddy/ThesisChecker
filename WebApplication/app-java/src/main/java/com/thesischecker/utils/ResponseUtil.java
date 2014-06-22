package com.thesischecker.utils;

import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Response util to represent response in view
 * @author Tomasz Morek
 */
public class ResponseUtil {

    /**
     * Success status
     */
    private static final String STATUS_ERROR = "ERROR";

    /**
     * Error status
     */
    private static final String STATUS_SUCCESS = "SUCCESS";

    /**
     * Response status (SUCCESS | ERROR)
     */
    private String status;

    /**
     * Response result list
     */
    private List<Object> list;

    /**
     * Errors list
     */
    private List<ObjectError> errors;

    /**
     * Success message
     */
    private String successMessage;

    /**
     * Error message
     */
    private String errorMessage;

    /**
     * Default connstructor
     */
    public ResponseUtil() {
    }

    /**
     * Constructor to create success response with message without a list
     * f.eg. if result list is empty
     * @param successMessage
     */
    public ResponseUtil(String successMessage) {
        this.status = STATUS_SUCCESS;
        this.successMessage = successMessage;
    }

    /**
     * Constructor to create success response without message
     * @param list
     */
    public ResponseUtil(List<Object> list) {
        this.status = STATUS_SUCCESS;
        this.list = list;
    }

    /**
     * Constructor to create success response with message
     * @param list
     * @param successMessage
     */
    public ResponseUtil(List<Object> list, String successMessage) {
        this(list);
        this.successMessage = successMessage;
    }

    /**
     * Constructor to create error response
     * @param errorMessage
     * @param errors
     */
    public ResponseUtil(String errorMessage, List<ObjectError> errors) {
        this.errorMessage = errorMessage;
        this.errors = errors;
        this.status = STATUS_ERROR;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
