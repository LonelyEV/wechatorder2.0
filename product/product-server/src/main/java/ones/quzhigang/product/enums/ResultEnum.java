/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: ResultEnum
 * Author:   屈志刚
 * Date:     2018/4/25 0025 11:39
 * Description: 商品服务请求结果枚举
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ones.quzhigang.product.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存不足"),;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message){

        this.code = code;
        this.message = message;
    }
}
