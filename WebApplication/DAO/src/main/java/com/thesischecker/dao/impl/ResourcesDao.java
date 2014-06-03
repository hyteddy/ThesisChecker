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
public class ResourcesDao extends AbstractDao implements IResourcesDao {

    /**
     * Constructor
     */
    protected ResourcesDao() {
        super();
    }

    @Override
    public List<ResourceEntity> findByQuery(String query) {
        List<ResourceEntity> result = this.getSession().createQuery(query).list();
        return result;
    }
}
