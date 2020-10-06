package com.bits.JPAMavenPro.repository;

import com.bits.JPAMavenPro.model.Article;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mdtofazzal.hossain on 12/23/2018.
 */
public interface ArticleRepository extends CrudRepository<Article, Long> {

}
