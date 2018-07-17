/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: ResultEnum
 * Author:   屈志刚
 * Date:     2018/7/17 0017 15:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ones.quzhigang.userserver.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    LOGIN_FAIL(1, "登录失败"),
    ROLE_ERROR(2, "角色权限有误"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
