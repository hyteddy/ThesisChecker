package com.thesischecker.dao.interfaces;

import com.thesischecker.dto.UserProfileEntity;

import java.util.List;

/**
 * @author Tomasz Morek
 */
public interface IUsersDao {

    /**
     * Find all users
     * @return Object[first_name, last_name, user_id]
     */
    List<UserProfileEntity> getUsersFullName();
}
