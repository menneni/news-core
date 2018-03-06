package com.example.upday.newscore.repository;

import com.example.upday.newscore.domain.NewsArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by tej on 20/2/18.
 */

@Repository
@Transactional()
public interface NewsArticleRepository extends JpaRepository<NewsArticle, Long> {
    @Query("SELECT article FROM NewsArticle article LEFT JOIN FETCH article.authors author WHERE author.id =:id")
    List<NewsArticle> findByAuthorId(@Param("id") Long id);

    @Query("SELECT article FROM NewsArticle article LEFT JOIN FETCH article.keywords keyword WHERE keyword.keyword =:keyword")
    List<NewsArticle> findByKeyword(@Param("keyword") String keyword);

    @Query("SELECT article FROM NewsArticle article where article.publishedDate between :publishedDateFrom and :publishedDateTo")
    List<NewsArticle> findByPublisedDateRange(@Param("publishedDateFrom") Date publishedDateFrom, @Param("publishedDateTo") Date publishedDateTo);
}
