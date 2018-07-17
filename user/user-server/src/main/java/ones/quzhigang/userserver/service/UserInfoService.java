/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: UserInfoService
 * Author:   屈志刚
 * Date:     2018/7/17 0017 15:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ones.quzhigang.userserver.service;

import ones.quzhigang.userserver.bean.UserInfo;

public interface UserInfoService {

    UserInfo findByOpenid(String openid);
}
