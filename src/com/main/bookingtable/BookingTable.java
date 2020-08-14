package com.main.bookingtable;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookingTable {
    private static Connection connect = null;
    private static Statement statement = null;
    private static boolean resultSet = false;
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            ManageTable manageTable = new ManageTable();
            int select = 0;
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Restaurant Table Booking System");
            System.out.println("===============================");
            while (select != 1 && select != 2) {
                System.out.println("เข้าสู่ระบบการจองโต๊ะอาหาร พิมพ์ 1 : ตรวจสอบจำนวนโต๊ะอาหารขั้นต่ำที่ต้องเตรียม พิมพ์ 2");
                select = input.nextInt();
                System.out.println(select);
            }
            if (select == 1) {
                String data[] = new String[6];
                System.out.println("กรุณากรอกชื่อผู้จอง: ");
                data[0] = input.next();
                System.out.println("กรุณากรอกเบอร์โทรศัพท์ที่ใช้ติดต่อ: ");
                data[1] = input.next();
                System.out.println("กรุณากรอกวันที่จะมาใช้บริการ (dd/MM/yyyy): ");
                data[2] = input.next();
                System.out.println("กรุณากรอกเวลาเข้าร้าน (hh:mm): ");
                data[3] = input.next();
                System.out.println("กรุณากรอกเวลาออกจากร้าน (hh:mm): ");
                data[4] = input.next();
                System.out.println("กรุณากรอกจำนวนลูกค้าที่จะมา: ");
                data[5] = input.next();
                String url = "jdbc:mysql://localhost:3306/bookingtable";
                String user = "root";
                String password = "admin";
                String customerName = data[0];
                String telNo = data[1];
                String bookingDate = data[2];
                String checkIn = data[3];
                String checkOut = data[4];
                String totalPerson = data[5];
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connect = DriverManager.getConnection(url,user,password);
                    statement = connect.createStatement();
                    String query ="INSERT INTO bookingtable (customer_name, telephone_number, booking_date, check_in, check_out, total_person) VALUES (?,?,?,?,?,?)";
                    PreparedStatement pst = connect.prepareStatement(query);
                    for(int i = 0; i<data.length; i++){
//                        if (i==2) {
//                            pst.setDate(i+1, (java.sql.Date) dateFormat.parse(data[i]));
//                        } else
                        pst.setString(i+1, data[i]);
                    }
                    pst.execute();
                    System.out.println("BOOKING COMPLETE");
                    pst.close();
//                    resultSet =
//                            statement.execute("INSERT INTO bookingtable VALUES ("+customerName+","+telNo+","+bookingDate+","+checkIn+","+checkOut+","+totalPerson+")");
//                    while (resultSet) {
//                        System.out.println("BOOKING COMPLETE");
//                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e ) {
                    e.printStackTrace();
                }
//                for(int i = 0 ; i < data.length; i++) {
//                    System.out.print(data[i] + " ");
//                }


            }
            else if (select == 2) {
                Date date = new Date();
                System.out.println("กรุณากรอกวันที (dd/MM/yyyy): ");
                date = dateFormat.parse(input.next());
                String strDate = dateFormat.format(date);
                int totalTable = manageTable.showTables(strDate);
//                System.out.print(dateFormat.format(date) + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
