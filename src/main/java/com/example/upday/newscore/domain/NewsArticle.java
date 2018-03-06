package com.example.upday.newscore.domain;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by tej on 20/2/18.
 */

@Entity
@Table(name = "news_article")
public class NewsArticle implements Serializable {

    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Auto generated news article ID")
    private Long id;

    @Column(name = "header")
    @ApiModelProperty(notes = "article header")
    private String header;

    @Column(name = "description")
    @ApiModelProperty(notes = "article description")
    private String description;

    @Column (name = "text")
    @ApiModelProperty(notes = "article text")
    private String text;

    @Column (name = "published_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(notes = "article published date")
    private Date publishedDate = new Date();

    // M articles <=> N authrors

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "news_article_author",
            joinColumns = @JoinColumn(name = "news_article_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id",
                    referencedColumnName = "id"))
    @ApiModelProperty(notes = "associated keywords for article")
    private List<Author> authors = new ArrayList<>();

    // M articles <=> N keywords

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "news_article_keyword",
            joinColumns = @JoinColumn(name = "news_article_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id",
                    referencedColumnName = "id"))
    private List<Keyword> keywords = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsArticle that = (NewsArticle) o;

        if (!id.equals(that.id)) return false;
        if (header != null ? !header.equals(that.header) : that.header != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (publishedDate != null ? !publishedDate.equals(that.publishedDate) : that.publishedDate != null)
            return false;
        if (authors != null ? !authors.equals(that.authors) : that.authors != null) return false;
        return keywords != null ? keywords.equals(that.keywords) : that.keywords == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (header != null ? header.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (publishedDate != null ? publishedDate.hashCode() : 0);
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NewsArticle{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", description='" + description + '\'' +
                ", text='" + text + '\'' +
                ", publishedDate=" + publishedDate +
                ", authors=" + authors +
                ", keywords=" + keywords +
                '}';
    }
}
