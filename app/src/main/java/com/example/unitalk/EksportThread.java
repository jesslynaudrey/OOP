package com.example.unitalk;

import java.sql.*;
import java.util.Scanner;

public class EksportThread {
    public static void main(String[] args) {

        String user="root";
        String pwd="eagle6803";
        String host="localhost";
        String db="uneedtalk";
        String urlValue="jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pwd;

        Scanner scan = new Scanner(System.in);

        try{
            //koneksi database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(urlValue);
            PreparedStatement pStatement = null;


            String sql = "SELECT * FROM Thread";
            pStatement = conn.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery(sql);

            while (result.next()){
                int id = result.getInt("idThread");
                String Title = result.getString("Title");
                String Content = result.getString("Content");
                int Liked = result.getInt("Liked");

                // thread interface

                System.out.printf(id + " " + Title + " " + Content + " " + Liked + "\n");
            }

            //close koneksi
            scan.close();
            pStatement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal"+e.toString());
        } catch(ClassNotFoundException e) {
            System.out.println("JDBC Driver tidak di temukan");

        }
    }
}
