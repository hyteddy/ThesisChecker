package com.thesischecker.dao.interfaces;

import com.thesischecker.dto.ResourceEntity;

import java.util.List;

/**
 * Resources DAO interface
 * @author Tomasz Morek
 */
public interface IResourcesDao extends IAbstractDao<ResourceEntity> {

    /**
     * Find all resources object
     * @return
     */
    List<ResourceEntity> findAllResources();
}
