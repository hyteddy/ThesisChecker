package com.thesischecker.dto;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by awilczyn on 12.04.2014.
 */
public class UserEntity {
    private Byte active;
    private Set<AnalysisEntity> analysisEntitySet = new HashSet<AnalysisEntity>();
    private Timestamp createdAt;
    private Timestamp deletedAt;
    private String email;
    private Long id;
    private String password;
    private UserProfileEntity Profile;
    private Set<ResourceEntity> resourceEntitySet = new HashSet<ResourceEntity>();
    private String role;
    private String salt;
    private String token;
    private Timestamp updatedAt;
    private Set<UserUpdateEntity> userUpdateEntitySet = new HashSet<UserUpdateEntity>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserEntity that = (UserEntity) o;

        if (id != that.id) {
            return false;
        }
        if (active != null ? !active.equals(that.active) : that.active != null) {
            return false;
        }
        if (createdAt != null ? !createdAt.equals(that.createdAt)
                : that.createdAt != null) {
            return false;
        }
        if (deletedAt != null ? !deletedAt.equals(that.deletedAt)
                : that.deletedAt != null) {
            return false;
        }
        if (email != null ? !email.equals(that.email) : that.email != null) {
            return false;
        }
        if (password != null ? !password.equals(that.password)
                : that.password != null) {
            return false;
        }
        if (role != null ? !role.equals(that.role) : that.role != null) {
            return false;
        }
        if (salt != null ? !salt.equals(that.salt) : that.salt != null) {
            return false;
        }
        if (token != null ? !token.equals(that.token) : that.token != null) {
            return false;
        }
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt)
                : that.updatedAt != null) {
            return false;
        }

        return true;
    }

    public Byte getActive() {
        return active;
    }

    public Set<AnalysisEntity> getAnalysisEntitySet() {
        return analysisEntitySet;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public UserProfileEntity getProfile() {
        return Profile;
    }

    public Set<ResourceEntity> getResourceEntitySet() {
        return resourceEntitySet;
    }

    public String getRole() {
        return role;
    }

    public String getSalt() {
        return salt;
    }

    public String getToken() {
        return token;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public Set<UserUpdateEntity> getUserUpdateEntitySet() {
        return userUpdateEntitySet;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public void setAnalysisEntitySet(Set<AnalysisEntity> analysisEntitySet) {
        this.analysisEntitySet = analysisEntitySet;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfile(UserProfileEntity profile) {
        Profile = profile;
    }

    public void setResourceEntitySet(Set<ResourceEntity> resourceEntitySet) {
        this.resourceEntitySet = resourceEntitySet;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUserUpdateEntitySet(Set<UserUpdateEntity> userUpdateEntitySet) {
        this.userUpdateEntitySet = userUpdateEntitySet;
    }
}