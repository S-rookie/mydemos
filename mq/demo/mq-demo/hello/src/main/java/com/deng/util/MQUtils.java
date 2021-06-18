package com.deng.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author deng
 */
public class MQUtils {

    private static Connection connection;

    private static ConnectionFactory connectionFactory;

    static {
        try {
            connectionFactory = new ConnectionFactory();
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
            connection = connectionFactory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        // 获取连接对象
        return connection;
    }

    /**
     * 获取管道
     * @return
     */
    public static Channel getChannel(Connection connection) throws IOException {
        return connection.createChannel();
    }

}
