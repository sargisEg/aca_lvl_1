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

    @ManyToOne
    @JoinColumn(
            name = "post_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_IMAGES_POST_ID_ID")
    )
    private Post post;

    public Image() {
    }

    public Image(String blobId, Post post) {
        this.blobId = blobId;
        this.post = post;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Image{");
        sb.append("id=").append(id);
        sb.append(", blobId='").append(blobId).append('\'');
        sb.append(", post='").append(post).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image)) return false;
        Image image = (Image) o;
        return Objects.equals(id, image.id)
                && Objects.equals(blobId, image.blobId)
                && Objects.equals(post, image.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, blobId, post);
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

}
