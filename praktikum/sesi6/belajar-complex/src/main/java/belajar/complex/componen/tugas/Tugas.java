package belajar.complex.componen.tugas;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.*;

public class Tugas{
	private static final JTable tabel= new JTable();
	private static JComboBox cbHobi = new JComboBox();
	private static final List<Mahasiswa> dataMh = new ArrayList<Mahasiswa>();
	
	
	public static void main(String[] args){
		Mahasiswa m= new Mahasiswa();
		m.setNpm("001");
		m.setNama("sidratul");
		m.setHoby("bermain catur");
		tambahData(m);
		
		JLabel lNpm = new JLabel("NIM");
		JLabel lNama = new JLabel("Nama");
		JLabel lHobi = new JLabel("Hobi");
		
		final JTextField tfNpm = new JTextField(20);
		final JTextField tfNama = new JTextField(20);
		String hobi[] = {"ngoding","mancing","berenang","bermain catur","tidur","nonton"};
		for(int x=0;x<hobi.length;x++){
			cbHobi.addItem(hobi[x]);
		}
		
		JButton bSave = new JButton("save");
		JButton bReset = new JButton("reset");
		
		JPanel panel5 = new JPanel();
		panel5.add(new JLabel("Input Mahasiswa"));
		
		JPanel panel4 = new JPanel(new BorderLayout());
		panel4.add(panel5,BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel4.add(panel,BorderLayout.CENTER);
		
		GridBagLayout gBag = new GridBagLayout();
		panel.setLayout(gBag);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(5,5,5,5); //margin mulai dari atas
		gbc.fill = GridBagConstraints.BOTH;
		
		//panel.add(new JLabel("Input Mahasiswa"));
		
		gbc.gridwidth =1;
		gbc.gridheight =1;
		gbc.gridx =0;
		gbc.gridy =0;
		gBag.setConstraints(lNpm,gbc);
		panel.add(lNpm,gbc);
		
		gbc.gridx =0;
		gbc.gridy =1;
		gBag.setConstraints(lNama,gbc);
		panel.add(lNama,gbc);
		
		
		gbc.gridx =0;
		gbc.gridy =2;
		gBag.setConstraints(lHobi,gbc);
		panel.add(lHobi,gbc);
		
		gbc.gridwidth =3;
		gbc.gridx =1;
		gbc.gridy =0;
		gBag.setConstraints(tfNpm,gbc);
		panel.add(tfNpm,gbc);
		
		gbc.gridx =1;
		gbc.gridy =1;
		gBag.setConstraints(tfNama,gbc);
		panel.add(tfNama,gbc);
		
		gbc.gridwidth =2;
		gbc.gridx =1;
		gbc.gridy =2;
		gBag.setConstraints(cbHobi,gbc);
		panel.add(cbHobi,gbc);
		
		gbc.gridwidth =1;
		gbc.gridx =1;
		gbc.gridy =3;
		gBag.setConstraints(bSave,gbc);
		panel.add(bSave,gbc);
		
		gbc.gridx =2;
		gbc.gridy =3;
		gBag.setConstraints(bReset,gbc);
		panel.add(bReset,gbc);		
		
		//untuk tabel
		JScrollPane scrTabel = new JScrollPane(tabel);
		
		JPanel panel3 = new JPanel(new GridLayout(1,1));
		panel3.add(panel4);
		panel3.add(scrTabel);
		
		JFrame fr =new JFrame("Combo dan List");
		fr.getContentPane().add(panel3);
		fr.setSize(800,300);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setResizable(false);
		fr.setVisible(true);
		
		class TambahMahasiswa implements ActionListener{
			public void actionPerformed(ActionEvent e){
				String npm = tfNpm.getText();
				String nama = tfNama.getText();				
				String hobi = (String) cbHobi.getSelectedItem();
				
				Mahasiswa m = new Mahasiswa();
				m.setNpm(npm);
				m.setNama(nama);
				m.setHoby(hobi);
				tambahData(m); 
				
				tfNpm.setText("");
				tfNama.setText("");
				cbHobi.setSelectedItem("ngoding");
			}
		}
		
		bSave.addActionListener(new TambahMahasiswa());
		
		class resetButton implements ActionListener{
			public void actionPerformed(ActionEvent e){
				tfNpm.setText("");
				tfNama.setText("");
				cbHobi.setSelectedItem("ngoding");
			}
		}
		
		bReset.addActionListener(new resetButton());
	}
	
	public static void tambahData(Mahasiswa data){
		dataMh.add(data);
		TabelModelMahasiswa model = new TabelModelMahasiswa(dataMh);
		tabel.setModel(model);
	}
}