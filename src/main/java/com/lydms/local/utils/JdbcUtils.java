package com.lydms.local.utils;

import com.lydms.local.domain.English;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class JdbcUtils {
    private Connection conn;

    // 获取数据库连接
    public Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 加载数据库驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/local"; // 连接数据库URL
        String userName = "root"; // 连接数据库的用户名
        String passWord = "root"; // 连接数据库密码
        try {
            conn = DriverManager.getConnection(url, userName, passWord); // 获取数据库连接
            if (conn != null) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // 返回Connection对象
    }

//    插入数据到数据库中
    public int addEnglish(English english) {
        conn = getConn(); // 获取数据库连接
        PreparedStatement statement=null;
        try {
             statement = conn.prepareStatement("insert into english values(?,?,?,?,?,?,?)"); // 定义插入数据库的预处理语句

            statement.setString(1,null);
            statement.setString(2, english.getEnglish() );
            statement.setString(3, english.getCodechinese());
            statement.setString(4, english.getChinese());
            statement.setString(5, english.getDay());
            statement.setString(6, english.getCategory());
            statement.setString(7, english.getRemark());
            int i = statement.executeUpdate();// 执行预处理语句
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                if (statement!=null){
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
