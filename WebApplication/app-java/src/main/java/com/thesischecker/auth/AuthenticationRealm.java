package com.thesischecker.auth;

import com.thesischecker.dao.impl.UserDao;
import com.thesischecker.dto.UserEntity;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;

/**
 * Created by Paweł on 2014-06-16.
 */
public class AuthenticationRealm extends JdbcRealm{
    @Override
    protected SaltedAuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // identify account to log to
        UsernamePasswordToken userPassToken = (UsernamePasswordToken) token;
        final String username = userPassToken.getUsername();

        if (username == null) {
            System.out.println("Username is null.");
            return null;
        }

        // read password hash and salt from db
        UserDao userDao = new UserDao();
        UserEntity user = userDao.getUserByEmail(username);

        if (user == null) {
            System.out.println("No account found for user [" + username + "]");
            return null;
        }

        // return salted credentials
        SaltedAuthenticationInfo info = new AuthInfo(username, user.getPassword(), user.getSalt());
        return info;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return true;
    }
}