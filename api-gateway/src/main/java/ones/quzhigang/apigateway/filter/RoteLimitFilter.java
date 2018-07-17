/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: RoteLimitFilter
 * Author:   屈志刚
 * Date:     2018/7/17 0017 11:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ones.quzhigang.apigateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import ones.quzhigang.apigateway.exception.RoteLimitException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

public class RoteLimitFilter extends ZuulFilter {

    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        if(RATE_LIMITER.tryAcquire()){
            throw new RoteLimitException();
        }
        return null;
    }
}
