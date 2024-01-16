package web.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import web.model.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface IndexDao {
    List<Article> findArticleByType(HashMap<String, Object> map);

    Article findArticleById(Integer id);

    List<Article> findArticleAll();

    Channel findChannelByType(String ot_index);

    List<Channel> findChannelLimit(int limit);

    List<FriendlyLink> getFriendlyLink();

    List<Ask> findAskByType(HashMap<String, Object> map);

    List<Answer> findAnswerByAskId(Integer askid);

    Ask findAskById(Integer id);

    List<Bxcp> findbxcpByType(HashMap<String, Object> map);

    VsmVideo findVideoById(Integer id);

    List<VsmVideo> findVideoByType(HashMap<String, Object> map);


    @Select("select * from bxcp where id=#{id}")
    Bxcp findbxcpById(Integer id);


    List<Bxcp> findBxcpByTypeAndType2(HashMap<String, Object> map);


    @Select("select * from article_new where id>#{id} limit #{i}")
    List<Article> findArticleXgById(Integer id, int i);
    @Select("select * from ask where id>#{id} limit #{i}")
    List<Ask> findAskXgById(Integer id, int i);
    @Select("select * from comment where type=#{columnshortname2} order by rand() limit 3")
    List<Comment> findCommentByType(String columnshortname2);
    @Select("select advnum from advnum where type=#{type}")
    Integer findAdvNum(String type);
    @Update("update advnum set advnum=#{i} where type=#{type}")
    void updateAdvNum(String type, int i);

    List<Article> findArticleProductByType(HashMap<String, Object> map);
}
