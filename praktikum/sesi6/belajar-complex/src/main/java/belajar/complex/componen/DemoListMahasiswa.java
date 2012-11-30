package belajar.complex.componen;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class DemoListMahasiswa{
	private static JList listMahasiswa = new JList();
	private static final List<Mahasiswa> daftarMh = new ArrayList<Mahasiswa>();
	
	public static void isiCombo(){
		//data dimasukkan kekelas model
		DefaultComboBoxModel model = new DefaultComboBoxModel(daftarMh.toArray());
		
		//pasang model di combo
		listMahasiswa.setModel(model);
	}
	
	public static void tambahIsiList(Mahasiswa data){
		daftarMh.add(data);
		isiCombo();
	}
	
	public static void main(String[] xx){
		Mahasiswa m = new Mahasiswa();
		m.setNpm("123");
		m.setNama("endy");
		tambahIsiList(m);
		
		final JTextField tfNpm= new JTextField(5);
		final JTextField tfNama= new JTextField(20);
		JButton bTambah = new JButton("tambah");
		
		JPanel panel= new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(new JLabel("NPM : "));
		panel.add(tfNpm);
		panel.add(new JLabel("Nama : "));
		panel.add(tfNama);
		panel.add(bTambah);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.add(listMahasiswa);
		
		JPanel panel3 = new JPanel();
		panel3.add(new JLabel("Pilihan : "));
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
		
		class TambahMahasiswaListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				String npm = tfNpm.getText();
				String nama = tfNama.getText();
				System.out.println("npm :"+npm);
				System.out.println("nama :"+nama);
				
				//tambah isinya kedalam combo
				Mahasiswa x = new Mahasiswa();
				x.setNpm(npm);
				x.setNama(nama);
				tambahIsiList(x);
				
				tfNpm.setText("");
				tfNama.setText("");
				tfNpm.requestFocus();
			}
		}
		TambahMahasiswaListener tml = new TambahMahasiswaListener();
		bTambah.addActionListener(tml);
		
		class PilihanListListener implements ListSelectionListener{
			public void valueChanged(ListSelectionEvent e){
				JList l= (JList) e.getSource();
				int indexPilihan =l.getSelectedIndex();
				System.out.println("pilihan : "+indexPilihan);
				
				if(indexPilihan <0){
					return;
				}
				
				Mahasiswa x = daftarMh.get(indexPilihan);
				tfPilihan.setText(x.getNpm()+"-"+x.getNama());
				
			}
		}
		listMahasiswa.addListSelectionListener(new PilihanListListener());
	}
}