package com.deng.modelone;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author deng
 * 生产者
 */
public class Provider_one {

    @Test
    public void testSendMessage(){
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
            channel.queueDeclare("hello",true,false,false,null);
            // 发布消息
            /**
             *      参数
             *      1、交换机名称
             *      2、队列名称
             *      3、传递消息额外设置
             *      4、消息具体内容
             */
            String msg = "hello mq";
            channel.basicPublish("","hello",null,msg.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }
}
