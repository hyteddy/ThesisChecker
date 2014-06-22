package com.thesischecker.dao.impl;

import com.thesischecker.dao.interfaces.IUsersDao;
import com.thesischecker.dto.UserEntity;
import com.thesischecker.dto.UserProfileEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tomasz Morek
 */
@Repository
public class UsersDao extends AbstractDao implements IUsersDao {

    @Override
    public List<UserProfileEntity> getUsersFullName() {
        String query = "Select userId, firstName, lastName " +
                       "From UserProfileEntity";
        List<Object[]> queryList = this.getSession().createQuery(query).list();
        List<UserProfileEntity> result = new ArrayList<UserProfileEntity>();
        for (Object[] object : queryList) {
            UserProfileEntity userProfileEntity = new UserProfileEntity();
            userProfileEntity.setUserId((Integer) object[0]);
            userProfileEntity.setFirstName((String) object[1]);
            userProfileEntity.setLastName((String) object[2]);
            result.add(userProfileEntity);
        }
        return result;
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        String query = "From UserEntity As usr Where usr.email = :email";
        UserEntity user = (UserEntity) getSession().createQuery(query)
                                    .setString("email", email).uniqueResult();
        return user;
    }
}
