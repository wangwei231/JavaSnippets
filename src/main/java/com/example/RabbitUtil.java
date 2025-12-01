package com.example;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public final class RabbitUtil {
    private RabbitUtil() {}

    public static Connection newConnection() throws Exception {
        ConnectionFactory f = new ConnectionFactory();
        f.setHost("localhost");
        f.setPort(5672);
        f.setUsername("guest");
        f.setPassword("guest");
        // 自动重连、心跳 30s 等可按需设置
        return f.newConnection();
    }
}

