/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: ProductInfoReceiver
 * Author:   屈志刚
 * Date:     2018/7/16 0016 16:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ones.quzhigang.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import ones.quzhigang.order.utils.JsonUtil;
import ones.quzhigang.product.common.ProductInfoOutput;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Slf4j
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(bindings = @QueueBinding(

            value = @Queue("productInfo"),
            exchange = @Exchange("productChange")


    ))


    public void process(String message){

        // message ==> ProductInfoOutput

        List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>)JsonUtil.fromJson(message,
                new TypeReference<List<ProductInfoOutput>>() {});

        log.info(" ProductInfoReceiver receiver message : "+JsonUtil.toJson(productInfoOutputList));

        // 存储到redis
        for(int i=0, k=productInfoOutputList.size(); i<k; i++){
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE,productInfoOutputList.get(i).getProductId())
                    ,String.valueOf(productInfoOutputList.get(i).getProductStock()));
        }




    }

}
