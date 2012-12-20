package source.suplier.input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import source.suplier.TabelSuplier;
import source.koneksi.Koneksi;

public class InputSuplier extends Koneksi{
	private final JTextField tfNama,tfEmail,tfTelpon,tfKota;
	private final JTextArea taAlamat;
	private JPanel panelUtama;
	private JButton bTambah;
	
	public InputSuplier(final TabelSuplier ob){
		tfNama  = new JTextField(20);
		tfEmail = new JTextField(20);
		tfTelpon= new JTextField(10);
		tfKota  = new JTextField(10);
		taAlamat= new JTextArea(10,20);
		bTambah = new JButton("tambah");
		JScrollPane scAlmat = new JScrollPane(taAlamat);
		panelUtama = new JPanel();
		
		//untuk tampilan
		GridBagLayout gBag = new GridBagLayout();
		panelUtama.setLayout(gBag);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,10,5,10);
		gbc.fill= GridBagConstraints.BOTH;
		
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.gridy=0;
		gbc.gridx=0;
		panelUtama.add(new JLabel("Input Supplier : "));
		
		gbc.gridwidth = 1;
		gbc.gridy=1;
		panelUtama.add(new JLabel("nama suplier"),gbc);
		
		gbc.gridy=2;
		panelUtama.add(new JLabel("email"),gbc);
		
		gbc.gridy=3;
		panelUtama.add(new JLabel("telpon"),gbc);
		
		gbc.gridy=4;
		panelUtama.add(new JLabel("kota"),gbc);
		
		gbc.gridy=5;
		panelUtama.add(new JLabel("alamat"),gbc);
		
		gbc.gridwidth=2;
		gbc.gridy=1;	
		gbc.gridx=1;
		gBag.setConstraints(tfNama,gbc);
		panelUtama.add(tfNama,gbc);
		
		gbc.gridy=2;
		gBag.setConstraints(tfEmail,gbc);
		panelUtama.add(tfEmail,gbc);
		
		gbc.gridy=5;
		gBag.setConstraints(scAlmat,gbc);
		panelUtama.add(scAlmat,gbc);
		
		gbc.gridwidth=1;
		gbc.gridy=3;
		gBag.setConstraints(tfTelpon,gbc);
		panelUtama.add(tfTelpon,gbc);
		
		gbc.gridy=4;
		gBag.setConstraints(tfKota,gbc);
		panelUtama.add(tfKota,gbc);
		
		gbc.gridy=6;
		gBag.setConstraints(bTambah,gbc);
		panelUtama.add(bTambah,gbc);
		
		class InSupListener implements ActionListener{
			public void actionPerformed(ActionEvent ae){
				String nama  = tfNama.getText();
				String email = tfEmail.getText();
				String kota  = tfKota.getText();
				String telpon= tfTelpon.getText();
				String alamat= taAlamat.getText();
				
				try{					
					String query="INSERT INTO suplier(nama_suplier, email,telpon,kota,alamat) VALUES ('"+nama+"','"+email+"','"+kota+"','"+telpon+"','"+alamat+"')";
					int hasil = stm.executeUpdate(query);
					if(hasil ==1){
						ob.setDataTabel();
						tfNama.setText("");
						tfEmail.setText("");
						tfKota.setText("");
						tfTelpon.setText("");
						taAlamat.setText("");
						JOptionPane.showMessageDialog(null,"berhasil menambahkan suplier");
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
		
		bTambah.addActionListener(new InSupListener());		
	}
	
	public JPanel getPanel(){
		return panelUtama;
	}
}