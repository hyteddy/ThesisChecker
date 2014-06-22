package com.thesischecker.domain;

import java.io.Serializable;

/**
 * File object
 * @author Tomasz Morek
 */
public class File implements Serializable {

    /**
     * File ID
     */
    Long id;

    /**
     * File name
     */
    String name;

    /**
     * File type
     */
    String type;

    /**
     * Default constructor
     */
    public File() {
    }

    /**
     * Constructor
     * @param id
     */
    public File(Long id) {
        this.id = id;
    }

    /**
     * Constructor
     * @param id
     * @param name
     */
    public File(Long id, String name) {
        this(id);
        this.name = name;
    }

    /**
     * Constructor
     * @param name
     * @param type
     */
    public File(String name, String type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Constructor
     * @param id
     * @param name
     * @param type
     */
    public File(Long id, String name, String type) {
        this(id, name);
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
