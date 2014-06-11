package com.thesischecker.services.interfaces;

import java.util.List;

import com.thesischecker.dto.ResourceEntity;

/**
 * Resources service interface
 * 
 * @author Tomasz Morek
 */
public interface IResourcesService {

    List<ResourceEntity> find();

    /**
     * Method for persistence {@link ResourceEntity} class.
     * 
     * @param resourceEntity
     * @throws Exception
     */
    void persistResources(ResourceEntity resourceEntity) throws Exception;
}
