package com.example;


import com.rabbitmq.client.*;

public class Consumer {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        Connection conn = RabbitUtil.newConnection();
        Channel ch      = conn.createChannel();

        ch.queueDeclare(QUEUE_NAME, false, false, false, null);

        DeliverCallback callback = (consumerTag, delivery) -> {
            String msg = new String(delivery.getBody(), "UTF-8");
            System.out.println("Received: " + msg);
        };

        // 自动确认（autoAck=true）
        ch.basicConsume(QUEUE_NAME, true, callback, consumerTag -> {});
    }
}
