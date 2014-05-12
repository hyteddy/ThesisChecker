package com.thesischecker.services.interfaces;

import com.thesischecker.dto.AnalysisEntity;

import java.util.List;

/**
 * Analysis service interface
 */
public interface IAnalysisService {

    /**
     *
     * @param analysisEntity
     * @return
     */
    void saveAnalysis(AnalysisEntity analysisEntity);

    List<AnalysisEntity> findAll();

    AnalysisEntity find(Long id);
}
