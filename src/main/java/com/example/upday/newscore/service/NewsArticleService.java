package com.example.upday.newscore.service;

import com.example.upday.newscore.domain.NewsArticle;

import java.util.Date;
import java.util.List;

/**
 * Created by tej on 20/2/18.
 */


public interface NewsArticleService {
    public NewsArticle createNewsArticle(NewsArticle newsArticle);
    public NewsArticle updateNewsArticle(Long newsArticleId, NewsArticle newsArticle);
    public void deleteNewsArticle(Long newsArticleId);
    public NewsArticle findNewsArticlebyId(Long newsArticleId);
    public List<NewsArticle> findAllNewsArticles();
    public List<NewsArticle> findByAuthor(Long authorId);
    public List<NewsArticle> findByKeyword(String keyword);
    public List<NewsArticle> findByPublishedDateRange(Date publishedDateFrom, Date publishedDataTo);
}
