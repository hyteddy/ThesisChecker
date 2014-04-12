package com.thesischecker.controller;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by awilczyn on 12.04.2014.
 */
public class AnalysisHasResourceEntityPK implements Serializable {
    private int analysisId;
    private int resourceId;

    @Column(name = "analysis_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(int analysisId) {
        this.analysisId = analysisId;
    }

    @Column(name = "resource_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnalysisHasResourceEntityPK that = (AnalysisHasResourceEntityPK) o;

        if (analysisId != that.analysisId) return false;
        if (resourceId != that.resourceId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = analysisId;
        result = 31 * result + resourceId;
        return result;
    }
}
