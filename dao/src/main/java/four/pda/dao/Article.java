package four.pda.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "ARTICLE".
 */
public class Article {

    private Long id;
    private java.util.Date date;
    private String title;
    private String description;
    private String category;
    private String image;
    private java.util.Date publishedDate;
    private Integer commentsCount;
    private Long authorId;
    private String authorName;
    private String labelName;
    private String labelColor;

    public Article() {
    }

    public Article(Long id) {
        this.id = id;
    }

    public Article(Long id, java.util.Date date, String title, String description, String category, String image, java.util.Date publishedDate, Integer commentsCount, Long authorId, String authorName, String labelName, String labelColor) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.description = description;
        this.category = category;
        this.image = image;
        this.publishedDate = publishedDate;
        this.commentsCount = commentsCount;
        this.authorId = authorId;
        this.authorName = authorName;
        this.labelName = labelName;
        this.labelColor = labelColor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public java.util.Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(java.util.Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getLabelColor() {
        return labelColor;
    }

    public void setLabelColor(String labelColor) {
        this.labelColor = labelColor;
    }

}
