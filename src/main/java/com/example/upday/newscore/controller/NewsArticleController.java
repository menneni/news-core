package com.example.upday.newscore.controller;

import com.example.upday.newscore.commons.ApiResponse;
import com.example.upday.newscore.domain.NewsArticle;
import com.example.upday.newscore.service.NewsArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by tej on 22/2/18.
 */

@RestController
@RequestMapping("/articles")
@Api(value="news articles controller", description="Operations on news articles")
public class NewsArticleController {

    private final Logger LOGGER = LoggerFactory.getLogger(NewsArticleController.class);

    @Autowired
    NewsArticleService newsArticleService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Creates a news article",response = ResponseEntity.class)
    public ResponseEntity<?> createNewsArticle(@RequestBody NewsArticle newsArticleRequest){
        try {

            LOGGER.info("request to create news article:"+newsArticleRequest);

            NewsArticle newsArticleResponse = newsArticleService.createNewsArticle(newsArticleRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(newsArticleResponse));
        }
        catch (Exception e){
            LOGGER.error("Error creating news article: {}", newsArticleRequest, e);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{articleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List article for given article Id",response = List.class)
    public ResponseEntity<?> getArticleById(@PathVariable Long articleId){
        try{

            LOGGER.info("Checking for given article: "+articleId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse<>(newsArticleService.findNewsArticlebyId(articleId)));
        }
        catch (Exception e){
            LOGGER.error("Error retrieving news article with given ID", e);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List all news articles for given article published data range",response = List.class)
    public ResponseEntity<?> getAllArticlesForPublishedDateRange(@RequestParam(name = "from", required = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from, @RequestParam(name = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to){
        try{
            if(from != null && to != null && from.compareTo(to) <= 0){
                LOGGER.info("Checking for given published date range: {} {}"+from, to);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse<>(newsArticleService.findByPublishedDateRange(from, to)));
            }
            else if(from == null && to == null){
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse<>(newsArticleService.findAllNewsArticles()));
            }
            else{
                LOGGER.error("Invalid data range {} {}", from, to);
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e){
            LOGGER.error("Error retrieving news article with data range {} {}", from, to, e);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{articleId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update news article", notes = "updates article for given article id", response = ResponseEntity.class)
    public ResponseEntity<?> updateNewsArticle(@PathVariable Long articleId, @RequestBody NewsArticle newsArticleUpdateRequest){
        try{
            LOGGER.info("request for updating news article request: "+newsArticleUpdateRequest);
            NewsArticle newsArticleResponse = newsArticleService.updateNewsArticle(articleId, newsArticleUpdateRequest);

            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(newsArticleResponse));
        }
        catch (Exception e){
            LOGGER.error("Error updating news article with given article id: {}", articleId, e);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
    @RequestMapping(value = "/{articleid}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Deletes news article", notes = "removes article for given article id", response = ResponseEntity.class)
    public ResponseEntity<?> deleteNewsArticle(@PathVariable Long id){

        try{
            LOGGER.info("request for deleting news article with given Id: "+id);
            newsArticleService.deleteNewsArticle(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            LOGGER.error("Error deleting news article with given article id: {}", id, e);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}
