package web.service;

import web.model.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> FindAnsByAskId(Integer id);

    List<Answer> FindBX1AnsByAskId(Integer id);
}
