package source.suplier;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;

public class TableModelSuplier extends AbstractTableModel{
	private String[] namaKolom = new String[]{"id suplier","nama suplier","e-mail","telpon","kota","alamat"};
	
	private List<Suplier> dataSuplier = new ArrayList<Suplier>();
	
	public TableModelSuplier(List<Suplier> dataSuplier){
		this.dataSuplier = dataSuplier;
	}
	
	public String getColumnName(int col){
		return namaKolom[col].toString();
	}
	
	public int getRowCount(){
		return dataSuplier.size();
	}
	
	public int getColumnCount(){
		return namaKolom.length;
	}
	
	public Object getValueAt(int baris,int kolom){
		Suplier s = dataSuplier.get(baris);
		
		switch(kolom){
			case 0:return s.getIdSuplier();
			case 1:return s.getNamaSuplier();
			case 2:return s.getEmail();
			case 3:return s.getTelpon();
			case 4:return s.getKota();
			case 5:return s.getAlamat();
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
        Suplier s = dataSuplier.get(baris);
        String isi = (String) value;
        
        switch(kolom){            
			case 1:s.setNamaSuplier(isi);
				break;
			case 2:s.setEmail(isi);
				break;
			case 3:s.setTelpon(isi);
				break;
			case 4:s.setKota(isi);
				break;
			case 5:s.setAlamat(isi);
				break;
            default: break;
        }
        fireTableCellUpdated(baris, kolom);
    }
}
