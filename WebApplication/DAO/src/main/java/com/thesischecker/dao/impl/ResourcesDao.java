package com.thesischecker.dao.impl;

import com.thesischecker.dao.interfaces.IResourcesDao;
import com.thesischecker.dto.ResourceEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Resources DAO implementation
 * @author Toamsz Morek
 */
@Repository
public class ResourcesDao extends AbstractDao<ResourceEntity>
                          implements IResourcesDao {

    /**
     * Constructor
     */
    protected ResourcesDao() {
        super(ResourceEntity.class);
    }

    @Override
    public List<ResourceEntity> findAllResources() {
        String query = "From ResourceEntity";
        return this.findByQuery(query);
    }
}
