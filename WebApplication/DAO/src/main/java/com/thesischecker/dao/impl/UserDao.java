package com.thesischecker.dao.impl;

import com.thesischecker.dto.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Paweł on 2014-06-16.
 */
public class UserDao extends AbstractDao{

    public UserEntity getUserByEmail(String email) {
        UserEntity user = (UserEntity) this.getSession().createQuery("from UserEntity where email=?").setString(0, email).uniqueResult();
        return user;
    }

    public void addUser(String email, String password){
        UserEntity user = new UserEntity();
        user.setEmail(email);

        generatePassword(user,password);

        user.setCreatedAt(new Timestamp(new Date().getTime()));
        user.setUpdatedAt(new Timestamp(new Date().getTime()));
        user.setActive(Byte.valueOf("1"));
        user.setRole("ROLE_PROMOTER");

        Session s = this.getSession();
        Transaction t = s.beginTransaction();
        s.save(user);
        t.commit();
    }

    private void generatePassword(UserEntity user, String password){
        RandomNumberGenerator rng = new SecureRandomNumberGenerator();
        Object salt = rng.nextBytes();

        String hashedPwd = new Sha256Hash(password, salt,1024).toBase64();

        user.setPassword(hashedPwd);
        user.setSalt(salt.toString());
    }

    public UserEntity getCurrentUser(){
        Subject currentUser = SecurityUtils.getSubject();

        if (currentUser.isAuthenticated()) {
            String mail = (String) currentUser.getSession().getAttribute("username");
            UserEntity user = getUserByEmail(mail);
            return user;
        } else {
            return null;
        }
    }

}
