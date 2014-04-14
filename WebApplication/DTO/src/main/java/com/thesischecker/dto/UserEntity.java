package com.thesischecker.dto;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by awilczyn on 12.04.2014.
 */
@Entity
@Table(name = "user", schema = "", catalog = "thesis")
public class UserEntity {
    private int id;
    private String email;
    private String salt;
    private String password;
    private String role;
    private String token;
    private Byte active;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private AnalysisEntity Analysis;
    private UserProfileEntity Profile;
    private UserUpdateEntity Updates;
    private ResourceEntity Resources;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = true, insertable = true, updatable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "salt", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "password", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role", nullable = true, insertable = true, updatable = true, length = 255)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
    @Column(name = "active", nullable = true, insertable = true, updatable = true)
    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    @Basic
    @Column(name = "created_at", nullable = false, insertable = true, updatable = true)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at", nullable = false, insertable = true, updatable = true)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Basic
    @Column(name = "deleted_at", nullable = true, insertable = true, updatable = true)
    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
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

    @ManyToOne
    public AnalysisEntity getAnalysis() {
        return Analysis;
    }

    public void setAnalysis(AnalysisEntity analysis) {
        Analysis = analysis;
    }

    @OneToOne
    public UserProfileEntity getProfile() {
        return Profile;
    }

    public void setProfile(UserProfileEntity profile) {
        Profile = profile;
    }

    @ManyToOne
    public UserUpdateEntity getUpdates() {
        return Updates;
    }

    public void setUpdates(UserUpdateEntity updates) {
        Updates = updates;
    }

    @ManyToOne
    public ResourceEntity getResources() {
        return Resources;
    }

    public void setResources(ResourceEntity resources) {
        Resources = resources;
    }
}
