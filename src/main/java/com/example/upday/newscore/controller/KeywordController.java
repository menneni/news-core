package com.example.upday.newscore.controller;

import com.example.upday.newscore.commons.ApiResponse;
import com.example.upday.newscore.service.NewsArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tej on 5/3/18.
 */

@RestController
@RequestMapping("/keywords")
@Api(value="keywords controller", description="Operations on keywords")
public class KeywordController {

    private final Logger LOGGER = LoggerFactory.getLogger(KeywordController.class);

    @Autowired
    private NewsArticleService newsArticleService;


    @RequestMapping(value = "{keyword}/articles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List all news articles for given keyword",response = List.class)
    public ResponseEntity<?> getNewsArticlesBykeyword(@PathVariable String keyword){
        try{

            LOGGER.info("Checking for given keyword: "+keyword);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse<>(newsArticleService.findByKeyword(keyword)));
        }
        catch (Exception e){
            LOGGER.error("Error retrieving news article with given keyword {}", keyword, e);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}