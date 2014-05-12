package com.thesischecker.dto;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by awilczyn on 12.04.2014.
 */
public class UserEntity {
    private Long id;
    private String email;
    private String salt;
    private String password;
    private String role;
    private String token;
    private Byte active;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private UserProfileEntity Profile;
    private Set<AnalysisEntity> analysisEntitySet = new HashSet<AnalysisEntity>();
    private Set<UserUpdateEntity> userUpdateEntitySet = new HashSet<UserUpdateEntity>();
    private Set<ResourceEntity> resourceEntitySet = new HashSet<ResourceEntity>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Set<AnalysisEntity> getAnalysisEntitySet() {
        return analysisEntitySet;
    }

    public void setAnalysisEntitySet(Set<AnalysisEntity> analysisEntitySet) {
        this.analysisEntitySet = analysisEntitySet;
    }

    public Set<UserUpdateEntity> getUserUpdateEntitySet() {
        return userUpdateEntitySet;
    }

    public void setUserUpdateEntitySet(Set<UserUpdateEntity> userUpdateEntitySet) {
        this.userUpdateEntitySet = userUpdateEntitySet;
    }

    public Set<ResourceEntity> getResourceEntitySet() {
        return resourceEntitySet;
    }

    public void setResourceEntitySet(Set<ResourceEntity> resourceEntitySet) {
        this.resourceEntitySet = resourceEntitySet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (deletedAt != null ? !deletedAt.equals(that.deletedAt) : that.deletedAt != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (salt != null ? !salt.equals(that.salt) : that.salt != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    public UserProfileEntity getProfile() {
        return Profile;
    }

    public void setProfile(UserProfileEntity profile) {
        Profile = profile;
    }
}
