package com.example.upday.newscore.service;

import com.example.upday.newscore.domain.NewsArticle;
import com.example.upday.newscore.repository.NewsArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by tej on 22/2/18.
 */

@Service
public class NewsArticleServiceImpl implements NewsArticleService {

    private final Logger LOGGER = LoggerFactory.getLogger(NewsArticleServiceImpl.class);


    @Autowired
    NewsArticleRepository newsArticleRepository;

    @Override
    public NewsArticle createNewsArticle(NewsArticle newsArticleRequest) {

        LOGGER.info("validating news article create request: {}", newsArticleRequest);
        validate(newsArticleRequest);
        LOGGER.info("saving news article create request: {}", newsArticleRequest);
        NewsArticle newsArticleResponse = newsArticleRepository.save(newsArticleRequest);
        return newsArticleResponse;
    }

    @Override
    public NewsArticle updateNewsArticle(Long newsArticleId, NewsArticle newsArticleRequest) {

        NewsArticle newsArticle = newsArticleRepository.findOne(newsArticleId);
        if (newsArticle == null){
            LOGGER.error("no article found with given article id: ", newsArticleId);
            throw new EntityNotFoundException("There is no news article entity with such ID in the database");
        }

        if(newsArticleRequest.getDescription() != null){
            newsArticle.setDescription(newsArticleRequest.getDescription());
        }

        if(newsArticleRequest.getText() != null){
            newsArticle.setText(newsArticleRequest.getText());
        }

        if(newsArticleRequest.getHeader() != null){
            newsArticle.setHeader(newsArticleRequest.getHeader());
        }

        return newsArticleRepository.save(newsArticle);
    }

    @Override
    public void deleteNewsArticle(Long newsArticleId) {
        newsArticleRepository.delete(newsArticleId);
    }

    @Override
    public NewsArticle findNewsArticlebyId(Long newsArticleid) {
        NewsArticle newsArticle = newsArticleRepository.findOne(newsArticleid);
        return newsArticle;
    }

    @Override
    public List<NewsArticle> findAllNewsArticles() {
        return newsArticleRepository.findAll();
    }

    @Override
    public List<NewsArticle> findByAuthor(Long authorId) {
        return newsArticleRepository.findByAuthorId(authorId);
    }

    @Override
    public List<NewsArticle> findByKeyword(String keyword) {
        if(org.apache.commons.lang.StringUtils.isNotEmpty(keyword)){
            return newsArticleRepository.findByKeyword(keyword);
        }
        else{
            LOGGER.error("Invalid keyword, cannot be empty: "+keyword);
            return Collections.emptyList();
        }
    }

    @Override
    public List<NewsArticle> findByPublishedDateRange(Date publishedDateFrom, Date publishedDataTo) {
        return newsArticleRepository.findByPublisedDateRange(publishedDateFrom, publishedDataTo);
    }

    private void validate(NewsArticle newsArticleRequest) {
        Assert.notNull(newsArticleRequest.getHeader(), "Header cannot be null");
        Assert.notNull(newsArticleRequest.getKeywords(), "Keywords cannot be null");
        Assert.notNull(newsArticleRequest.getAuthors(), "Keywords cannot be null");
    }




}
