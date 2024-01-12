package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.AskDao;
import web.model.Ask;
import web.service.AskService;

import java.util.List;
import java.util.Map;

@Service
public class AskServiceimpl implements AskService {
    @Autowired
    private AskDao askDao;
    @Override
    public Ask FindAskById(Integer id) {
        return askDao.FindAskById(id);
    }

    @Override
    public List<Ask> AskList(String path, Integer start, Integer limit) {
        return askDao.AskList(path,start*limit,limit);
    }

    @Override
    public List<Map> indexHot(String path) {
        return askDao.indexHot(path);
    }

    @Override
    public Ask FindBx1AskById(Integer id) {
        return askDao.FindBx1AskById(id);
    }
}
