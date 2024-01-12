package web.dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import web.model.Article;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleDao {
    List<Article> ArticleList(String path, Integer start, Integer limit);

    List<Article> RandomArticle(Integer ids);
    @MapKey("id")
    Map GabiArticle(Integer id);
    @MapKey("ids")
    List<Map> RandomGabi(Integer ids);
    @MapKey("search")
    List<Map> SearFac(String search);
    @MapKey("search")
    List<Map> TopSearArt(String search);
    @MapKey("path")
    List<Map> ClasssArticle(String path);

}
