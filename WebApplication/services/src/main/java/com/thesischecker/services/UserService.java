package com.thesischecker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesischecker.dto.UserEntity;
import com.thesischecker.implementation.UserEntityDAO;

/**
 * Implementation of @{link UserServiceInterace} class.
 * 
 * @author Michał Szczygieł <michal.szczygiel@wp.pl>
 * 
 */
@Service("userService")
public class UserService implements UserServiceInterace {

    @Autowired
    UserEntityDAO userEntityDAO;

    @Transactional(rollbackFor = Exception.class)
    public void persistUser(UserEntity userEntity) throws Exception {
        System.out.println("Persist User");
        userEntityDAO.persistUserEnity(userEntity);
    }

}
