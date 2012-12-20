package source.suplier;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

import source.koneksi.Koneksi;

public class TabelSuplier extends Koneksi{
	private List<Suplier> dataSuplier;
	private JTable tabel = new JTable();
	// private JTextField tfFilter;
	// private JButton bFilter;
	private JButton bHapus;
	
	private JPanel panelUtama;
	// private JPanel panelFilter;	
	private JPanel panelButton;
	private JScrollPane srcTabel;
	public TabelSuplier(){
		// tfFilter   = new JTextField(30);
		// bFilter    = new JButton("filter");
		bHapus     = new JButton("hapus");
		
		panelUtama = new JPanel(new BorderLayout());
		// panelFilter= new JPanel();  
		panelButton= new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		//data tabel
		setDataTabel();
		srcTabel = new JScrollPane(tabel);
		
		// panelUtama.add(panelFilter,"North");
		panelUtama.add(srcTabel,"Center");
		panelUtama.add(panelButton,"South");
		
		//filter
		// panelFilter.add(new JLabel("filter : "));
		// panelFilter.add(tfFilter);
		// panelFilter.add(bFilter);
		
		//untuk button
		panelButton.add(bHapus);
		
		class HapusListener implements ListSelectionListener,ActionListener{			
			private int idSuplier;
			
			public void valueChanged(ListSelectionEvent e){			
				int baris = tabel.getSelectedRow();
				
				if(baris > -1) {
					Suplier s = dataSuplier.get(baris);
					idSuplier = s.getIdSuplier();
				}
			}
			
			public void actionPerformed(ActionEvent ev){
				try{					
					String query="DELETE FROM suplier WHERE id_suplier="+idSuplier;
					int hasil = stm.executeUpdate(query);
					
					if(hasil== 1){						
						setDataTabel();
						JOptionPane.showMessageDialog(null,"berhasil hapus");
					}else{
						JOptionPane.showMessageDialog(null,"gagal");
					}
				}catch(SQLException SQLerr){
					SQLerr.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}
			}			
		}
		
		HapusListener hl= new HapusListener();		
		tabel.getSelectionModel().addListSelectionListener(hl);
		bHapus.addActionListener(hl);
	}
	
	public void setDataTabel(){
		dataSuplier = new ArrayList<Suplier>();
		try{			
			String qry = "SELECT * FROM suplier";
			ResultSet rs = stm.executeQuery(qry);
			while(rs.next()){
				Suplier s = new Suplier();
				s.setIdSuplier(rs.getInt("id_suplier"));
				s.setNamaSuplier(rs.getString("nama_suplier"));
				s.setEmail(rs.getString("email"));
				s.setTelpon(rs.getString("telpon"));
				s.setKota(rs.getString("kota"));
				s.setAlamat(rs.getString("alamat"));
				dataSuplier.add(s);
			}
		}catch(Exception err){
			err.printStackTrace();
		}
		
		TableModelSuplier model = new TableModelSuplier(dataSuplier);
		tabel.setModel(model);
		tabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		class EditSuplierListener implements TableModelListener{
			public void tableChanged(TableModelEvent tme){
				int baris = tme.getFirstRow();
				int kolom = tme.getColumn();
				
				TableModel model = (TableModel)tme.getSource();
				int id  = (Integer) model.getValueAt(baris,0);
				String isi = (String) model.getValueAt(baris,kolom);
				
				String query="";
				switch(kolom){
					case 1:
						query="UPDATE suplier SET nama_suplier`='"+isi+"' WHERE id_suplier="+id;
						break;
					case 2:
						query="UPDATE suplier SET email='"+isi+"' WHERE id_suplier="+id;
						break;
					case 3:						
						query="UPDATE suplier SET telpon='"+isi+"' WHERE id_suplier="+id;
						break;
					case 4:
						query="UPDATE suplier SET kota='"+isi+"' WHERE id_suplier="+id;
						break;
					case 5:
						query="UPDATE suplier SET alamat='"+isi+"' WHERE id_suplier="+id;
						break;
					default:break;					
				}
				
				System.out.println(query);
				try{					
					int hasil = stm.executeUpdate(query);
					
					if(hasil== 1){						
						setDataTabel();
						JOptionPane.showMessageDialog(null,"berhasil edit");
					}else{
						JOptionPane.showMessageDialog(null,"gagal");
					}
				}catch(SQLException SQLerr){
					SQLerr.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}				
			}
		}		
		model.addTableModelListener(new EditSuplierListener()); 
	}
	
	public List<Suplier> getListSuplier(){
		return dataSuplier;
	}
	
	public JPanel getPanel(){
		return panelUtama;
	}
	
	public TabelSuplier getObject(){
		return this;
	}
}
