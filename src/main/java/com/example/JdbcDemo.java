package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "qwer1234";
        // 参数化 SQL，用 ? 占位
        String sql = "SELECT id, name FROM student WHERE id BETWEEN ? AND ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // 设置参数：查询 id 在 1 到 10 之间的记录
            ps.setInt(1, 1);
            ps.setInt(2, 10);

            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("连接成功");
                System.out.println("查询结果:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    System.out.println("ID: " + id + ", 姓名: " + name);
                }
            }
        } catch (SQLException e) {
            System.err.println("查询失败：" + e.getMessage());
        }
    }
}