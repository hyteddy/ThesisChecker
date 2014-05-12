package com.thesischecker.dao.interfaces;

import com.thesischecker.dto.AnalysisEntity;

import java.util.List;

/**
 * DAO interface to handle AnalysisEntity DTO
 */
public interface IAnalysisDao extends IAbstractDao<AnalysisEntity, String> {

    /**
     * Save analysis on DB
     * @param analysisEntity
     */
    void saveAnalysis(AnalysisEntity analysisEntity);

    /**
     * Find all analysis object
     * @return List
     */
    List<AnalysisEntity> findAllAnalysis();

    /**
     * Find analysis by ID
     * @param id
     * @return AnalysisEntity
     */
    AnalysisEntity findAnalyse(Long id);
}
