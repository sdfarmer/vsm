package web.service;

import web.model.Article;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    List<Article> ArticleList(String path, Integer start, Integer limit);

    List<Article> RandomArticle(Integer ids);

    Map GabiArticle(Integer id);

    List<Map> RandomGabi(Integer ids);

    List<Map> SearFac(String search);

    List<Map> TopSearArt(String search);

    List<Map> ClasssArticle(String path);
}
