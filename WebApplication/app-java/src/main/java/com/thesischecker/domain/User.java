package com.thesischecker.domain;

import java.io.Serializable;

/**
 * Class represent user
 * @author Tomasz Morek
 */
public class User implements Serializable {

    /**
     * User ID
     */
    private Integer id;

    /**
     * First name
     */
    private String firstName;

    /**
     * Last name
     */
    private String lastName;

    /**
     * Default constructor
     */
    public User() {
    }

    /**
     * Constructor
     * @param id
     */
    public User(Integer id) {
        this.id = id;
    }

    /**
     * Constructor
     * @param id
     * @param firstName
     * @param lastName
     */
    public User(Integer id, String firstName, String lastName) {
        this(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Ger user full name
     * @return lastName + firstName
     */
    public String getFullName() {
        return this.lastName + " " + this.firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
