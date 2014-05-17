package com.thesischecker.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Thesis model class
 * @author Tomasz Morek
 */
public class ResourcesModel implements Serializable {

    public static final String MODEL_NAME = "resourcesModel";

    /**
     * Resource name
     */
    private String name;

    /**
     * Filetype
     */
    private String fileType;

    /**
     * User that create resource
     */
    private String user;

    /**
     * Resource create date
     */
    private Date creationDate;

    /**
     * Default constructor
     */
    public ResourcesModel() {
    }

    /**
     * Constructor
     * @param name
     * @param fileType
     * @param user
     * @param creationDate
     */
    public ResourcesModel(String name, String fileType, String user, Date creationDate) {
        this.name = name;
        this.fileType = fileType;
        this.user = user;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
