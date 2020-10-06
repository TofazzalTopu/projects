package com.bits.JPAMavenPro.service;

import com.bits.JPAMavenPro.model.Article;

import java.util.List;

/**
 * Created by mdtofazzal.hossain on 12/23/2018.
 */
public interface ArticleService {
    List<Article> getAllArticles();

    Article getArticleById(long id);

    void saveOrUpdate(Article article);

    void deleteArticle(long id);
}
