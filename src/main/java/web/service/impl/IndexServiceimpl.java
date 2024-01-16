package web.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.IndexDao;
import web.model.*;
import web.service.IndexService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndexServiceimpl implements IndexService {

    @Autowired
    private IndexDao indexDao;

    @Override
    public List<Article> findArticleByType(String type, int page, int num) {
        Integer pagenum = page * num;
        Integer pagesize = num;
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("pagenum", pagenum);
        map.put("pagesize", pagesize);
        return indexDao.findArticleByType(map);
    }

    @Override
    public Article findArticleById(Integer id) {
        return indexDao.findArticleById(id);
    }

    public List<Map<String, String>> getFriendlyLink() {

        List<FriendlyLink> friendlyLinks = indexDao.getFriendlyLink();
        List<Map<String, String>> result = new ArrayList<>();
        for (FriendlyLink friendlyLink:friendlyLinks) {
            Map<String, String> v = new HashMap<>();
            v.put("name",friendlyLink.getName());
            v.put("link",  friendlyLink.getLink());
            result.add(v);
        }
        return result;
//        try {
//            // 创建 URL 对象
//            URL obj = new URL("http://43.132.234.70:8007/friendly_link/search");
//            // 打开连接
//            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//            // 设置请求方法为 GET
//            con.setRequestMethod("GET");
//            // 获取响应代码
//            int responseCode = con.getResponseCode();
//            // 读取响应内容
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuilder response = new StringBuilder();
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//            String links = response.toString();
//            JSONObject parse1 = JSONObject.parseObject(links);
//            if (!parse1.getBoolean("ret")){
//                return null;
//            }
//            List<Map<String, String>> result = new ArrayList<>();
//            for (JSONObject data : parse1.getJSONArray("data").toJavaList(JSONObject.class)) {
//                Map<String, String> v = new HashMap<>();
//                v.put("name", data.getString("name"));
//                v.put("link", data.getString("link"));
//                result.add(v);
//            }
//            return result;
//        } catch (Exception e) {
//            System.out.println("获取友情链接异常, e:" + e);
//        }
//        return null;
    }

    @Override
    public List<Article> findArticleAll() {
        return indexDao.findArticleAll();
    }

    @Override
    public Channel findChannelByType(String ot_index) {
        return indexDao.findChannelByType(ot_index);
    }

    @Override
    public List<Channel> findChannelLimit(int limit) {
        return indexDao.findChannelLimit(limit);
    }

    @Override
    public List<Ask> findAskByType(String type, int page, int num) {
        Integer pagenum = page * num;
        Integer pagesize = num;
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("pagenum", pagenum);
        map.put("pagesize", pagesize);
        return indexDao.findAskByType(map);
    }

    @Override
    public List<Answer> findAnswerByAskId(Integer id) {
        return indexDao.findAnswerByAskId(id);
    }

    @Override
    public Ask findAskById(Integer id) {
        return indexDao.findAskById(id);
    }

    @Override
    public List<Bxcp> findbxcpByType(String type, int page, int num) {
        Integer pagenum = page * num;
        Integer pagesize = num;
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("pagenum", pagenum);
        map.put("pagesize", pagesize);
        return indexDao.findbxcpByType(map);

    }

    @Override
    public VsmVideo findVideoById(Integer id) {
        return indexDao.findVideoById(id);
    }

    @Override
    public List<VsmVideo> findVideoByType(String type, int page, int num) {
        Integer pagenum = page * num;
        Integer pagesize = num;
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("pagenum", pagenum);
        map.put("pagesize", pagesize);
        return indexDao.findVideoByType(map);
    }

    @Override
    public Bxcp findbxcpById(Integer id) {
        return indexDao.findbxcpById(id);
    }

    @Override
    public List<Bxcp> findBxcpByTypeAndType2(String p1, String p2) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("p1", p1);
        map.put("p2", p2);
        System.out.println(map);
        return indexDao.findBxcpByTypeAndType2(map);
    }

    @Override
    public List<Article> findArticleXgById(Integer id, int i) {
        return indexDao.findArticleXgById(id, i);
    }

    @Override
    public List<Ask> findAskXgById(Integer id, int i) {
        return indexDao.findAskXgById(id, i);
    }

    @Override
    public List<Comment> findCommentByType(String columnshortname2) {
        return indexDao.findCommentByType(columnshortname2);
    }

    @Override
    public Integer findAdvNum(String type) {
        return indexDao.findAdvNum(type);
    }

    @Override
    public void updateAdvNum(String type, int i) {
        indexDao.updateAdvNum(type, i);
    }

    @Override
    public List<Article> findArticleProductByType(String type, int page, int num) {
        Integer pagenum = page * num;
        Integer pagesize = num;
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("pagenum", pagenum);
        map.put("pagesize", pagesize);
        return indexDao.findArticleProductByType(map);
    }

}
