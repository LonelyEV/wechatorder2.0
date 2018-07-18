/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: TokenFilter
 * Author:   屈志刚
 * Date:     2018/7/17 0017 11:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ones.quzhigang.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import ones.quzhigang.apigateway.constant.RedisConstant;
import ones.quzhigang.apigateway.utils.CookieUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        /**
         * 功能描述: <br>
         * 〈权限拦截，区分买家、卖家〉
         *
         * @param
         * @return: java.lang.Object
         * @@throws:
         * @Version: 1.0.0
         * @Author: 屈志刚
         * @Date: 2018/7/17 0017 13:30
         */

        RequestContext requestContext =  RequestContext.getCurrentContext();
        HttpServletRequest request =  requestContext.getRequest();

        // /order/create    只允许卖家访问
        if("/order/order/create".equals(request.getRequestURI())){
            Cookie cookie = CookieUtil.get(request, "openId");

            if(cookie == null || StringUtils.isBlank(cookie.getValue())){
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }

        // /order/finish    只允许买家访问

        if("/order/order/finish".equals(request.getRequestURI())){

            Cookie cookie = CookieUtil.get(request, "token");

            if(cookie == null
                    || StringUtils.isEmpty(cookie.getValue())
                    || StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))){

                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }

        // /product/list    买家、卖家都可以访问


        return null;
    }
}
