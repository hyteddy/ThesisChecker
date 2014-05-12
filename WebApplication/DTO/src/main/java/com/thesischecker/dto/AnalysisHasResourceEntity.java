package com.thesischecker.dto;

/**
 * Created by awilczyn on 12.04.2014.
 */
public class AnalysisHasResourceEntity {
    private int analysisId;
    private int resourceId;

    public int getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(int analysisId) {
        this.analysisId = analysisId;
    }

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

        AnalysisHasResourceEntity that = (AnalysisHasResourceEntity) o;

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
