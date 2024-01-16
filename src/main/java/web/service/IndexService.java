package web.service;

import web.model.*;

import java.util.List;
import java.util.Map;

public interface IndexService {
    List<Article> findArticleByType(String sy, int page, int num);

    Article findArticleById(Integer id);

    List<Map<String, String>> getFriendlyLink();

    List<Article> findArticleAll();

    Channel findChannelByType(String ot_index);

    List<Channel> findChannelLimit(int limit);

    List<Ask> findAskByType(String ask, int i, int i1);

    List<Answer> findAnswerByAskId(Integer id);

    Ask findAskById(Integer id);

    List<Bxcp> findbxcpByType(String rsbx, int i, int i1);

    VsmVideo findVideoById(Integer id);

    List<VsmVideo> findVideoByType(String type, int page, int num);

    Bxcp findbxcpById(Integer id);

    List<Bxcp> findBxcpByTypeAndType2(String p1, String p2);

    List<Article> findArticleXgById(Integer id, int i);

    List<Ask> findAskXgById(Integer id, int i);

    List<Comment> findCommentByType(String columnshortname2);

    Integer findAdvNum(String type);

    void updateAdvNum(String type, int i);

    List<Article> findArticleProductByType(String columnurlname2, int i, int i1);
}
