package belajar.swing.jtabel;

import javax.swing.table.AbstractTableModel;

import java.util.List;
import java.util.ArrayList;

public class TabelModelProduk extends AbstractTableModel{
	private String[] namaKol = new String[]{"Symbol","nama","harga"};
	
	private List<Produk> dataProduk = new ArrayList<Produk>();
	
	public TabelModelProduk(List<Produk> dataProduk){
		this.dataProduk = dataProduk;
	}
	
	public String getColumnName(int col){
		return namaKol[col].toString();
	}
	
	public int getRowCount(){
		return dataProduk.size();
	}
	
	public int getColumnCount(){
		return namaKol.length;
	}
	
	public Object getValueAt(int baris, int kolom){
		Produk p = dataProduk.get(baris);
		
		switch(kolom){
			case 0:return p.getSimbol();
			case 1:return p.getNama();
			case 2:return p.getHarga();
			default: return null;
		}		
	}
	
	public boolean isCellEditable(int row,int col){
		return true;
	}
	
	public void setValueAt(Object value, int baris, int kolom){
		Produk p = dataProduk.get(baris);
		String isi = (String) value;
		
		switch(kolom){
			case 0:p.setSimbol(isi);
				break;
			case 1:p.setNama(isi);
				break;
			case 2:
				Integer harga= (Integer) value;
				p.setHarga(harga);
				break;
			default:break;
		}
		fireTableCellUpdated(baris,kolom);
	}
	
}