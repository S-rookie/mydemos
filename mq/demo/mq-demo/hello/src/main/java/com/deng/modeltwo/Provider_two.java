package com.deng.modeltwo;

import com.deng.util.MQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @author deng
 */
public class Provider_two {

    public static void main(String[] args) throws IOException {
        Connection connection = MQUtils.getConnection();
        Channel channel = MQUtils.getChannel(connection);

        // 通过过道声明队列
        channel.queueDeclare("work",true,false,false,null);

        //生产消息
        for (int i = 0; i < 10; i++) {
            String msg = "hello mq: "+i;
            channel.basicPublish("","work",null,msg.getBytes());
        }
    }

}
