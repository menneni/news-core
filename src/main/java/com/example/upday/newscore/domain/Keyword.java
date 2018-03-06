package com.example.upday.newscore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by tej on 20/2/18.
 */

@Entity
@Table(name = "keyword")

public class Keyword implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "keyword", nullable = false)
    private String keyword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Keyword that = (Keyword) o;

        if (!id.equals(that.id)) return false;
        return keyword != null ? keyword.equals(that.keyword) : that.keyword == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
