/**
 * Copyright (C), 2018, 上海米袋融资有限公司
 * ProjectName: wechatorder2.0
 * FileName: MqReceiver
 * Author:   屈志刚
 * Date:     2018/4/26 0026 17:22
 * Description: 测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ones.quzhigang.order.message;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.impl.AMQImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqReceiver {

    //@RabbitListener(queues = "testQueue")
    //@RabbitListener()
    @RabbitListener(bindings = @QueueBinding(

            value = @Queue("testQueue"),
            exchange = @Exchange("testChange")


    ))
    public void process(String message){
        log.info("MqReceiver: {}", message);
    }
}
