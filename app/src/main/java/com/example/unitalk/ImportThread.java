package com.example.unitalk;

import java.sql.*;
import java.util.Scanner;

public class ImportThread {
    public static void main(String[] args) {

        // membuat atribut
        String user="root";
        String pwd="eagle6803";
        String host="127.0.0.1";
        String db="uneedtalk";
        String urlValue= "jdbc:jtds:sqlserver://"+ host + ":"+1433+";"+ "databasename="+db;
        //membuat objek IO
        Scanner scan = new Scanner(System.in);

        //cek error
        try{
            //koneksi database
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection conn = DriverManager.getConnection(urlValue);
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