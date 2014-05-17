package com.thesischecker.dto;

import javax.persistence.*;

/**
 * Created by awilczyn on 17.05.2014.
 */
@Entity
@Table(name = "analysis_has_resource", schema = "", catalog = "thesis")
@IdClass(AnalysisHasResourceEntityPK.class)
public class AnalysisHasResourceEntity {
    private int analysisId;
    private int resourceId;

    @Id
    @Column(name = "analysis_id", nullable = false, insertable = true, updatable = true)
    public int getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(int analysisId) {
        this.analysisId = analysisId;
    }

    @Id
    @Column(name = "resource_id", nullable = false, insertable = true, updatable = true)
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
