package com.fanmo.thirdpartyplatform.persistence.dao;


import com.fanmo.thirdpartyplatform.persistence.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findAllByAuthor(String author);

    List<Article> findAllGroupbyGroupid();
}
