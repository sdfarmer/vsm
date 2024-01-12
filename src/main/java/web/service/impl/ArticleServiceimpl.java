package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.ArticleDao;
import web.model.Article;
import web.service.ArticleService;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceimpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Override
    public List<Article> ArticleList(String path, Integer start, Integer limit) {

        return articleDao.ArticleList(path,start*limit,limit);
    }

    @Override
    public List<Article> RandomArticle(Integer ids) {
        return articleDao.RandomArticle(ids);
    }

    @Override
    public Map GabiArticle(Integer id) {
        return articleDao.GabiArticle(id);
    }

    @Override
    public List<Map> RandomGabi(Integer ids) {
        return articleDao.RandomGabi(ids);
    }

    @Override
    public List<Map> SearFac(String search) {
        return articleDao.SearFac(search);
    }

    @Override
    public List<Map> TopSearArt(String search) {
        return articleDao.TopSearArt(search);
    }

    @Override
    public List<Map> ClasssArticle(String path) {
        return articleDao.ClasssArticle(path);
    }
}
