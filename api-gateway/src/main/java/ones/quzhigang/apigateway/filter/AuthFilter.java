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
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class AuthFilter extends ZuulFilter {

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
        // /order/finish    只允许买家访问
        // /product/list    买家、卖家都可以访问


        return null;
    }
}
