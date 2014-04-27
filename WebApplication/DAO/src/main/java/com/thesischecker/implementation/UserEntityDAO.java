package com.thesischecker.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.thesischecker.dto.UserEntity;
import com.thesischecker.interfaces.UserEntityDAOInterface;

/**
 * Implementation of @{link UserEntityInterface} class.
 * 
 * @author Michał Szczygieł <michal.szczygiel@wp.pl>
 * 
 */
@Service
public class UserEntityDAO implements UserEntityDAOInterface {

    /**
     * Interface used to interact with the persistence context.
     */
    @PersistenceContext(unitName = "PersistenceUserEntity")
    private EntityManager entityManager;

    /**
     * This method overrides an existing method.
     * 
     * @see com.thesischecker.interfaces.UserEntityDAOInterface#persistUserEnity(com.thesischecker.dto.UserEntity)
     */
    @Override
    public void persistUserEnity(UserEntity userEntity) {
        entityManager.persist(userEntity);
    }

}
