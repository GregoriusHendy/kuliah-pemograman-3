package source.produk;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;

public class TableModelProduk extends AbstractTableModel{
	private String[] namaKolom = new String[]{"id produk","nama produk","jenis","stok","harga","suplier"};
	
	private List<Produk> dataProduk = new ArrayList<Produk>();
	
	public TableModelProduk(List<Produk> dataProduk){
		this.dataProduk = dataProduk;
	}
	
	public String getColumnName(int col){
		return namaKolom[col].toString();
	}
	
	public int getRowCount(){
		return dataProduk.size();
	}
	
	public int getColumnCount(){
		return namaKolom.length;
	}
	
	public Object getValueAt(int baris,int kolom){
		Produk p = dataProduk.get(baris);
		
		switch(kolom){
			case 0: return p.getIdProduk();
			case 1: return p.getNamaProduk();
			case 3: return p.getStok();
			case 2: return p.getJenis();
			case 4: return p.getHarga();
			case 5: return p.getNamaSuplier();
				default: return null;
		}
	}
}