package source.produk;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

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
			
			case 2: return p.getJenis();
			
			case 3: return p.getStok();
			case 4: return p.getHarga();
			case 5: return p.getNamaSuplier();
				default: return null;
		}
	}
	
	public boolean isCellEditable(int row, int col){
		if(col==0){
			return false;
		}else{	
			return true;
		}
	}
	
	public void setValueAt(Object value, int baris, int kolom) {
        Produk p = dataProduk.get(baris);
		String isi = (String) value;
		int isiAngka;
        switch(kolom){            
			case 1:		
				p.setNamaProduk(isi);
				break;
			case 2:				
				p.setJenis(isi);
				break;
			case 3:
				isiAngka = Integer.parseInt(isi);
				p.setStok(isiAngka);
				break;		
			case 4: 
				isiAngka = Integer.parseInt(isi);
				p.setHarga(isiAngka);
				break;
			case 5: 				
				p.setNamaSuplier(isi);
				break;
			default: break;
        }
        fireTableCellUpdated(baris, kolom);
    }
}