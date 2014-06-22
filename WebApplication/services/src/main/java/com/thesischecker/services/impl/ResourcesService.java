package com.thesischecker.services.impl;

import com.thesischecker.dao.interfaces.IResourcesDao;
import com.thesischecker.dto.ResourceEntity;
import com.thesischecker.services.interfaces.IResourcesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Resources service implementation
 * 
 * @author Tomasz Morek
 */
@Service("resourcesService")
@Transactional(readOnly = true)
public class ResourcesService implements IResourcesService {

    /**
     * Logger for monitoring runtime.
     */
    private static final Logger log = LoggerFactory
            .getLogger(ResourcesService.class);

    @Autowired
    IResourcesDao resourcesDao;

    @Override
    public List<ResourceEntity> find(Long userId, Date dateFrom, Date dateTo) {
        return this.resourcesDao.findByParameters(userId, dateFrom, dateTo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void persistResources(ResourceEntity resourceEntity)
            throws Exception {
        log.info("Persist Resources");
        resourcesDao.persistResourceEntity(resourceEntity);
        log.info("Persist Resources - OK");
    }
}
