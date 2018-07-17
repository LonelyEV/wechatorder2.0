/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: UserInfoRepostory
 * Author:   屈志刚
 * Date:     2018/7/17 0017 15:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ones.quzhigang.userserver.repository;

import ones.quzhigang.userserver.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepostory extends JpaRepository<UserInfo, String> {

    UserInfo findByOpenid(String openid);
}
