package com.thesischecker.dto;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by awilczyn on 12.04.2014. 
 */
@Entity
@Table(name = "user", schema = "", catalog = "thesis")
public class UserEntity {
    private Byte active;
    private AnalysisEntity Analysis;
    private Timestamp createdAt;
    private Timestamp deletedAt;
    private String email;
    private int id;
    private String password;
    private UserProfileEntity Profile;
    private ResourceEntity Resources;
    private String role;
    private String salt;
    private String token;
    private Timestamp updatedAt;
    private UserUpdateEntity Updates;

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

    @Basic
    @Column(name = "active", nullable = true, insertable = true, updatable = true)
    public Byte getActive() {
        return active;
    }

    @ManyToOne(targetEntity = AnalysisEntity.class)
    public AnalysisEntity getAnalysis() {
        return Analysis;
    }

    @Basic
    @Column(name = "created_at", nullable = false, insertable = true, updatable = true)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @Basic
    @Column(name = "deleted_at", nullable = true, insertable = true, updatable = true)
    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    @Basic
    @Column(name = "email", nullable = true, insertable = true, updatable = true, length = 255)
    public String getEmail() {
        return email;
    }

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    @Basic
    @Column(name = "password", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPassword() {
        return password;
    }

    @OneToOne(targetEntity = UserProfileEntity.class)
    public UserProfileEntity getProfile() {
        return Profile;
    }

    @ManyToOne(targetEntity = ResourceEntity.class)
    public ResourceEntity getResources() {
        return Resources;
    }

    @Basic
    @Column(name = "role", nullable = true, insertable = true, updatable = true, length = 255)
    public String getRole() {
        return role;
    }

    @Basic
    @Column(name = "salt", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSalt() {
        return salt;
    }

    @Basic
    @Column(name = "token", nullable = true, insertable = true, updatable = true, length = 255)
    public String getToken() {
        return token;
    }

    @Basic
    @Column(name = "updated_at", nullable = false, insertable = true, updatable = true)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    @ManyToOne(targetEntity = UserUpdateEntity.class)
    public UserUpdateEntity getUpdates() {
        return Updates;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (deletedAt != null ? deletedAt.hashCode() : 0);
        return result;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public void setAnalysis(AnalysisEntity analysis) {
        Analysis = analysis;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfile(UserProfileEntity profile) {
        Profile = profile;
    }

    public void setResources(ResourceEntity resources) {
        Resources = resources;
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

    public void setUpdates(UserUpdateEntity updates) {
        Updates = updates;
    }
}
