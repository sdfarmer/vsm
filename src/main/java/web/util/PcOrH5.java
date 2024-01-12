package web.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class PcOrH5 {
    private final static String[] agent = {"Android", "iPhone", "iPod", "iPad", "Windows Phone", "MQQBrowser"}; //定义移动端请求的所有可能类型

    /**
     * 判断User-Agent 是不是来自于手机
     *
     * @param ua
     * @return
     */
    public static boolean checkAgentIsMobile(String ua) {
        boolean flag = false;
        if (!ua.contains("Windows NT") || (ua.contains("Windows NT") && ua.contains("compatible; MSIE 9.0;"))) {
            // 排除 苹果桌面系统
            if (!ua.contains("Windows NT") && !ua.contains("Macintosh")) {
                for (String item : agent) {
                    if (ua.contains(item)) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    public static Boolean endCheck(HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        String ua = request.getHeader("User-Agent");
        if(checkAgentIsMobile(ua)){
            //h5
            return true;
        }else{
            //pc
            return false;
        }
    }
}


