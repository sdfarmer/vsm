package web.service;

import web.model.Ask;

import java.util.List;
import java.util.Map;

public interface AskService {
    Ask FindAskById(Integer id);

    List<Ask> AskList(String path, Integer start, Integer limit);

    List<Map> indexHot(String path);

    Ask FindBx1AskById(Integer id);
}
