package com.thesischecker.services.impl;

import com.thesischecker.dao.interfaces.IResourcesDao;
import com.thesischecker.dto.ResourceEntity;
import com.thesischecker.services.interfaces.IResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Resources service implementation
 * @author Tomasz Morek
 */
@Service("resourcesService")
@Transactional(readOnly = true)
public class ResourcesService implements IResourcesService {

    @Autowired
    IResourcesDao resourcesDao;

    @Override
    public List<ResourceEntity> find() {
        String query = "From ResourceEntity";
        return null;
    }
}
