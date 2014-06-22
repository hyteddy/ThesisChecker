package com.thesischecker.services.impl;

import com.thesischecker.comparator.Analysis;
import com.thesischecker.comparator.AnalysisHTMLConverter;
import com.thesischecker.comparator.DiffMatchPatchComparator;
import com.thesischecker.dao.interfaces.IResourcesDao;
import com.thesischecker.dto.ResourceEntity;
import com.thesischecker.services.interfaces.IAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Analysis service implementation
 */
@Service("analysisService")
@Transactional(readOnly = true)
public class AnalysisService implements IAnalysisService {

    @Autowired
    IResourcesDao resourcesDao;

    @Override
    public List<String> get(Long id1, Long id2)
    {
        ResourceEntity e1=this.resourcesDao.findById(id1);
        ResourceEntity e2=this.resourcesDao.findById(id2);
        String s1=e1.getPlainText();
        String s2=e2.getPlainText();
        DiffMatchPatchComparator dmpc = new DiffMatchPatchComparator();
        Analysis analysis=dmpc.compare(s1,s2);
        AnalysisHTMLConverter converter = new AnalysisHTMLConverter();
        converter.setAnalysis(analysis);

        String leftHTML = converter.getLeft();
        String rightHTML = converter.getRight();

        ArrayList<String> list = new ArrayList<String>();
        list.add(leftHTML);
        list.add(rightHTML);

        return list;
    }
}
