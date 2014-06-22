package com.thesischecker.domain;

import com.thesischecker.dto.ResourceEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * Class represent resource record on result screen
 * @author Tomasz Morek
 */
public class Resource implements Serializable {

    /**
     * Name
     */
    private String name;

    /**
     * File type
     */
    private String fileType;

    /**
     * Upload use
     */
    private String user;

    /**
     * Upload date
     */
    private Date uploadDate;

    /**
     * Default constructor
     */
    public Resource() {
    }

    /**
     * Constructor
     * @param name
     * @param fileType
     * @param user
     * @param uploadDate
     */
    public Resource(String name, String fileType, String user, Date uploadDate) {
        this.name = name;
        this.fileType = fileType;
        this.user = user;
        this.uploadDate = uploadDate;
    }

    /**
     * Constructor
     * @param resourceEntity
     */
    public Resource(ResourceEntity resourceEntity) {
        this.name = resourceEntity.getName();
        this.fileType = resourceEntity.getFileType();
        this.uploadDate = resourceEntity.getUpdatedAt();
        /*if (resourceEntity.getUserEntity() != null) {
            this.user = resourceEntity.getUserEntity().getEmail();
        }*/
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

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
}
