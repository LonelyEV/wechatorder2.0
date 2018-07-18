/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: LoginController
 * Author:   屈志刚
 * Date:     2018/7/17 0017 16:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ones.quzhigang.userserver.controller;

import ones.quzhigang.userserver.bean.UserInfo;
import ones.quzhigang.userserver.constant.CookieConstant;
import ones.quzhigang.userserver.constant.RedisConstant;
import ones.quzhigang.userserver.enums.ResultEnum;
import ones.quzhigang.userserver.enums.RoleEnum;
import ones.quzhigang.userserver.repository.UserInfoRepostory;
import ones.quzhigang.userserver.utils.CookieUtil;
import ones.quzhigang.userserver.utils.ResultVOUtil;
import ones.quzhigang.userserver.vo.ResultVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserInfoRepostory userInfoRepostory;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 功能描述: <br>
     * 〈卖家登录方法〉
     *
     * @param openId
     * @param response
     * @return: ones.quzhigang.userserver.vo.ResultVo
     * @@throws:
     * @Version: 1.0.0
     * @Author: 屈志刚
     * @Date: 2018/7/17 0017 16:29
     */
    @RequestMapping("/buyer")
    public ResultVo buyer(@RequestParam("openId") String openId, HttpServletResponse response){

        //  openId配置数据库记录
        UserInfo userInfo = userInfoRepostory.findByOpenid(openId);

        if(userInfo == null){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }

        //  判断用户角色
        if(!RoleEnum.BUYER.getCode().equals(userInfo.getRole())){
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }

        //  设置cookie中openId的值
        CookieUtil.set(response,CookieConstant.OPENID, userInfo.getOpenid(), CookieConstant.expire);

        return ResultVOUtil.success();
    }

    /**
     * 功能描述: <br>
     * 〈卖家登录方法〉
     *
     * @param openId
     * @param request
     * @param response
     * @return: ones.quzhigang.userserver.vo.ResultVo
     * @@throws:
     * @Version: 1.0.0
     * @Author: 屈志刚
     * @Date: 2018/7/17 0017 16:29
     */
    @RequestMapping("/seller")
    public ResultVo seller(@RequestParam("openId") String openId, HttpServletRequest request
    , HttpServletResponse response){

        //  判断是否已登录
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null &&
                !StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE,
                        cookie.getValue())))) {
            return ResultVOUtil.success();
        }

        //  openid和数据库里的数据是否匹配
        UserInfo userInfo = userInfoRepostory.findByOpenid(openId);

        if(userInfo == null){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }

        //  判断角色
        if(!RoleEnum.BUYER.getCode().equals(userInfo.getRole())){
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }

        //  redis设置key=UUID, value=xyz
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.expire;
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE, token),
                openId,
                expire,
                TimeUnit.SECONDS);

        //  cookie里设置token=UUID
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.expire);

        return ResultVOUtil.success();
    }
}
