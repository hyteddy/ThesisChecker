package com.thesischecker.dao.impl;

import com.thesischecker.dao.interfaces.IAnalysisDao;
import org.springframework.stereotype.Repository;

/**
 * Analysis DAO implementation
 * @author Tomasz Morek
 */
@Repository
public class AnalysisDao extends AbstractDao implements IAnalysisDao {

    /**
     * Constructor
     */
    protected AnalysisDao() {
        super();
    }
}
