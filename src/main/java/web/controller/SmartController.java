package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.Answer;
import web.model.Article;
import web.model.Ask;
import web.model.AskAndAnswers;
import web.service.AnswerService;
import web.service.ArticleService;
import web.service.AskService;
import web.service.IndexService;

import java.util.List;

@RestController
@RequestMapping("app")
public class SmartController {
    @Autowired
    private AnswerService answerService;
    @Autowired
    private AskService askService;
    @Autowired
    private IndexService indexService;
    @Autowired
    private ArticleService articleService;
    //小程序问题答案
    @GetMapping("/ask/{id}")
    public AskAndAnswers AnswerDetail(@PathVariable("id") Integer id){
        Ask ask=askService.FindAskById(id);
        List<Answer> answerlist=answerService.FindAnsByAskId(id);
        AskAndAnswers askAndAnswers=new AskAndAnswers();
        askAndAnswers.setAsk(ask);
        askAndAnswers.setAnswer(answerlist);
        return askAndAnswers;
    }
    //小程序资讯详情
    @GetMapping("/article/{id}")
    public Article ArticleDetail(@PathVariable("id") Integer id){
        Article article=indexService.findArticleById(id);
        return article;
    }
    //小程序资讯列表
    @GetMapping("/list/{path}/{start}/{limit}")
    public List<Article> ArticleList(@PathVariable("path") String path,@PathVariable("start") Integer start,@PathVariable("limit") Integer limit){
      List<Article> ArticleList=articleService.ArticleList(path,start,limit);
        return ArticleList;
    };
    //小程序问答列表
    @GetMapping("/asklist/{path}/{start}/{limit}")
    public List<Ask> AskList(@PathVariable("path") String path,@PathVariable("start") Integer start,@PathVariable("limit") Integer limit){
        List<Ask> AskList=askService.AskList(path,start,limit);
        return AskList;
    }
}
