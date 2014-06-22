package com.thesischecker.auth;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * Created by Paweł on 2014-06-21.
 */
public class AuthCreditentialMatcher implements CredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        SaltedAuthenticationInfo infoSalt = (SaltedAuthenticationInfo) info;

        Object salt = infoSalt.getCredentialsSalt().getBytes();
        String tokenhash = new Sha256Hash(userToken.getCredentials(),salt,1024).toBase64();

        return tokenhash.equals(infoSalt.getCredentials());
    }
}
