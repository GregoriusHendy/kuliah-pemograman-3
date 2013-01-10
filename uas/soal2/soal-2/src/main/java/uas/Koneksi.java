package uas;

import java.sql.*;

public class Koneksi{
	public Connection koneksi;
	public Statement stm;
	public Koneksi(){
		try{
			koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/uasP3","root","");
			stm = koneksi.createStatement();
		}catch(SQLException SQLerr){
			SQLerr.printStackTrace();
		}
	}
}