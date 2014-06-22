package com.thesischecker.auth;

import com.thesischecker.dao.impl.UserDao;
import com.thesischecker.dto.UserEntity;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Collection;
import java.util.List;

/**
 * Created by Paweł on 2014-06-22.
 */
public class AuthPermissionCheck implements Authorizer {

    @Override
    public boolean isPermitted(PrincipalCollection principalCollection, String s) {
        return false;
    }

    @Override
    public boolean isPermitted(PrincipalCollection principalCollection, Permission permission) {
        return false;
    }

    @Override
    public boolean[] isPermitted(PrincipalCollection principalCollection, String... strings) {
        return new boolean[0];
    }

    @Override
    public boolean[] isPermitted(PrincipalCollection principalCollection, List<Permission> permissions) {
        return new boolean[0];
    }

    @Override
    public boolean isPermittedAll(PrincipalCollection principalCollection, String... strings) {
        return false;
    }

    @Override
    public boolean isPermittedAll(PrincipalCollection principalCollection, Collection<Permission> permissions) {
        return false;
    }

    @Override
    public void checkPermission(PrincipalCollection principalCollection, String s) throws AuthorizationException {

    }

    @Override
    public void checkPermission(PrincipalCollection principalCollection, Permission permission) throws AuthorizationException {

    }

    @Override
    public void checkPermissions(PrincipalCollection principalCollection, String... strings) throws AuthorizationException {

    }

    @Override
    public void checkPermissions(PrincipalCollection principalCollection, Collection<Permission> permissions) throws AuthorizationException {

    }

    @Override
    public boolean hasRole(PrincipalCollection principalCollection, String s) {
        UserDao u = new UserDao();
        UserEntity user = u.getUserByEmail(principalCollection.getPrimaryPrincipal().toString());
        System.out.println("principalCollection.getPrimaryPrincipal().toString()");
        return s.equals(user.getRole());
    }

    @Override
    public boolean[] hasRoles(PrincipalCollection principalCollection, List<String> strings) {
        return new boolean[0];
    }

    @Override
    public boolean hasAllRoles(PrincipalCollection principalCollection, Collection<String> strings) {
        return false;
    }

    @Override
    public void checkRole(PrincipalCollection principalCollection, String s) throws AuthorizationException {

    }

    @Override
    public void checkRoles(PrincipalCollection principalCollection, Collection<String> strings) throws AuthorizationException {

    }

    @Override
    public void checkRoles(PrincipalCollection principalCollection, String... strings) throws AuthorizationException {

    }
}
