package com.thesischecker.dao.impl;

import com.thesischecker.dao.interfaces.IAnalysisDao;
import com.thesischecker.dto.AnalysisEntity;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tomek on 28.04.2014.
 */
@Repository
public class AnalysisDao extends AbstractDao<AnalysisEntity> implements
        IAnalysisDao {

    /**
     * Constructor
     */
    protected AnalysisDao() {
        super(AnalysisEntity.class);
    }

    @Override
    public void saveAnalysis(AnalysisEntity analysisEntity) {
        this.saveOrUpdate(analysisEntity);
    }

    @Override
    public List<AnalysisEntity> findAllAnalysis() {
        return this.findByCriteria((Criterion) null);
    }

    @Override
    public AnalysisEntity findAnalyse(Long id) {
        return findById(id);
    }
}
