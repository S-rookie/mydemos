package com.deng;

import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

/**
 * @author deng
 * 生产者
 */
public class Provider {

    @Test
    public void testSendMessage(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 主机
        connectionFactory.setHost("127.0.0.1");
        // 端口
        connectionFactory.setPort(5672);
        // 设置连接哪个虚拟主机
    }
}
