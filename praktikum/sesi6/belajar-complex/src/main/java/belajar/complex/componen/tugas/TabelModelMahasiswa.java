package belajar.complex.componen.tugas;

import javax.swing.table.AbstractTableModel;

import java.util.List;
import java.util.ArrayList;

public class TabelModelMahasiswa extends AbstractTableModel{
	private String[] namaKolom = new String[]{"NPM","Nama","Hoby"};
	
	private List<Mahasiswa> dataMh = new ArrayList<Mahasiswa>();
	
	public TabelModelMahasiswa(List<Mahasiswa> data){
		this.dataMh = data;
	}
	
	public String getColumnName(int col){
		return namaKolom[col].toString();
	}
	
	public int getRowCount(){
		return dataMh.size();
	}
	
	public int getColumnCount(){
		return namaKolom.length;
	}
	
	public Object getValueAt(int baris,int kolom){
		Mahasiswa m = dataMh.get(baris);
		
		switch(kolom){
			case 0:return m.getNpm();			
			case 1:return m.getNama();				
			case 2:return m.getHoby();	
			default: return  null;
		}
	}
	
	public boolean isCellEditable(int row, int col){
		return true;
	}
	
	public void setValueAt(Object value, int baris, int kolom){
		Mahasiswa m = dataMh.get(baris);
		String isi = (String) value;
		
		switch(kolom){
			case 0:m.setNpm(isi);
				break;
			case 1:m.setNama(isi);
				break;
			case 2:m.setHoby(isi);
				break;
			default: break;
		}		
		fireTableCellUpdated(baris, kolom);
	}
}