package com.neobis.eshop.entity;

import javax.persistence.*;


@Entity
@Table(name = "tag")
public class TagEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer id;

    @Column(name = "name",length = 60)
    private String name;

    @Column(name = "description",length = 255)
    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "tag_image",length = 200)
    private String image;

    public TagEntity() {
    }

    public TagEntity(String name, String description, boolean isActive, String image) {
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
