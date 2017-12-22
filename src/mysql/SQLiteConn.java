/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author M Farqi Zuhdi
 */

public class SQLiteConn {
    private Connection conn;
   
    public Connection ConnectDB(){
        
       //untuk koneksi ke driver
       try{
           Class.forName("org.sqlite.JDBC");
           //JOptionPane.showMessageDialog(null, "Berhasil Load Driver");
       }catch(ClassNotFoundException ex){
           JOptionPane.showMessageDialog(null, "Tidak ada Driver!\n" + ex);
       }
       
       //untuk koneksi ke database
       try {
           String url="jdbc:sqlite:db/kuesioner.db";
           conn=DriverManager.getConnection(url);
           //System.out.println("Berhasil Koneksi");
       }catch(SQLException se){
           System.out.println("Gagal Koneksi "+se);
           JOptionPane.showMessageDialog(null,"Gagal Koneksi Database","Peringatan",JOptionPane.WARNING_MESSAGE);
       }
       return conn;
    }
}
