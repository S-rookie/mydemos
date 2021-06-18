package com.deng.modeltwo;

import com.deng.util.MQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author deng
 */
public class Consumer_two_one {

    private static String name = "我是消费者1";

    public static void main(String[] args) throws IOException {
        Connection connection = MQUtils.getConnection();
        Channel channel = MQUtils.getChannel(connection);
        channel.queueDeclare("work",true,false,false,null);
        channel.basicConsume("",true , new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(name+"接受到:"+new String(body));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
