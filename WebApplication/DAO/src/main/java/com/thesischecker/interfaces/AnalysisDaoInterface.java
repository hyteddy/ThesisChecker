package com.thesischecker.interfaces;

import com.thesischecker.dto.AnalysisEntity;

import java.util.List;

/**
 * DAO interface to handle AnalysisEntity DTO
 */
public interface AnalysisDaoInterface extends
        AbstractDaoInterface<AnalysisEntity, String> {

    /**
     * Save analysis on DB
     * @param analysisEntity
     */
    void saveAnalysis(AnalysisEntity analysisEntity);

    /**
     * Find all analysis object
     * @return List
     */
    List<AnalysisEntity> findAll();

    /**
     * Find analysis by ID
     * @param id
     * @return AnalysisEntity
     */
    AnalysisEntity find(Long id);
}
