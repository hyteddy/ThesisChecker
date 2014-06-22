package com.thesischecker.models;

import com.thesischecker.domain.User;
import com.thesischecker.dto.UserProfileEntity;

import java.io.Serializable;
import java.util.ArrayList;
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
    private String dateFrom;

    /**
     * Upload date to
     */
    private String dateTo;

    /**
     * Users list
     */
    private List<User> usersList;

    /**
     * Default constructor
     */
    public ResourcesModel() {
    }

    /**
     * Constructor
     * @param userId
     * @param dateFrom
     * @param dateTo
     */
    public ResourcesModel(Long userId, String dateFrom, String dateTo) {
        this.userId = userId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    /**
     * Constructor
     * @param users
     */
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

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }
}
