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

    /**
     * Find resources by params
     * @param userId
     * @param dateFrom
     * @param dateTo
     * @return
     */
    List<ResourceEntity> find(Long userId, Date dateFrom, Date dateTo);

    public List<ResourceEntity> get(Long id);

    /**
     * Save resource on db and file system
     * @param name
     * @param fileType
     * @param filePath
     * @param plainText
     * @param createdAt
     * @param userId
     * @return
     */
    Long save(String name, String fileType, String filePath,
              String plainText, Date createdAt, Long userId);

    /**
     * Method for persistence {@link ResourceEntity} class.
     * 
     * @param resourceEntity
     * @throws Exception
     */
    void persistResources(ResourceEntity resourceEntity) throws Exception;
}
