package com.thesischecker.interfaces;

import com.thesischecker.dto.UserEntity;

/**
 * Interface for persistence @{link UserEntity} class.
 * 
 * @author Michał Szczygieł <michal.szczygiel@wp.pl>
 * 
 */
public interface UserEntityDAOInterface {

    /**
     * This method persist instance of @{link UserEntity}.
     * 
     * @param userEntity
     */
    void persistUserEnity(UserEntity userEntity);

}
