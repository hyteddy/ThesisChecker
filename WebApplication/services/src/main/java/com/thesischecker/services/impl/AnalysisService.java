package com.thesischecker.services.impl;

import com.thesischecker.dao.interfaces.IAnalysisDao;
import com.thesischecker.dto.AnalysisEntity;
import com.thesischecker.services.interfaces.IAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Analysis service implementation
 */
@Service("analysisService")
@Transactional(readOnly = true)
public class AnalysisService implements IAnalysisService {

    @Autowired
    private IAnalysisDao analysisDaoInterface;

    @Override
    public void saveAnalysis(AnalysisEntity analysisEntity) {
        this.analysisDaoInterface.saveAnalysis(analysisEntity);
    }

    @Override
    public List<AnalysisEntity> findAll() {
        return this.analysisDaoInterface.findAllAnalysis();
    }

    @Override
    public AnalysisEntity find(Long id) {
        return this.analysisDaoInterface.findAnalyse(id);
    }
}
