/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: UserInfo
 * Author:   屈志刚
 * Date:     2018/7/17 0017 15:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ones.quzhigang.userserver.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class UserInfo {

    @Id
    private String id;

    private String username;

    private String password;

    private String openid;

    private Integer role;
}
