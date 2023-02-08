package com.ss06.personal_blog.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {
    @Id
    private String id;

    private String name;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Blog> blogs;

    public Author() {
    }

    public Author(String id, String name, Set<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.blogs = blogs;
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

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}
