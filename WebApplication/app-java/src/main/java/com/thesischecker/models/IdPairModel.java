package com.thesischecker.models;

import java.io.Serializable;

/**
 * Created by Viciu on 2014-06-23.
 */
public class IdPairModel implements Serializable
{

    /**
     * Model name
     */
    public static final String MODEL_NAME = "idPairModel";

    /**
     * Resource Id
     */
    private Long id1;
    private long id2;

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public Long getId2() {
        return id2;
    }

    public void setId2(Long id2) {
        this.id2 = id2;
    }
}