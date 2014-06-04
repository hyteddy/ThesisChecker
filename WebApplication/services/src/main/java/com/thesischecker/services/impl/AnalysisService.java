package com.thesischecker.services.impl;

import com.thesischecker.services.interfaces.IAnalysisService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Analysis service implementation
 */
@Service("analysisService")
@Transactional(readOnly = true)
public class AnalysisService implements IAnalysisService {

}
