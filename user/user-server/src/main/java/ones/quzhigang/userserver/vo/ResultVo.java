/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: ResultVo
 * Author:   屈志刚
 * Date:     2018/7/17 0017 15:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ones.quzhigang.userserver.vo;

import lombok.Data;

@Data
public class ResultVo<T> {

    private Integer code;

    private String msg;

    private T data;
}
