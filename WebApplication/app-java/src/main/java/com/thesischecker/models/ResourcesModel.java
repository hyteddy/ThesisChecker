package com.thesischecker.models;

import com.thesischecker.domain.User;
import com.thesischecker.dto.UserProfileEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Thesis model class
 * @author Tomasz Morek
 */
public class ResourcesModel implements Serializable {

    /**
     * Model name
     */
    public static final String MODEL_NAME = "resourcesModel";

    /**
     * Resource userId
     */
    private Long userId;

    /**
     * Upload date from
     */
    private Date dateFrom;

    /**
     * Upload date to
     */
    private Date dateTo;

    /**
     * Users list
     */
    private List<User> usersList;

    /**
     * Default constructor
     */
    public ResourcesModel() {
    }

    public ResourcesModel(List<UserProfileEntity> users) {
        this.usersList = new ArrayList<User>();
        for (UserProfileEntity object : users) {
            User user = new User(object.getUserId(), object.getFirstName(), object.getLastName());
            this.usersList.add(user);
        }
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }
}
