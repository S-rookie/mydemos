package com.deng.modelone;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author deng
 */
public class Consumer_one {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 主机
        connectionFactory.setHost("127.0.0.1");
        // 端口
        connectionFactory.setPort(5672);
        // 设置连接哪个虚拟主机
        connectionFactory.setVirtualHost("/ems");
        // 用户名
        connectionFactory.setUsername("ems");
        // 密码
        connectionFactory.setPassword("ems");
        // 获取连接对象
        Connection connection = null;
        Channel channel = null;
        try {
            connection = connectionFactory.newConnection();
            // 通过连接获取通道
            channel = connection.createChannel();
            //通道绑定消息队列
            /**
             *     参数
             *     1、消息队列名称，如果不存在则自动创建
             *     2、队列特性是否需要持久化
             *     3、exclusive是否独占队列
             *     4、autoDelete是否在消费完成后自动删除队列
             *     5、额外附加参数
             */
            channel.queueDeclare("hello", true, false, false, null);
            // 发布消息
            /**
             *      参数
             *      1、消费的队列的名称
             *      2、消息的自动确认机制
             *      3、消费时回调的接口
             */
            String msg = "hello mq";
            channel.basicConsume("hello", true, new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("new String = " + new String(body));
                }
            });
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

}
