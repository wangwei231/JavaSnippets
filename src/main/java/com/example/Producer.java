package com.example;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Producer {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        try (Connection conn = RabbitUtil.newConnection();
             Channel ch   = conn.createChannel()) {

            // 声明队列（幂等，不存在才创建）
            ch.queueDeclare(QUEUE_NAME, false, false, false, null);

            String msg = "Hello RabbitMQ!";
            ch.basicPublish("", QUEUE_NAME, null, msg.getBytes("UTF-8"));
            System.out.println("Sent: " + msg);
        }
    }
}
