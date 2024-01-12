package web.dao;

import org.apache.ibatis.annotations.Mapper;
import web.model.Answer;

import java.util.List;

@Mapper
public interface AnswerDao {
    List<Answer> FindAnsByAskId(Integer id);

    List<Answer> FindBX1AnsByAskId(Integer id);
}
