package com.bits.JPAMavenPro.service;

import com.bits.JPAMavenPro.model.Article;
import com.bits.JPAMavenPro.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mdtofazzal.hossain on 12/23/2018.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<Article> getAllArticles() {
        return (List<Article>) articleRepository.findAll();
    }

    @Override
    public Article getArticleById(long id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(long id) {
        articleRepository.deleteById(id);
    }
}
