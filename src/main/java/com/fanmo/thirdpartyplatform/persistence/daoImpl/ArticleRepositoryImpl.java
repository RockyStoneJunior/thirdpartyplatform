package com.fanmo.thirdpartyplatform.persistence.daoImpl;

import com.fanmo.thirdpartyplatform.persistence.model.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
@Transactional
public class ArticleRepositoryImpl {


    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Transactional
    public  List<String> queryBysql(String sql) {
        return sessionFactory.openSession().createSQLQuery(sql).list();

    }

    List<Article> findAllGroupbyGroupid(){
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Article group by groupid";
        org.hibernate.Query query = session.createQuery(hql);
        List result = query.list();

        return result;
    }
}
