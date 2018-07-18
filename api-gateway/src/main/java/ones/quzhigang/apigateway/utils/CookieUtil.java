/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: CookieUtil
 * Author:   屈志刚
 * Date:     2018/7/17 0017 15:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ones.quzhigang.apigateway.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    /**
     * 功能描述: <br>
     * 〈设置cookie〉
     *
     * @param response
     * @param name
     * @param value
     * @param maxAge
     * @return: void
     * @@throws:
     * @Version: 1.0.0
     * @Author: 屈志刚
     * @Date: 2018/7/17 0017 15:17
     */
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge) {

        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 功能描述: <br>
     * 〈获取cookie〉
     *
     * @param request
     * @param name
     * @return: javax.servlet.http.Cookie
     * @@throws:
     * @Version: 1.0.0
     * @Author: 屈志刚
     * @Date: 2018/7/17 0017 15:18
     */
    public static Cookie get(HttpServletRequest request,
                             String name) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }

        return null;
    }
}
