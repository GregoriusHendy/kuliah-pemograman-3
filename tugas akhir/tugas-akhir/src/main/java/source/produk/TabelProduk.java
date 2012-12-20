package source.produk;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.event.*;
import java.awt.event.*;

import source.jenis.Jenis;
import source.koneksi.Koneksi;

public class TabelProduk extends Koneksi{
	private final JTable tabel = new JTable();
	// private JTextField tfFilter;
	// private JButton bFilter;
	private JButton bHapus;
	
	private JPanel panelUtama;
	// private JPanel panelFilter;	
	private JPanel panelButton;
	private JScrollPane srcTabel;	
	
	private List<Produk> dataProduk;
	private TableModelProduk model;
	private List<Jenis> dataJenis;
	
	public TabelProduk(){
		// tfFilter = new JTextField(30);
		// bFilter = new JButton("filter");
		bHapus= new JButton("hapus");
		
		panelUtama=new JPanel(new BorderLayout());
		// panelFilter = new JPanel();		
		panelButton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		//set jenis
		setJenis();
		
		//panel utama
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
			private int idProduk;
			
			public void valueChanged(ListSelectionEvent e){			
				int baris = tabel.getSelectedRow();
				
				if(baris > -1) {
					Produk p = dataProduk.get(baris);
					idProduk = p.getIdProduk();					
				}
			}
			
			public void actionPerformed(ActionEvent ev){
				try{					
					//stok
					String query="DELETE FROM stok_produk WHERE id_produk="+idProduk;
					int hasil1 = stm.executeUpdate(query);
					
					//pemasukkan
					query="DELETE FROM pemasukan WHERE id_produk="+idProduk;
					int hasil2 = stm.executeUpdate(query);
					
					//pengeluaran
					query="DELETE FROM pengeluaran WHERE id_produk="+idProduk;
					int hasil3 = stm.executeUpdate(query);
					
					//produk
					query="DELETE FROM produk WHERE id_produk="+idProduk;
					int hasil4 = stm.executeUpdate(query);
					
					if(hasil1== 1 || hasil2== 1 || hasil3== 1 && hasil4==1){
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
	
	//ambil data dari database untuk tabel
	public void setDataTabel(){
		//combobox jenis		
		JComboBox cbJenis = new JComboBox();
		cbJenis.setModel(new DefaultComboBoxModel(dataJenis.toArray()));
		
		dataProduk = new ArrayList<Produk>();
		try{			
			String qry = "SELECT * FROM produk,suplier,jenis,stok_produk WHERE produk.id_jenis = jenis.id_jenis AND produk.id_suplier = suplier.id_suplier AND produk.id_produk=stok_produk.id_produk";
			ResultSet rs = stm.executeQuery(qry);
			while(rs.next()){
				Produk p = new Produk();
				p.setIdProduk(rs.getInt("id_produk"));
				p.setNamaProduk(rs.getString("nama_produk"));
				p.setJenis(rs.getString("nama_jenis"));
				p.setHarga(rs.getInt("harga"));
				p.setStok(rs.getInt("stok"));
				p.setNamaSuplier(rs.getString("nama_suplier"));
				
				p.setComboJenis(cbJenis);
				
				dataProduk.add(p);
			}
		}catch(Exception err){
			err.printStackTrace();
		}
		
		model = new TableModelProduk(dataProduk);
		tabel.setModel(model);
		tabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		class EditProdukListener implements TableModelListener{
			public void tableChanged(TableModelEvent tme){
				int baris = tme.getFirstRow();
				int kolom = tme.getColumn();
				
				TableModel model = (TableModel)tme.getSource();
				int id  = (Integer) model.getValueAt(baris,0);
				
				String query="";
				switch(kolom){
					case 1:						
						String nama= (String) model.getValueAt(baris,kolom);
						query="UPDATE produk SET nama_produk='"+nama+"' WHERE id_produk="+id;
						prosesEdit(query);
						break;
					case 2:						
						String jenis= (String) model.getValueAt(baris,kolom);
						try{
							query="select * from jenis where nama_jenis='"+jenis+"'";
							ResultSet rs = stm.executeQuery(query);
							if(rs.next()){
								int idJenis = rs.getInt("id_jenis");
								query="UPDATE produk SET id_jenis="+idJenis+" WHERE id_produk="+id;
								prosesEdit(query);
							}else{
								setDataTabel();
								JOptionPane.showMessageDialog(null,"gagal,jenis tidak ada");
							}
						}catch(SQLException SQLerr){
							SQLerr.printStackTrace();
						}
						break;
					case 3:						
						int stok=(Integer) model.getValueAt(baris,kolom);
						query="UPDATE `stok_produk` SET stok="+stok+" WHERE id_produk="+id;
						prosesEdit(query);
						break;
					case 4:
						int harga=(Integer) model.getValueAt(baris,kolom);
						query="UPDATE produk SET harga="+harga+" WHERE id_produk="+id;
						prosesEdit(query);
						break;
					case 5:
						String suplier= (String) model.getValueAt(baris,kolom);
						try{						
							query="SELECT * FROM suplier WHERE nama_suplier='"+suplier+"'";
							ResultSet rs = stm.executeQuery(query);
							if(rs.next()){
								int idSuplier = rs.getInt("id_suplier");
								query="UPDATE produk SET id_suplier="+idSuplier+" WHERE id_produk="+id;
								prosesEdit(query);
							}else{
								setDataTabel();
								JOptionPane.showMessageDialog(null,"gagal,suplier belum terdaftar");
							}
						}catch(SQLException SQLerr){
							SQLerr.printStackTrace();
						}
						break;
					default:break;					
				}				
			}
			
			private void prosesEdit(String query){
				try{
					int hasil = stm.executeUpdate(query);					
					if(hasil== 1){
						setDataTabel();
						JOptionPane.showMessageDialog(null,"edit berhasil");
					}else{
						JOptionPane.showMessageDialog(null,"gagal");
					}
				}catch(SQLException SQLerr){
					SQLerr.printStackTrace();
				}
			}			
		}		
		model.addTableModelListener(new EditProdukListener()); 
	}
	
	public void setJenis(){
		dataJenis = new ArrayList<Jenis>();
		try{			
			String qry = "SELECT * from jenis";
			ResultSet rs = stm.executeQuery(qry);
			while(rs.next()){
				Jenis j = new Jenis();
				j.setIdJenis(rs.getInt("id_jenis"));
				j.setNamaJenis(rs.getString("nama_jenis"));			
				dataJenis.add(j);
			}
		}catch(SQLException SQLerr){
			SQLerr.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<Produk> getListProduk(){
		return dataProduk;
	}
	
	public List<Jenis> getListJenis(){
		return dataJenis;
	}
	
	public JPanel getPanel(){
		return panelUtama;
	}	
	
	public TabelProduk getObject(){
		return this;
	}
}