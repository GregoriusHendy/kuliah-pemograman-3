package belajar.complex.componen;

public class Mahasiswa{
	private String npm;
	private String nama;
	
	public String getNpm(){
		return this.npm;
	}
	
	public void setNpm(String npm){
		this.npm = npm;
	}
	
	public String getNama(){
		return this.nama;
	}
	
	public void setNama(String nama){
		this.nama =nama;
	}
	
	public String toString(){
		return "["+this.npm+"]-"+this.nama;
	}
}