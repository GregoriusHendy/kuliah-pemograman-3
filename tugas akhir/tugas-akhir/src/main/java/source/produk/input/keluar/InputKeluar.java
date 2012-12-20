package source.produk.input.keluar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import source.produk.Produk;
import source.produk.TabelProduk;
import source.koneksi.Koneksi;

public class InputKeluar extends Koneksi{
	private JPanel panelUtama;
	private final JComboBox cbProduk = new JComboBox();
	private final JTextField tfJumlah;
	private JButton bTambah;
	private List<Produk> dataProduk;
	private TabelProduk tp;
	
	public InputKeluar(final TabelProduk tp){
		this.tp = tp;
		
		panelUtama= new JPanel();
		tfJumlah  = new JTextField(20);
		bTambah   = new JButton("input");
		
		setCb();
		
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
		panelUtama.add(new JLabel("Input Barang keluar : "));
		
		gbc.gridwidth = 1;
		gbc.gridy=1;
		panelUtama.add(new JLabel("produk"),gbc);
		
		gbc.gridy=2;
		panelUtama.add(new JLabel("jumlah Keluar"),gbc);
		
		gbc.gridy=3;
		gbc.gridx=1;
		gBag.setConstraints(bTambah,gbc);
		panelUtama.add(bTambah,gbc);
		
		gbc.gridwidth=2;
		gbc.gridy=1;
		gBag.setConstraints(cbProduk,gbc);
		panelUtama.add(cbProduk,gbc);
		
		gbc.gridy=2;
		gBag.setConstraints(tfJumlah,gbc);
		panelUtama.add(tfJumlah,gbc);
		
		class TambahData implements ActionListener{
			public void actionPerformed(ActionEvent ae){
				Produk p = (Produk) cbProduk.getSelectedItem();
				
				int idProduk = p.getIdProduk();
				int stok = p.getStok();
				int jumlah = Integer.parseInt(tfJumlah.getText());
				if(stok<jumlah){
					JOptionPane.showMessageDialog(null,"stok tidak cukup");
				}else{
					stok=stok-jumlah;					
					try{						
						
						//untuk update
						String query="UPDATE stok_produk SET stok="+stok+" WHERE id_produk="+idProduk;
						int hasilUp = stm.executeUpdate(query);
						
						//untuk insert
						query="INSERT INTO pengeluaran(`id_produk`, `jumlah`) VALUES ('"+idProduk+"',"+jumlah+")";
						int hasilIn = stm.executeUpdate(query);
						
						if(hasilUp == 1 && hasilIn==1){
							tfJumlah.setText("");
							tp.setDataTabel();
							setCb();
							JOptionPane.showMessageDialog(null,"selesai");
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
		}
		
		bTambah.addActionListener(new TambahData());
		
	}
	
	public void setCb(){
		dataProduk = tp.getListProduk();
		DefaultComboBoxModel model = new DefaultComboBoxModel(dataProduk.toArray());
		cbProduk.setModel(model);
	}
	
	public JPanel getPanel(){
		return panelUtama;
	}
	
}