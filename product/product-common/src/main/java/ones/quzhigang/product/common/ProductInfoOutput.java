package ones.quzhigang.product.common;

import lombok.*;

import java.math.BigDecimal;

/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: ones.quzhigang.ones.quzhigang.product.common.ProductInfoOutput
 * Author:   屈志刚
 * Date:     2018/4/25 0025 11:17
 * Description: 商品详情输出参数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductInfoOutput {

    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;


}
