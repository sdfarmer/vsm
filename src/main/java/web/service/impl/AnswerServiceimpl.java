package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.AnswerDao;
import web.model.Answer;
import web.service.AnswerService;

import java.util.List;

@Service
public class AnswerServiceimpl implements AnswerService {
    @Autowired
    private AnswerDao answerDao;
    @Override
    public List<Answer> FindAnsByAskId(Integer id) {
        return answerDao.FindAnsByAskId(id);
    }

    @Override
    public List<Answer> FindBX1AnsByAskId(Integer id) {
        return answerDao.FindBX1AnsByAskId(id);
    }
}
