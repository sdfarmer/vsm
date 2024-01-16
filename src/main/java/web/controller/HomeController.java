package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import web.model.Answer;
import web.model.Article;
import web.model.Ask;
import web.model.Bxcp;
import web.service.IndexService;
import web.util.Vsm_luecene;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import static web.util.PcOrH5.checkAgentIsMobile;
import static web.util.Vsm_luecene_search.search;


@Controller
@Slf4j
public class HomeController {

    @RequestMapping({"/dkmarkt.html"})
    public String dklist() {
        return "h5/list.html";
    }


    @Autowired
    private IndexService indexService;


    @RequestMapping(value = {"/bx_products/{p1}/{p2}.html", "/bx_products/{p1}/{p2}"}, method = RequestMethod.POST)
    @ResponseBody
    public List<Bxcp> ajaxS(@PathVariable("p1") String p1, @PathVariable("p2") String p2) {
        if ("all1".equals(p1)) {
            p1 = null;
        }
        if ("all2".equals(p2)) {
            p2 = null;
        }
        System.out.println("p1:" + p1);
        System.out.println("p2:" + p2);
        List<Bxcp> bxcpByTypeAndType2 = indexService.findBxcpByTypeAndType2(p1, p2);
//        System.out.println(bxcpByTypeAndType2);
        return bxcpByTypeAndType2;
    }


    /**
     * 保险产品详情页面pc
     *
     * @param id
     * @param map
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = {"/bx_product/{id}.html", "/bx_product/{id}"}, method = RequestMethod.GET)
    public String bxcpp(@PathVariable("id") Integer id, ModelMap map, HttpServletResponse response, HttpServletRequest request) {
        try {
            String ua = request.getHeader("User-Agent");
            if (checkAgentIsMobile(ua)) {
                log.info("进入h5");
                map.addAttribute("content", indexService.findbxcpById(id));
                map.addAttribute("recommend", indexService.findArticleByType("nj", 0, 3));
                return "new_h5/detail.html";
            } else {
                map.addAttribute("content", indexService.findbxcpById(id));
                map.addAttribute("recommend", indexService.findArticleByType("nj", 0, 3));
                return "new_pc/detail.html";
            }

        } catch (Exception e) {
            return "redirect:/";

        }

    }

    /**
     * 视频详情页面PC
     *
     * @param id
     * @param map
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = {"/video/{id}.html", "/video/{id}"}, method = RequestMethod.GET)
    public String video(@PathVariable("id") Integer id, ModelMap map, HttpServletResponse response, HttpServletRequest request) {
        try {
            String ua = request.getHeader("User-Agent");
            if (checkAgentIsMobile(ua)) {
                log.info("进入h5");
                map.addAttribute("video", indexService.findVideoById(id));
                map.addAttribute("hotvideo", indexService.findVideoByType("hot", 0, 6));
                return "new_h5/videodetail.html";

            } else {
                log.info("进入h5");
                map.addAttribute("video", indexService.findVideoById(id));
                map.addAttribute("hotvideo", indexService.findVideoByType("hot", 0, 6));
                return "new_pc/videodetail.html";
            }
        } catch (Exception e) {
            return "redirect:/";
        }


    }


    /**
     * 首页
     *
     * @param map
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = {"/", "index.html"}, method = RequestMethod.GET)
    public String index(ModelMap map, HttpServletResponse response, HttpServletRequest request) {


        try {
            String ua = request.getHeader("User-Agent");
            map.addAttribute("channel",indexService.findChannelLimit(5));
            if (checkAgentIsMobile(ua)) {
                //h5
                log.info("进入h5");
//                保险产品
//                map.addAttribute("rsbxp", indexService.findbxcpByType("rsbx", 0, 4));
//                map.addAttribute("jkbxp", indexService.findbxcpByType("jkbx", 0, 4));
//                map.addAttribute("jcbxp", indexService.findbxcpByType("jcbx", 0, 4));
//                map.addAttribute("lybxp", indexService.findbxcpByType("lybx", 0, 4));
//                map.addAttribute("ywbxp", indexService.findbxcpByType("ywbx", 0, 4));
//                map.addAttribute("dkask", indexService.findAskByType("dk", 0, 5));
                map.addAttribute("recommend", indexService.findArticleByType("recommend", 0, 45));
                map.addAttribute("friendly_link", indexService.getFriendlyLink());
                map.addAttribute("sy", indexService.findArticleByType("sy", 0, 5));
                map.addAttribute("bx", indexService.findArticleByType("bx", 0, 5));
                map.addAttribute("lc", indexService.findArticleByType("lc", 0, 5));
                map.addAttribute("xyk", indexService.findArticleByType("xyk", 0, 5));
                map.addAttribute("gp", indexService.findArticleByType("gp", 0, 5));
                map.addAttribute("dk", indexService.findArticleByType("dk", 0, 5));
                map.addAttribute("ask", indexService.findAskByType("hot2", 0, 3));
                return "h5/index.html";
                //return "new_h5/index.html";
            } else {
                //pc
                log.info("进入pc");
                map.addAttribute("bx", indexService.findArticleByType("bx", 0, 6));
                map.addAttribute("xyk", indexService.findArticleByType("xyk", 0, 3));
                map.addAttribute("dk", indexService.findArticleByType("dk", 0, 3));
                map.addAttribute("friendly_link", indexService.getFriendlyLink());
                map.addAttribute("recommend", indexService.findArticleByType("recommend", 0, 45));
//                map.addAttribute("hot", indexService.findArticleByType("hot", 0, 17));
                map.addAttribute("ask", indexService.findAskByType("hot2", 0, 17));
                map.addAttribute("dkask", indexService.findAskByType("dk", 0, 5));
//                保险产品
//                map.addAttribute("rsbxp", indexService.findbxcpByType("rsbx", 0, 4));
//                map.addAttribute("jkbxp", indexService.findbxcpByType("jkbx", 0, 4));
//                map.addAttribute("jcbxp", indexService.findbxcpByType("jcbx", 0, 4));
//                map.addAttribute("lybxp", indexService.findbxcpByType("lybx", 0, 4));
//                map.addAttribute("ywbxp", indexService.findbxcpByType("ywbx", 0, 4));
                return "pc/index.html";
                // return "new_pc/index.html";
            }
        } catch (Exception e) {
            System.out.println(e);
            map.addAttribute("bx", indexService.findArticleByType("bx", 0, 6));
            map.addAttribute("xyk", indexService.findArticleByType("xyk", 0, 3));
            map.addAttribute("dk", indexService.findArticleByType("dk", 0, 3));
            map.addAttribute("recommend", indexService.findArticleByType("recommend", 0, 45));
            map.addAttribute("ask", indexService.findAskByType("hot2", 0, 17));
            map.addAttribute("dkask", indexService.findAskByType("dk", 0, 5));
//            // 找不到用户设备 统一pc
//            map.addAttribute("recommend", indexService.findArticleByType("recommend", 0, 30));
//            map.addAttribute("hot", indexService.findArticleByType("hot2", 0, 17));
//            map.addAttribute("ask", indexService.findAskByType("hot2", 1, 17));
            return "pc/index.html";
        }

    }


    /**
     * @param map
     * @param response
     * @param request
     * @param ot_index
     * @return
     */
    @RequestMapping(value = "/ot/{ot_index}", method = RequestMethod.GET)
    public String ot_index(ModelMap map,
                           HttpServletResponse response,
                           HttpServletRequest request,
                           @PathVariable("ot_index") String ot_index) {
        ot_index = ot_index.replace("_index", "").replace(".html", "");
        log.info(ot_index);
        map.addAttribute("channel",indexService.findChannelLimit(5));
        map.addAttribute("tdk", indexService.findChannelByType(ot_index));
        map.addAttribute("friendly_link", indexService.getFriendlyLink());
        map.addAttribute("recommend", indexService.findArticleByType(ot_index, 0, 30));
        map.addAttribute("ask", indexService.findAskByType(ot_index, 0, 17));
        if (("ot_bx").equals(ot_index)) {
            //保险产品新页面
            return "new_pc/ot.html";
//            try {
//                String ua = request.getHeader("User-Agent");
//                if (checkAgentIsMobile(ua)) {
//                    //保险产品新页面
//                    return "new_h5/bx.html";
//                }else {
//                    //保险产品新页面
//                    return "new_pc/ot.html";
//                }
//            }catch (Exception e){
//                return "redirect:/";
//            }


        }
        return "pc/ot_index.html";

    }


    /**
     * 问答
     *
     * @return
     */
    @RequestMapping(value = {"/wd", "/wd.html"}, method = RequestMethod.GET)
    public String wd(ModelMap map,
                     HttpServletResponse response,
                     HttpServletRequest request) {
        map.addAttribute("channel",indexService.findChannelLimit(5));
        map.addAttribute("ask", indexService.findAskByType("hot2", 0, 22));
        map.addAttribute("recommend", indexService.findArticleByType("recommend", 0, 10));
        return "pc/wd.html";
    }


    /**
     * 关于我们
     *
     * @return
     */
    @RequestMapping(value = {"/aboutus", "/aboutus.html"}, method = RequestMethod.GET)
    public String aboutus(ModelMap map) {
        map.addAttribute("channel",indexService.findChannelLimit(5));
        return "pc/aboutus.html";
    }


    /**
     * 问答详情  有手机端
     *
     * @param map
     * @param response
     * @param request
     * @param type
     * @param id
     * @return
     */
    @RequestMapping(value = {"/{type}/ask/{id}.html"})
    public String qaDetail(ModelMap map, HttpServletResponse response, HttpServletRequest request,
                           @PathVariable("type") String type, @PathVariable("id") Integer id) {
        List<Answer> answerList = indexService.findAnswerByAskId(id);
        Ask ask = indexService.findAskById(id);
        if (ask == null) {
            log.error("没有对应的id" + id);
            return "pc/ask.html";
        }
        map.addAttribute("channel",indexService.findChannelLimit(5));
        try {
            String ua = request.getHeader("User-Agent");
            if (checkAgentIsMobile(ua)) {
                //h5
                log.info("进入h5" + type + ":" + id + answerList.size());
                map.addAttribute("ask", ask);
                map.addAttribute("answers", answerList);
                map.addAttribute("num", answerList.size());
                map.addAttribute("recommend", indexService.findAskXgById(id, 28));
                //map.addAttribute("recommend", indexService.findAskByType(ask.getColumnurlname2(), 0, 8));
                return "h5/ask.html";
            } else {
                //pc
                log.info("进入pc:" + type + ":" + id + answerList.size());
                map.addAttribute("ask", ask);
                map.addAttribute("answers", answerList);
                map.addAttribute("num", answerList.size());
                map.addAttribute("recommend", indexService.findAskXgById(id, 28));
                //map.addAttribute("recommend", indexService.findAskByType(ask.getColumnurlname2(), 0, 28));
                return "pc/ask.html";
            }
        } catch (Exception e) {
            // 找不到用户设备 统一pc
            map.addAttribute("ask", ask);
            map.addAttribute("answers", answerList);
            map.addAttribute("num", answerList.size());
            map.addAttribute("recommend", indexService.findAskXgById(id, 28));
            //map.addAttribute("recommend", indexService.findAskByType(ask.getColumnurlname2(), 0, 24));
            return "pc/ask.html";
        }

    }


    /**
     * 资讯详情  有手机端
     *
     * @param map
     * @param response
     * @param request
     * @param type
     * @param id
     * @return
     */
    @RequestMapping(value = {"/{type}/article/{id}.html"})
    public String articleDetail(ModelMap map, HttpServletResponse response, HttpServletRequest request,
                                @PathVariable("type") String type, @PathVariable("id") Integer id) {
        if(type.equals("product")){ //冗余一套代码
            Article article = indexService.findArticleById(id);
            if(!article.getColumnurlname2().equals("product")){
                return "redirect:/";
            }
            map.addAttribute("channel",indexService.findChannelLimit(5));
            try {
                String ua = request.getHeader("User-Agent");
                if (checkAgentIsMobile(ua)) {
                    //h5
                    log.info("进入h5");
                    map.addAttribute("article", article);
                    map.addAttribute("keys", article.getKeywords().split(","));
                    map.addAttribute("click", article.getColumnurlname1());
                    map.addAttribute("comment",  indexService.findCommentByType(article.getColumnshortname2()));
//                map.addAttribute("recommend", indexService.findArticleXgById(id, 17));
                    // map.addAttribute("recommend", indexService.findArticleByType(article.getColumnurlname2(), 0, 8));
                    return "h5/product.html";
                } else {
                    //pc
                    log.info("进入pc");
                    map.addAttribute("article", article);
                    map.addAttribute("keys", article.getKeywords().split(","));
                    map.addAttribute("click", article.getColumnurlname1());
                    map.addAttribute("comment",  indexService.findCommentByType(article.getColumnshortname2()));
                    map.addAttribute("recommend", indexService.findArticleProductByType(article.getColumnurlname2(), 0, 17));
                    return "pc/product.html";
//                return "pc/product.html";
                }
            } catch (Exception e) {
                // 找不到用户设备 统一pc
                map.addAttribute("article", indexService.findArticleById(id));
                map.addAttribute("recommend", indexService.findArticleXgById(id, 17));
                //map.addAttribute("recommend", indexService.findArticleByType(article.getColumnurlname2(), 0, 17));
//            return "pc/product.html";
                return "redirect:/";
            }
        }
        Article article = indexService.findArticleById(id);
        try {
            String ua = request.getHeader("User-Agent");
            if (checkAgentIsMobile(ua)) {
                //h5
                log.info("进入h5");
                map.addAttribute("article", article);
                map.addAttribute("keys", article.getKeywords().split(","));
                map.addAttribute("friendly_link", indexService.getFriendlyLink());
                map.addAttribute("recommend", indexService.findArticleXgById(id, 17));
                // map.addAttribute("recommend", indexService.findArticleByType(article.getColumnurlname2(), 0, 8));
                return "h5/article.html";
            } else {
                //pc
                log.info("进入pc");
                map.addAttribute("article", article);
                map.addAttribute("friendly_link", indexService.getFriendlyLink());
                map.addAttribute("keys", article.getKeywords().split(","));
                map.addAttribute("recommend", indexService.findArticleXgById(id, 17));
                //map.addAttribute("recommend", indexService.findArticleByType(article.getColumnurlname2(), 0, 17));
                return "pc/article.html";
            }
        } catch (Exception e) {
            // 找不到用户设备 统一pc
            map.addAttribute("article", indexService.findArticleById(id));
            map.addAttribute("recommend", indexService.findArticleXgById(id, 17));
            //map.addAttribute("recommend", indexService.findArticleByType(article.getColumnurlname2(), 0, 17));
            return "pc/article.html";
        }

    }

    @RequestMapping(value = {"/{type}/product/{id}.html"})
    public String productDetail(ModelMap map, HttpServletResponse response, HttpServletRequest request,
                                @PathVariable("type") String type, @PathVariable("id") Integer id) {
        Article article = indexService.findArticleById(id);
        if(!article.getColumnurlname2().equals("product")){
            return "redirect:/";
        }
        try {
            String ua = request.getHeader("User-Agent");
            if (checkAgentIsMobile(ua)) {
                //h5
                log.info("进入h5");
                map.addAttribute("article", article);
                map.addAttribute("keys", article.getKeywords().split(","));
                map.addAttribute("click", article.getColumnurlname1());
                map.addAttribute("comment",  indexService.findCommentByType(article.getColumnshortname2()));
//                map.addAttribute("recommend", indexService.findArticleXgById(id, 17));
                // map.addAttribute("recommend", indexService.findArticleByType(article.getColumnurlname2(), 0, 8));
                return "h5/product.html";
            } else {
                //pc
                log.info("进入pc");
                map.addAttribute("article", article);
                map.addAttribute("keys", article.getKeywords().split(","));
                map.addAttribute("click", article.getColumnurlname1());
                map.addAttribute("comment",  indexService.findCommentByType(article.getColumnshortname2()));
                map.addAttribute("recommend", indexService.findArticleProductByType(article.getColumnurlname2(), 0, 17));
                return "pc/product.html";
//                return "pc/product.html";
            }
        } catch (Exception e) {
            // 找不到用户设备 统一pc
            map.addAttribute("article", indexService.findArticleById(id));
            map.addAttribute("recommend", indexService.findArticleXgById(id, 17));
            //map.addAttribute("recommend", indexService.findArticleByType(article.getColumnurlname2(), 0, 17));
//            return "pc/product.html";
            return "redirect:/";
        }

    }


    /**
     * 只用手机端存在
     *
     * @param content
     * @param map
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/search/{content}")
    public String searchTitle(@PathVariable("content") String content, ModelMap map, HttpServletResponse response, HttpServletRequest request) {
        try {
            List<Article> search = search("vsm", content, 1);
            Article article = indexService.findArticleById(search.get(0).getId());
            map.addAttribute("article", article);
            return "h5/article.html";
        } catch (Exception e) {
            log.info("索引错误，检查是否有索引！");
            return "h5/index.html";
        }
    }


    /**
     * 创建索引的接口
     *
     * @param model
     * @return
     */
    @RequestMapping("/create_index")
    @ResponseBody
    public String create_index(String model) {
        try {
            List<Article> articles = indexService.findArticleAll();
            Vsm_luecene.create_index("vsm", articles);
            log.info(model + "索引生成成功！");
            return "h5/article.html";
        } catch (Exception e) {
            log.info(model + "索引生成失败！");
        }
        return "h5/index.html";

    }

    @RequestMapping("/clickproduct/{type}")

    public String addTJ(@PathVariable("type") String type){
        indexService.updateAdvNum(type,indexService.findAdvNum(type)+1);
        return "redirect:/";
    }
}
