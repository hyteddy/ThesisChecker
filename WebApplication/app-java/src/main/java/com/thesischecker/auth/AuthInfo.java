package com.thesischecker.auth;

import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.apache.shiro.codec.Base64;

/**
 * Created by Paweł on 2014-06-16.
 */
public class AuthInfo implements SaltedAuthenticationInfo {

    private final String username;
    private final String password;
    private final String salt;

    public AuthInfo(String username, String password, String salt){
        this.username = username;
        this.password = password;
        this.salt = salt;
    }

    @Override
    public ByteSource getCredentialsSalt() {
        return new SimpleByteSource(Base64.decode(salt));
    }

    @Override
    public PrincipalCollection getPrincipals() {
        PrincipalCollection coll = new SimplePrincipalCollection(username, username);
        return coll;
    }

    @Override
    public Object getCredentials() {
        return password;
    }
}
