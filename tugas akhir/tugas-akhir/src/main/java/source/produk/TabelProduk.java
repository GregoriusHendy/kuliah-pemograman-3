package source.produk;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.event.*;
import java.awt.event.*;

public class TabelProduk{
	private final JTable tabel = new JTable();
	private JTextField tfFilter;
	private JButton bFilter;
	private JButton bHapus;
	
	private JPanel panelUtama;
	private JPanel panelFilter;	
	private JPanel panelButton;
	private JScrollPane srcTabel;	
	
	private List<Produk> dataProduk;
	
	public TabelProduk(){
		tfFilter = new JTextField(30);
		bFilter = new JButton("filter");
		bHapus= new JButton("hapus");
		
		
		panelUtama=new JPanel(new BorderLayout());
		panelFilter = new JPanel();		
		panelButton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		//panel utama
		setDataTabel();
		srcTabel = new JScrollPane(tabel);
		
		panelUtama.add(panelFilter,"North");
		panelUtama.add(srcTabel,"Center");
		panelUtama.add(panelButton,"South");
		
		//filter
		panelFilter.add(new JLabel("filter : "));
		panelFilter.add(tfFilter);
		panelFilter.add(bFilter);
		
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
					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
					Statement stm = koneksi.createStatement();
					
					String query="DELETE FROM stok_produk WHERE id_produk="+idProduk;
					int hasil = stm.executeUpdate(query);
					
					if(hasil== 1){
						System.out.println("berhasil");	
						query="DELETE FROM produk WHERE id_produk="+idProduk;
						hasil = stm.executeUpdate(query);
						if(hasil == 1){
							System.out.println("berhasil keseluruhan");	
							setDataTabel();
						}					
					}else{
						System.out.println("gagal");
					}
				}catch(SQLException SQLerr){
					SQLerr.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}
				System.out.println(idProduk);
			}			
		}
		
		HapusListener hl= new HapusListener();		
		tabel.getSelectionModel().addListSelectionListener(hl);
		bHapus.addActionListener(hl);
		
	}
	
	public void setDataTabel(){
		//ambil data dari database untuk tabel
		dataProduk = new ArrayList<Produk>();
		try{
			Connection koneksi= DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
			String qry = "SELECT * FROM produk,suplier,jenis,stok_produk WHERE produk.id_jenis = jenis.id_jenis AND produk.id_suplier = suplier.id_suplier AND produk.id_produk=stok_produk.id_produk";
			Statement stm =koneksi.createStatement();
			ResultSet rs = stm.executeQuery(qry);
			while(rs.next()){
				Produk p = new Produk();
				p.setIdProduk(rs.getInt("id_produk"));
				p.setNamaProduk(rs.getString("nama_produk"));
				p.setJenis(rs.getString("nama_jenis"));
				p.setHarga(rs.getInt("harga"));
				p.setStok(rs.getInt("stok"));
				p.setNamaSuplier(rs.getString("nama_suplier"));
				dataProduk.add(p);
			}
		}catch(Exception err){
			err.printStackTrace();
		}
		TableModelProduk model = new TableModelProduk(dataProduk);
		tabel.setModel(model);	
	}
	
	public JPanel getPanel(){
		return panelUtama;
	}	
	
	public TabelProduk getObject(){
		return this;
	}
}