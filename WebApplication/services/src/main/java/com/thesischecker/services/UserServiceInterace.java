package com.thesischecker.services;

import com.thesischecker.dto.UserEntity;

/**
 * Interface for persistence @{link UserEntity} class.
 * 
 * @author Michał Szczygieł <michal.szczygiel@wp.pl>
 * 
 */
public interface UserServiceInterace {

    void persistUser(UserEntity userEntity) throws Exception;

}
