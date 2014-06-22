package com.thesischecker.dao.impl;

import com.thesischecker.dao.interfaces.IResourcesDao;
import com.thesischecker.dto.ResourceEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> paramValues = new HashMap<String, Object>();
        String query = "From ResourceEntity As res " +
                       "Left Join Fetch res.userEntity ";
        boolean firstParam = true;
        if (userId != null && userId != -1) {
            query += getPrefix(firstParam) + " res.userEntity.id = :userId ";
            firstParam = false;
            paramValues.put("userId", userId);
        }
        if (dateFrom != null) {
            query += getPrefix(firstParam) + " res.createdAt >= :dateFrom ";
            firstParam = false;
            paramValues.put("dateFrom", dateFrom);
        }
        if (dateTo != null) {
            query += getPrefix(firstParam) + " res.createdAt <= :dateTo ";
            paramValues.put("dateTo", dateTo);
        }
        return getSession().createQuery(query).setProperties(paramValues).list();
    }

    @Override
    public List<ResourceEntity> findById(Long resourceID)
    {
        Map<String, Object> paramValues = new HashMap<String, Object>();
        String query = "From ResourceEntity As res ";
        query += getPrefix(true) + " res.id = :resourceId";
        paramValues.put("resourceId",resourceID);
        return getSession().createQuery(query).setProperties(paramValues).list();
    }

    @Override
    public List<ResourceEntity> findOtherById(Long resourceID)
    {
        Map<String, Object> paramValues = new HashMap<String, Object>();
        String query = "From ResourceEntity As res ";
        query += getPrefix(true) + " res.id != :resourceId";
        paramValues.put("resourceId",resourceID);
        return getSession().createQuery(query).setProperties(paramValues).list();
    }

    @Override
    public Long insert(ResourceEntity resourceEntity) {
        Long id = (Long) getSession().save(resourceEntity);
        return id;
    }

    @Override
    public void persistResourceEntity(ResourceEntity resourceEntity) {
        entityManager.persist(resourceEntity);
    }
}
