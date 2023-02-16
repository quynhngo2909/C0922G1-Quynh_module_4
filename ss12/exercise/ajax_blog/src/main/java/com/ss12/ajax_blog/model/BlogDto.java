package com.ss12.ajax_blog.model;

public class BlogDto {
    private String id;

    private Author author;

    private String name;

    private String createdDate;
    private String updatedDate;

    private Category category;
    private String description;
    private String content;

    public BlogDto() {
    }

    public BlogDto(String id, Author author, String name, String createdDate, String updatedDate, Category category, String description, String content) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.category = category;
        this.description = description;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
