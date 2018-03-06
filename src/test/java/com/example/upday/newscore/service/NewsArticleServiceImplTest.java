/*
package com.example.upday.newscore.service;

import com.example.upday.newscore.NewsCoreApplication;
import com.example.upday.newscore.domain.NewsArticle;
import com.example.upday.newscore.repository.NewsArticleRepository;
import org.junit.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import static org.junit.Assert.*;

*/
/**
 * Created by tej on 5/3/18.
 *//*


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NewsCoreApplication.class)
@ActiveProfiles("TEST")
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@Transactional
public class NewsArticleServiceImplTest {

    @Autowired
    private NewsArticleRepository newsArticleRepository;


    @Test
    public void createNewsArticle() throws Exception {

    }

    @Test
    public void updateNewsArticle() throws Exception {

    }

    @Test
    public void deleteNewsArticle() throws Exception {

    }

    @Test
    public void whenFindNewsArticlebyId() throws Exception {
        NewsArticle newsArticle = new NewsArticle();
        newsArticle.setDescription("Description");
        newsArticle.setText("Text");
        newsArticle.setHeader("Header");
        newsArticleRepository.save(newsArticle);
        newsArticleRepository.flush();

        //when
        NewsArticle testNewsArticle = newsArticleRepository.findOne(newsArticle.getId());
        //then
        assertThat(testNewsArticle.getText()).isEqualTo(newsArticle.getText());

    }

    @Test
    public void findAllNewsArticles() throws Exception {

    }

    @Test
    public void findByAuthor() throws Exception {

    }

    @Test
    public void findByKeyword() throws Exception {

    }

    @Test
    public void findByPublishedDateRange() throws Exception {

    }

}*/
