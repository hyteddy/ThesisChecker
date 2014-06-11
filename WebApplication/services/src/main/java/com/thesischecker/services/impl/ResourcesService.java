package com.thesischecker.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesischecker.dao.interfaces.IResourcesDao;
import com.thesischecker.dto.ResourceEntity;
import com.thesischecker.services.interfaces.IResourcesService;

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
    public List<ResourceEntity> find() {
        String query = "From ResourceEntity";
        return null;
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
