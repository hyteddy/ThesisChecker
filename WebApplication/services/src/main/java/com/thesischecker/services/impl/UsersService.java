package com.thesischecker.services.impl;

import com.thesischecker.dao.interfaces.IUsersDao;
import com.thesischecker.dto.UserEntity;
import com.thesischecker.dto.UserProfileEntity;
import com.thesischecker.services.interfaces.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tomasz Morek
 */
@Service
public class UsersService implements IUsersService {

    @Autowired
    private IUsersDao usersDao;

    @Override
    public List<UserProfileEntity> getFullNames() {
        return this.usersDao.getUsersFullName();
    }

    @Override
    public Long getUserId(String email) {
        UserEntity user = this.usersDao.getUserByEmail(email);
        return user.getId();
    }
}
