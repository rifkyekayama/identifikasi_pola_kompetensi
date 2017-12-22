/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author rifky
 */
public class Database {
    Statement stmt = null;
    ResultSet rs = null;
    Connection koneksi;
    SQLiteConn myCon;

    public Database(){
        myCon = new SQLiteConn();
        koneksi = myCon.ConnectDB();
    }
    
    
    public ArrayList<String> getData() {
        ArrayList<String> hasil = new ArrayList<String>();
        try{
            stmt = koneksi.createStatement();
            rs = stmt.executeQuery("SELECT * FROM kebutuhan_kompetensi");
            while(rs.next()){
                String data = "";
                data = rs.getString("Jenis_Kebutuhan");
                hasil.add(data);
            }
            stmt.close();
            rs.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return hasil;
    }
}
