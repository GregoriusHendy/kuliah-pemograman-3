package source.produk.input.baru;

import source.produk.TabelProduk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class InputProduk{
	private JPanel panelTambah;
	private final JTextField tfNamaProduk,tfStok,tfHarga;
	private final JComboBox cbJenis,cbSuplier;
	private JButton bTambah;
	
	public InputProduk(final TabelProduk tp){
		panelTambah = new JPanel();
		tfNamaProduk= new  JTextField(20);
		tfStok      = new  JTextField(20);
		tfHarga     = new  JTextField(20);
		bTambah     = new JButton("tambah produk");

		//combobox vektor
		Vector vJenis  = new Vector();
		Vector vSuplier = new Vector();
		try{
			Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
			Statement stm = koneksi.createStatement();
			String query="SELECT * FROM jenis";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				vJenis.add(rs.getInt("id_jenis")-1,rs.getString("nama_jenis"));
			}
			
			query="SELECT * FROM suplier";
			rs = stm.executeQuery(query);
			while(rs.next()){
				vSuplier.add(rs.getInt("id_suplier")-1,rs.getString("nama_suplier"));
			}
		}catch(SQLException SQLerr){
			SQLerr.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		cbJenis = new  JComboBox(vJenis);
		cbSuplier = new  JComboBox(vSuplier);
		
		//tampilan tambah data
		GridBagLayout gBag = new GridBagLayout();
		panelTambah.setLayout(gBag);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,10,5,10);
		gbc.fill= GridBagConstraints.BOTH;
		
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.gridy=0;
		gbc.gridx=0;
		panelTambah.add(new JLabel("input produk"),gbc);
		
		gbc.gridwidth = 1;
		gbc.gridy=1;
		panelTambah.add(new JLabel("nama"),gbc);
		
		gbc.gridy=2;
		panelTambah.add(new JLabel("jenis"),gbc);
		
		gbc.gridy=3;
		panelTambah.add(new JLabel("stok"),gbc);
		
		gbc.gridy=4;
		panelTambah.add(new JLabel("harga"),gbc);
		
		gbc.gridy=5;
		panelTambah.add(new JLabel("suplier"),gbc);
		
		gbc.gridwidth = 2;
		gbc.gridy=1;
		gbc.gridx=1;
		gBag.setConstraints(tfNamaProduk,gbc);
		panelTambah.add(tfNamaProduk,gbc);
		
		gbc.gridy=3;
		gBag.setConstraints(tfStok,gbc);
		panelTambah.add(tfStok,gbc);
		
		gbc.gridy=4;
		gBag.setConstraints(tfHarga,gbc);
		panelTambah.add(tfHarga,gbc);
		
		gbc.gridwidth = 1;
		gbc.gridy=2;
		gBag.setConstraints(cbJenis,gbc);
		panelTambah.add(cbJenis,gbc);
		
		gbc.gridy=5;
		gBag.setConstraints(cbSuplier,gbc);
		panelTambah.add(cbSuplier,gbc);
		
		gbc.gridy=6;
		gbc.gridx=1;
		gBag.setConstraints(bTambah,gbc);
		panelTambah.add(bTambah,gbc);
		
		class InputListener implements ActionListener{
			public void actionPerformed(ActionEvent ae){
				String namaProduk = tfNamaProduk.getText();
				Integer stok = Integer.parseInt(tfStok.getText());				
				Integer harga = Integer.parseInt(tfHarga.getText());
				int idJenis = cbJenis.getSelectedIndex() + 1;
				int idSuplier = cbSuplier.getSelectedIndex() + 1;
					
				try{
					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
					Statement stm = koneksi.createStatement();
					
					//mencari id produk baru
					int idProduk = 0;
					String query = "SELECT id_produk FROM  produk ORDER BY  produk.id_produk ASC ";
					ResultSet rs = stm.executeQuery(query);
					while(rs.next()){
						idProduk=rs.getInt("id_produk") + 1;
					}
					
					String queryProduk="INSERT INTO produk(id_produk,nama_produk, id_jenis,harga, id_suplier) VALUES ("+idProduk+",'"+namaProduk+"',"+idJenis+","+harga+","+idSuplier+")";
					int hasilProduk = stm.executeUpdate(queryProduk);
					
					String queryStok = "INSERT INTO stok_produk(id_produk,stok) VALUES ("+idProduk+","+stok+")";
					int hasilStok = stm.executeUpdate(queryStok);
					if(hasilStok == 1 && hasilProduk==1){
						System.out.println("berhasil");	
						tp.setDataTabel();
						
						tfNamaProduk.setText("");
						tfStok.setText("");				
						tfHarga.setText("");
					}else{
						System.out.println("gagal");
					}
				}catch(SQLException SQLerr){
					SQLerr.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		bTambah.addActionListener(new InputListener());
	}
	
	public JPanel getPanel(){
		return panelTambah;
	}
}