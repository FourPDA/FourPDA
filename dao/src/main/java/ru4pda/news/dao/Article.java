package ru4pda.news.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table ARTICLE.
 */
public class Article {

    private Long id;
    private Long server_id;
    private java.util.Date date;
    private String title;
    private String description;
    private Integer position;
    private String category;

    public Article() {
    }

    public Article(Long id) {
        this.id = id;
    }

    public Article(Long id, Long server_id, java.util.Date date, String title, String description, Integer position, String category) {
        this.id = id;
        this.server_id = server_id;
        this.date = date;
        this.title = title;
        this.description = description;
        this.position = position;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServer_id() {
        return server_id;
    }

    public void setServer_id(Long server_id) {
        this.server_id = server_id;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
