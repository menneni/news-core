[![Build Status](https://travis-ci.org/sqshq/PiggyMetrics.svg?branch=master)](https://travis-ci.org/sqshq/PiggyMetrics)
[![codecov.io](https://codecov.io/github/sqshq/PiggyMetrics/coverage.svg?branch=master)](https://codecov.io/github/sqshq/PiggyMetrics?branch=master)
[![GitHub license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/sqshq/PiggyMetrics/blob/master/LICENCE)
[![Join the chat at https://gitter.im/sqshq/PiggyMetrics](https://badges.gitter.im/sqshq/PiggyMetrics.svg)](https://gitter.im/sqshq/PiggyMetrics?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

# News core

  **Simple backend service to serve news articles using spring boot**

## Deisgn

News core developed using spring boot with mysql as backend database, it contains following end points for any kind of operations on news articles

#### NewsArticleController

Method	| Path	| Description	| User authenticated	| Available from UI
------------- | ------------------------- | ------------- |:-------------:|:----------------:|
GET	| /articles	| Get specified articles data (optional filters - published date range from & to) | × | ×
GET	| /articles/{articleId}	| Get article data for specified article id | × | ×
PUT	| /articles/{articleId}	| Updates article info | × | ×
POST	| /articles	| Creates a new article | × | ×
DELETE | /articles/{articleId} | Deletes specified article Id | × | ×

## Installation

## API Reference

## Tests

## To do
