package com.ss06.personal_blog.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    private String id;


    private String name;
    @OneToMany(mappedBy = "category")
    private Set<Blog> blogs;
    public Category() {
    }

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
