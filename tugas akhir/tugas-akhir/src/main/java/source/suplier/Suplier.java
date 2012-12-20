package source.suplier;

public class Suplier{
	private int id_suplier;
	private String nama_suplier;
	private String email;
	private String telpon;
	private String kota;
	private String alamat;
	
	public void setIdSuplier(int id){
		this.id_suplier = id;
	}
	
	public int getIdSuplier(){
		return this.id_suplier;
	}
	
	public void setNamaSuplier(String nama){
		this.nama_suplier = nama;
	}
	
	public String getNamaSuplier(){
		return this.nama_suplier;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setTelpon(String telpon){
		this.telpon = telpon;
	}
	
	public String getTelpon(){
		return this.telpon;
	}
	
	public void setKota(String kota){
		this.kota = kota;
	}
	
	public String getKota(){
		return this.kota;
	}
	
	public void setAlamat(String alamat){
		this.alamat = alamat;
	}
	
	public String getAlamat(){
		return this.alamat;
	}
	
	public String toString(){
        return this.nama_suplier;
    }
	
}