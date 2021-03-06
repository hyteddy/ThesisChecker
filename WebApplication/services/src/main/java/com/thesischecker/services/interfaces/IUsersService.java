package com.thesischecker.services.interfaces;

import com.thesischecker.dto.UserProfileEntity;

import java.util.List;

/**
 * @author Tomasz Morek
 */
public interface IUsersService {

    /**
     * Get full user names
     * @return
     */
    List<UserProfileEntity> getFullNames();
}
