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
@RequestMapping("/authors")
@Api(value="Authors controller", description="Operations on authors")
public class AuthorController {

    private final Logger LOGGER = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    private NewsArticleService newsArticleService;


    @RequestMapping(value = "{authorId}/articles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List all news articles",response = List.class)
    public ResponseEntity<?> getNewsArticlesByAuthorId(@PathVariable Long authorId){
        try{

            LOGGER.info("Checking for given author Id: "+authorId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse<>(newsArticleService.findByAuthor(authorId)));
        }
        catch (Exception e){
            LOGGER.error("Error retrieving news article with given author ID", e);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
