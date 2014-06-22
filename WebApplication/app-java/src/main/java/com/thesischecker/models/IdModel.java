package com.thesischecker.models;

import java.io.Serializable;

/**
 * Created by Viciu on 2014-06-23.
 */
public class IdModel implements Serializable
{

    /**
     * Model name
     */
    public static final String MODEL_NAME = "idModel";

    /**
     * Resource Id
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
