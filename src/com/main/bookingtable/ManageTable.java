package com.main.bookingtable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class ManageTable {
    public static int showTables(String date){
        int table = 0;
        String url = "jdbc:mysql://localhost:3306/bookingtable";
        String user = "root";
        String password = "admin";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(url, user, password);
            Statement statement = connect.createStatement();
            ResultSet resultSet =
                    statement.executeQuery("SELECT * FROM bookingtable bt WHERE bt.booking_date = "+date+" ");
            while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String checkIn = resultSet.getString("check_in");
                        String checkOut = resultSet.getString("check_out");
                        String totalPerson = resultSet.getString("total_person");
                        System.out.println(id + "," + checkIn + "," + checkOut + "," + totalPerson);
                    }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e ) {
            e.printStackTrace();
        }
        return table;
    }

}
