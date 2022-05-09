package com.aca.homework.week18.website.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "IMAGES")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "blob_id", unique = true, nullable = false)
    private String blobId;

    public Image() {
    }

    public Image(String blobId) {
        this.blobId = blobId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Image{");
        sb.append("id=").append(id);
        sb.append(", blobId='").append(blobId).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image)) return false;
        Image image = (Image) o;
        return Objects.equals(id, image.id) && Objects.equals(blobId, image.blobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, blobId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlobId() {
        return blobId;
    }

    public void setBlobId(String blobId) {
        this.blobId = blobId;
    }
}
