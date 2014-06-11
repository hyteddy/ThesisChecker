package com.thesischecker.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.thesischecker.dao.interfaces.IResourcesDao;
import com.thesischecker.dto.ResourceEntity;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Resources DAO implementation
 * 
 * @author Toamsz Morek
 */
@Service
public class ResourcesDao extends AbstractDao implements IResourcesDao {

    @PersistenceContext(unitName = "PersistenceUnitResources")
    private EntityManager entityManager;

    /**
     * Constructor
     */
    protected ResourcesDao() {
        super();
    }

    @Override
    public List<ResourceEntity> findByParameters(Long userId, Date dateFrom, Date dateTo) {
        return null;
    }

    @Override
    public void persistResourceEntity(ResourceEntity resourceEntity) {
        entityManager.persist(resourceEntity);
    }
}
