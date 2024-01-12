package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import web.model.Answer;
import web.model.Article;
import web.model.Ask;
import web.model.AskAndAnswers;
import web.service.AnswerService;
import web.service.ArticleService;
import web.service.AskService;
import web.service.IndexService;

import java.util.List;
import java.util.Map;

@RestController
public class WxController {
    @Autowired
    private IndexService indexService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private AskService askService;
    @Autowired
    private AnswerService answerService;
    //小程序资讯详情
    @GetMapping("/article/{id}")
    public Article ArticleDetail(@PathVariable("id") Integer id){
        Article article=indexService.findArticleById(id);
        return article;
    }
    //小程序随机ids条资讯
    @GetMapping("/RandomArticle/{ids}")
    public List<Article> RandomArticle(@PathVariable("ids") Integer ids){
        List<Article> ArticleList=articleService.RandomArticle(ids);
        return ArticleList;
    }
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
    //小程序顶部两个框框资讯  单条资讯
    @GetMapping("/gabi/{id}")
    public Map GabiArticle(@PathVariable("id") Integer id) {
        Map article=articleService.GabiArticle(id);
        return article;
    }
    //小程序顶部随机几条  ids  资讯条数
    @GetMapping("/RandomGabi/{ids}")
    public List<Map> RandomGabi(@PathVariable("ids") Integer ids){
        List<Map> RandomGabi=articleService.RandomGabi(ids);
        return RandomGabi;
    }
    //备案保险公司查询
    @GetMapping("/SearFac/{search}")
    public List<Map> SearFac(@PathVariable("search") String search){
        List<Map> SearFac=articleService.SearFac(search);
        return SearFac;
    }
    //小程序顶部保险知识搜索
    @GetMapping("/SearArt/{search}")
    public List<Map> TopSearArt(@PathVariable("search") String search){
        List<Map>TopSearArt=articleService.TopSearArt(search);
        return TopSearArt;
    }
    //小程序中间保险分类
    @GetMapping("/ClasssArticle/{path}")
    public List<Map> ClasssArticle(@PathVariable("path") String path){
        List<Map>ClasssArticle=articleService.ClasssArticle(path);
        return ClasssArticle;
    }
    //小程序首页问答详情
    @GetMapping("/bx1AskAns")
    public AskAndAnswers bx1AskAns(@PathVariable("id") Integer id){
        Ask ask=askService.FindBx1AskById(id);
        List<Answer> answerlist=answerService.FindBX1AnsByAskId(id);
        AskAndAnswers askAndAnswers=new AskAndAnswers();
        askAndAnswers.setAsk(ask);
        askAndAnswers.setAnswer(answerlist);
        return askAndAnswers;
    }
    //小程序首页问答下面的热点关注
    @GetMapping("/indexHot/{path}")
    public List<Map> indexHot(@PathVariable("path") String path){
        List<Map>ClasssArticle=askService.indexHot(path);
        return ClasssArticle;
    }
}
