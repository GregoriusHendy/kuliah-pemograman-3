package belajar.complex.componen.tugas;

public class Mahasiswa{
	private String npm;
	private String nama;
	private String hoby;
	
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
		this.nama = nama;
	}
	
	public String getHoby(){
		return this.hoby;
	}
	
	public void setHoby(String hoby){
		this.hoby = hoby;
	}
	
	public String toString(){
		return this.npm+"-"+this.nama+"-"+this.hoby;
	}
}