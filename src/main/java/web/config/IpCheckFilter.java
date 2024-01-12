//package web.config;
//
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Component
//public class IpCheckFilter implements Filter {
//    private static List<String> NotFoundAreaList = new ArrayList<>();
//    static {
//        NotFoundAreaList.add("北京");
//        NotFoundAreaList.add("深圳");
//        NotFoundAreaList.add("上海");
//    }
//
//    public String getClientIP(HttpServletRequest request) {
//        // 这里需要配合NG的转发
//        String ip = request.getHeader("x-forwarded-for");
//        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//        return ip;
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
//        try {
//            HttpServletRequest req = (HttpServletRequest) request;
//            String ipAddress = getClientIP(req);
//            String url = "https://whois.pconline.com.cn/ipJson.jsp?ip=" + ipAddress;
//            // 创建 URL 对象
//            URL obj = new URL(url);
//            // 打开连接
//            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//            // 设置请求方法为 GET
//            con.setRequestMethod("GET");
//            // 读取响应内容
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "GBK"));
//            String inputLine;
//            StringBuilder resp = new StringBuilder();
//            while ((inputLine = in.readLine()) != null) {
//                resp.append(inputLine);
//            }
//            in.close();
//            String respstr = resp.toString();
//            for (String ch : NotFoundAreaList) {
//                if (respstr.contains(ch)){
//                    HttpServletResponse httpResponse = (HttpServletResponse) response;
//                    httpResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
//                    System.out.println("当前IP触发黑名单策略, resp:" + respstr);
//                    return;
//                }
//            }
//            chain.doFilter(request, response);
//        } catch (Exception e) {
//            System.out.println("查询ip出现异常, e:" + e);
//        }
//    }
//}