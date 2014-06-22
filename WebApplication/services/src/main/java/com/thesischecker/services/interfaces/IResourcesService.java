package com.thesischecker.services.interfaces;

import com.thesischecker.dto.ResourceEntity;

import java.util.Date;
import java.util.List;

/**
 * Resources service interface
 * 
 * @author Tomasz Morek
 */
public interface IResourcesService {

    List<ResourceEntity> find(Long userId, Date dateFrom, Date dateTo);

    /**
     * Method for persistence {@link ResourceEntity} class.
     * 
     * @param resourceEntity
     * @throws Exception
     */
    void persistResources(ResourceEntity resourceEntity) throws Exception;
}
