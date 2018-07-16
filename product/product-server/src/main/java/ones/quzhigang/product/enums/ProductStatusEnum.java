/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: ProductStatusEnum
 * Author:   屈志刚
 * Date:     2018/4/25 0025 11:38
 * Description: 商品状态枚举类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ones.quzhigang.product.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {

    UP(0,"上架"),
    DOWN(1, "下架"),;

    private Integer code;
    private String Message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        Message = message;
    }
}
