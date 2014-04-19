package com.thesischecker.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by awilczyn on 12.04.2014.
 */
public class AnalysisHasResourceEntityPK implements Serializable {

    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = -3023503394037795873L;

    private int analysisId;
    private int resourceId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AnalysisHasResourceEntityPK that = (AnalysisHasResourceEntityPK) o;

        if (analysisId != that.analysisId) {
            return false;
        }
        if (resourceId != that.resourceId) {
            return false;
        }

        return true;
    }

    @Column(name = "analysis_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getAnalysisId() {
        return analysisId;
    }

    @Column(name = "resource_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getResourceId() {
        return resourceId;
    }

    @Override
    public int hashCode() {
        int result = analysisId;
        result = 31 * result + resourceId;
        return result;
    }

    public void setAnalysisId(int analysisId) {
        this.analysisId = analysisId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
