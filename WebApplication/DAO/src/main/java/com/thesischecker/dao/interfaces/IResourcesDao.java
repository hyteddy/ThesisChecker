package com.thesischecker.dao.interfaces;

import java.util.List;

import com.thesischecker.dto.ResourceEntity;

/**
 * Resources DAO interface
 * 
 * @author Tomasz Morek
 */
public interface IResourcesDao {

    /**
     * Find Resources by query
     * 
     * @param query
     * @return List of resources
     */
    List<ResourceEntity> findByQuery(String query);

    /**
     * This method persist instance of {@link ResourceEntity}
     * 
     * @param resourceEntity
     */
    void persistResourceEntity(ResourceEntity resourceEntity);

}
