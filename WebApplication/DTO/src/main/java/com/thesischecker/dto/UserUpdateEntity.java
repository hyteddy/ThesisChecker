package com.thesischecker.dto;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by awilczyn on 12.04.2014.
 */
@Entity
@Table(name = "user_update", schema = "", catalog = "thesis")
public class UserUpdateEntity {
    private int id;
    private Integer userId;
    private String token;
    private String type;
    private Collection<UserEntity> User;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = true, insertable = true, updatable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "token", nullable = true, insertable = true, updatable = true, length = 255)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "type", nullable = true, insertable = true, updatable = true, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserUpdateEntity that = (UserUpdateEntity) o;

        if (id != that.id) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "Updates")
    public Collection<UserEntity> getUser() {
        return User;
    }

    public void setUser(Collection<UserEntity> user) {
        User = user;
    }
}
