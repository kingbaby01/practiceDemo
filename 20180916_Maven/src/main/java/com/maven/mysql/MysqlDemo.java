package com.maven.mysql;

import org.junit.*;

import java.sql.*;

public class MysqlDemo {
    private Connection conn = null;
    @Before
    public void init() throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.52.131:3306/maven";
        String user = "root";
        String password = "";

        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, password);
    }

    @Test
    public void selectTest() throws Exception {
        Statement stat = conn.createStatement();
        String sql = "SELECT * FROM students";
        ResultSet res = stat.executeQuery(sql);

        while (res.next()){
            String id = res.getString("s_id");
            String name = res.getString("s_name");
            int age = res.getInt("s_age");
            System.out.println(id+","+name+","+age);
        }

        res.close();
        stat.close();
    }

    @Test
    public void insertTest() throws SQLException {
        PreparedStatement stat = conn.prepareStatement("INSERT INTO students " +
                "(s_id,s_name,s_age) VALUES (?,?,?)");
        stat.setString(1, "0002");
        stat.setString(2, "Tom");
        stat.setInt(3, 6);

        stat.executeUpdate();
    }

    @Test
    public void updateTest() throws SQLException {
        PreparedStatement stat = conn.prepareStatement("UPDATE students SET s_age=? " +
                "WHERE s_id=?");
        stat.setInt(1, 26);
        stat.setString(2, "0002");

        stat.executeUpdate();
    }

    @Test
    public void deleteTest() throws SQLException {
        PreparedStatement stat = conn.prepareStatement("DELETE FROM students" +
                " WHERE s_id=?");
        stat.setString(1, "0002");

        stat.executeUpdate();
    }


    @After
    public void release() throws SQLException {
        conn.close();
    }
}
