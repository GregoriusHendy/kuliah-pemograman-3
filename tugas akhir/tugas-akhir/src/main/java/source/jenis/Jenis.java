package source.jenis;

import java.sql.*;

public class Jenis{
	private int id_Jenis;
	private String nama_Jenis;
	
	public void setIdJenis(int id){
		this.id_Jenis = id;
	}
	
	public void setNamaJenis(String nama){
		this.nama_Jenis = nama;
	}
	
	public int getIdJenis(){
		return this.id_Jenis;
	}
	
	public String getNamaJenis(){
		return this.nama_Jenis;
	}
	
	public String toString(){
        return this.nama_Jenis;
    }
}