package com.thesischecker.dto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by awilczyn on 12.04.2014.
 */
@Entity
@Table(name = "analysis", schema = "", catalog = "thesis")
public class AnalysisEntity {
    private int id;
    private Timestamp date;
    private String description;
    private BigDecimal result;
    private String fileType;
    private String filePath;
    private String plainText;
    private Integer userId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private Collection<UserEntity> User;
    private Collection<ResourceEntity> Resources;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date", nullable = true, insertable = true, updatable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "result", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    @Basic
    @Column(name = "file_type", nullable = true, insertable = true, updatable = true, length = 255)
    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Basic
    @Column(name = "file_path", nullable = true, insertable = true, updatable = true, length = 255)
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Basic
    @Column(name = "plain_text", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
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

        AnalysisEntity that = (AnalysisEntity) o;

        if (id != that.id) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (deletedAt != null ? !deletedAt.equals(that.deletedAt) : that.deletedAt != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (filePath != null ? !filePath.equals(that.filePath) : that.filePath != null) return false;
        if (fileType != null ? !fileType.equals(that.fileType) : that.fileType != null) return false;
        if (plainText != null ? !plainText.equals(that.plainText) : that.plainText != null) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = id;
        result1 = 31 * result1 + (date != null ? date.hashCode() : 0);
        result1 = 31 * result1 + (description != null ? description.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (fileType != null ? fileType.hashCode() : 0);
        result1 = 31 * result1 + (filePath != null ? filePath.hashCode() : 0);
        result1 = 31 * result1 + (plainText != null ? plainText.hashCode() : 0);
        result1 = 31 * result1 + (userId != null ? userId.hashCode() : 0);
        result1 = 31 * result1 + (createdAt != null ? createdAt.hashCode() : 0);
        result1 = 31 * result1 + (updatedAt != null ? updatedAt.hashCode() : 0);
        result1 = 31 * result1 + (deletedAt != null ? deletedAt.hashCode() : 0);
        return result1;
    }

    @OneToMany(mappedBy = "Analysis")
    public Collection<UserEntity> getUser() {
        return User;
    }

    public void setUser(Collection<UserEntity> user) {
        User = user;
    }

    @ManyToMany
    public Collection<ResourceEntity> getResources() {
        return Resources;
    }

    public void setResources(Collection<ResourceEntity> resources) {
        Resources = resources;
    }
}
