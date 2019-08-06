package com.fanmo.thirdpartyplatform.persistence.dao;


        import com.fanmo.thirdpartyplatform.persistence.model.Article;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findAllByAuthor(String author);

    List<Article> findAllGroupbyGroupid(String b_username);

    List<Article> findAllByGroupidAndBUsername(String groupid, String b_username);

    @Transactional
    void deleteArticlesByGroupidAndBUsername(String groupid, String b_username);

    @Transactional
    void deleteArticleByIdAndBUsername(long id, String b_username);
}
