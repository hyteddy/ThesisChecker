package com.thesischecker.dao.interfaces;

import com.thesischecker.dto.ResourceEntity;

import java.util.Date;
import java.util.List;

/**
 * Resources DAO interface
 * 
 * @author Tomasz Morek
 */
public interface IResourcesDao {

    /**
     * Find Resources by query
     * @return List of resources
     */
    List<ResourceEntity> findByParameters(Long userId, Date dateFrom, Date dateTo);

    /**
     * Insert resource
     * @param resourceEntity
     * @return new resource ID
     */
    Long insert(ResourceEntity resourceEntity);

    /**
     * Find Resources by id
     *
     * @param resourceID
     * @return
     */
    public ResourceEntity findById(Long resourceID);

    /**
     * Find Resources other than given id
     *
     * @param resourceID
     * @return
     */
    public List<ResourceEntity> findOtherById(Long resourceID);

    /**
     * This method persist instance of {@link ResourceEntity}
     * 
     * @param resourceEntity
     */
    void persistResourceEntity(ResourceEntity resourceEntity);

}
