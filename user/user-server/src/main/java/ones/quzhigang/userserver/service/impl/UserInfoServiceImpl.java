/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: UserInfoServiceImpl
 * Author:   屈志刚
 * Date:     2018/7/17 0017 15:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ones.quzhigang.userserver.service.impl;

import ones.quzhigang.userserver.bean.UserInfo;
import ones.quzhigang.userserver.repository.UserInfoRepostory;
import ones.quzhigang.userserver.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepostory userInfoRepostory;

    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepostory.findByOpenid(openid);
    }
}
