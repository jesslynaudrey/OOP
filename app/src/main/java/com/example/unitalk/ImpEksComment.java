package com.example.unitalk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ImpEksComment {
    public static void main(String[] args) {

        // membuat atribut
        String user="root";
        String pwd="eagle6803";
        String host="192.168.1.6:3306";
        String db="uneedtalk";
        String urlValue="jdbc:mysql://"+host+"/"+db;

        //membuat objek IO
        Scanner scan = new Scanner(System.in);

        //cek error
        try{
            //koneksi database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(urlValue, user, pwd);
            PreparedStatement pStatement = null;


            String sql = "INSERT INTO Thread(idThread, Title, Content, Liked)"+"VALUES (?,?,?,?);";
            pStatement = conn.prepareStatement(sql);

            // nanti id bisa ke isi sendiri
            int id = scan.nextInt(); scan.nextLine();
            pStatement.setInt(1, id);

            //input kode mk
            System.out.print("TITLE: ");
            String title = scan.nextLine();
            pStatement.setString(2, title);

            System.out.print("CONTENT: ");
            String Content = scan.nextLine();
            pStatement.setString(3, Content);

            pStatement.setInt(4, 0);

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