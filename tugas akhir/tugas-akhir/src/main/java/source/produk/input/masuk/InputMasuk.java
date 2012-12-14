package source.produk.input.masuk;

import source.produk.input.MainInput;
import source.produk.TabelProduk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import source.produk.Produk;
import source.produk.TabelProduk;

public class InputMasuk{
	private JPanel panelUtama;
	private JComboBox cbProduk = new JComboBox();
	private JTextField tfJumlah;
	private JButton bTambah;
	private List<Produk> listP = new ArrayList<Produk>();
	
	public InputMasuk(TabelProduk tp){
		panelUtama= new JPanel();
		tfJumlah  = new JTextField(20);
		bTambah   = new JButton("input");
		
		DefaultComboBoxModel model = new DefaultComboBoxModel(listP.toArray());
		cbProduk.setModel(model);
		
		
		// HashMap hmP = new HashMap();		
		
		// try{
			// Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
			// Statement stm = koneksi.createStatement();
			// String query="SELECT * FROM produk";
			// ResultSet rs = stm.executeQuery(query);
			// while(rs.next()){
				// hmP.put(rs.getInt("id_produk"),rs.getString("nama_produk"));
			// }
		// }catch(SQLException SQLerr){
			// SQLerr.printStackTrace();
		// }catch(Exception e){
			// e.printStackTrace();
		// }
		
		//tampil tambah data
		GridBagLayout gBag = new GridBagLayout();
		panelUtama.setLayout(gBag);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,10,5,10);
		gbc.fill= GridBagConstraints.BOTH;
		
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.gridy=0;
		gbc.gridx=0;
		panelUtama.add(new JLabel("Input Barang Masuk"));
		
		gbc.gridwidth = 1;
		gbc.gridy=1;
		panelUtama.add(new JLabel("produk"),gbc);
		
		gbc.gridy=2;
		panelUtama.add(new JLabel("jumlah masuk"),gbc);
		
		gbc.gridy=1;
		gbc.gridx=1;
		gBag.setConstraints(cbProduk,gbc);
		panelUtama.add(cbProduk,gbc);
		
		gbc.gridy=2;
		gBag.setConstraints(tfJumlah,gbc);
		panelUtama.add(tfJumlah,gbc);
		
	}
	
	public JPanel getPanel(){
		return panelUtama;
	}
	
}