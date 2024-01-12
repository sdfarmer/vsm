package web.dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import web.model.Ask;

import java.util.List;
import java.util.Map;

@Mapper
public interface AskDao {

    Ask FindAskById(Integer id);

    List<Ask> AskList(@Param("path") String path, @Param("start") Integer i, @Param("limit") Integer limit);
    @MapKey("path")
    List<Map> indexHot(String path);
    @MapKey("id")
    Ask FindBx1AskById(Integer id);
}
