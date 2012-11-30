package belajar.complex.componen;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;


public class DemoCombo{
	private static JComboBox cmbMahasiswa = new JComboBox();
	private static final List<String> daftarMahasiswa = new ArrayList<String>();
	
	public static void isiCombo(){
		//data dimasukkan kedalam class model
		DefaultComboBoxModel model = new DefaultComboBoxModel(daftarMahasiswa.toArray());
		
		//pasang model di combo
		cmbMahasiswa.setModel(model);
	}
	
	public static void tambahIsiCombo(String data){
		//data untuk dita,pilkan dalam combo
		daftarMahasiswa.add(data);
		isiCombo();
	}
	
    public static void main( String[] args ){
		tambahIsiCombo("endy");
		
		JLabel lbl= new JLabel("nama Mahasiswa : ");
		final JTextField tfMahasiswa= new JTextField(20);
		JButton bTambah = new JButton("Tambah");
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(lbl);
		panel.add(tfMahasiswa);
		panel.add(bTambah);
		
		JPanel panel2= new JPanel();
		panel2.add(cmbMahasiswa);
		
		JPanel panel3 = new JPanel(new FlowLayout());
		panel3.add(new JLabel("pilihan :"));
		final JTextField tfPilihan = new JTextField(20);
		tfPilihan.setEditable(false);
		panel3.add(tfPilihan);
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(3,1));
		
		panel4.add(panel);
		panel4.add(panel2);
		panel4.add(panel3);
		
		JFrame fr = new JFrame("Belajar combo");
		fr.getContentPane().add(panel4);
		fr.setSize(800,200);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
		
		//event handler untuk button
		class TambahMahasiswaListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				//mengambikl value dari textField tfMahasiswa
				String data= tfMahasiswa.getText();
				System.out.println("isi textField :"+data);
				
				//tambahkan isinya kedalam combo
				tambahIsiCombo(data);
				
				//kosongkon textField
				tfMahasiswa.setText("");
				tfMahasiswa.requestFocus();
			}
		}
		
		//pasang event handler di button dan textField
		TambahMahasiswaListener tml = new TambahMahasiswaListener();
		bTambah.addActionListener(tml);
		tfMahasiswa.addActionListener(tml);
		
		//event handler untuk combo
		class PilihanComboListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JComboBox cb = (JComboBox) e.getSource();
				String pilihan = (String) cb.getSelectedItem();
				tfPilihan.setText(pilihan);
			}
		}
		
		//pasang listener di combo
		cmbMahasiswa.addActionListener(new PilihanComboListener());
    }
}

