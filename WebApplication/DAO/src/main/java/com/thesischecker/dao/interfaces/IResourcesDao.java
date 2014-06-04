package com.thesischecker.dao.interfaces;

import com.thesischecker.dto.ResourceEntity;

import java.util.List;

/**
 * Resources DAO interface
 * @author Tomasz Morek
 */
public interface IResourcesDao {

    /**
     * Find Resources by query
     * @param query
     * @return List of resources
     */
    List<ResourceEntity> findByQuery(String query);

}
