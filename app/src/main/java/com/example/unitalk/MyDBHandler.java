package com.example.unitalk;

import java.io.*;
import java.sql.*;
import java.util.Scanner;


public class MyDBHandler {
    public static void main(String[] args) throws IOException {

        // membuat atribut
        String user="root";
        String pwd="";
        String host="localhost";
        String db="uniTalk";
        String urlValue="jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pwd;

        //membuat objek IO
        Scanner scan = new Scanner(System.in);

        //cek error
        try{
            //koneksi database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(urlValue);
            PreparedStatement pStatement = null;


            String sql = "INSERT INTO Thread(idThread, Title, Content, Liked)"+"VALUES (?,?,?,?);";
            pStatement = conn.prepareStatement(sql);

            int id = scan.nextInt(); scan.nextLine();
            pStatement.setInt(1, id);

            //input kode mk
            System.out.print("TITLE: ");
            String title = scan.nextLine();
            pStatement.setString(2, title);

            System.out.print("CONTENT: ");
            String Content = scan.nextLine();
            pStatement.setString(3, Content);

            int Liked = scan.nextInt(); scan.nextLine();
            pStatement.setInt(4, Liked);

            //cek data berhasil ditambahkan atau gagal
            int intBaris=pStatement.executeUpdate();
            if (intBaris>0) {
                System.out.println("Berhasil menambahkan data");
            } else {
                System.out.println("Penambahan data gagal"); }

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