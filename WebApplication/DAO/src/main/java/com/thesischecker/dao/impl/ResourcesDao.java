package com.thesischecker.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.thesischecker.dao.interfaces.IResourcesDao;
import com.thesischecker.dto.ResourceEntity;

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
    public List<ResourceEntity> findByQuery(String query) {
        List<ResourceEntity> result = this.getSession().createQuery(query)
                .list();
        return result;
    }

    @Override
    public void persistResourceEntity(ResourceEntity resourceEntity) {
        entityManager.persist(resourceEntity);
    }
}
