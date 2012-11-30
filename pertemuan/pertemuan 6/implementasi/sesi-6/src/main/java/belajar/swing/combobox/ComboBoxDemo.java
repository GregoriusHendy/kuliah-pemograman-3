package belajar.swing.combobox;

import javax.swing.*;
import java.util.*;

public class ComboBoxDemo{
    public static void main( String[] args ){
		JFrame fr = new JFrame("belajar combo box");
		JPanel panel= new JPanel();
        JComboBox combo= new JComboBox();
		
		List<String> mahasiswa = new ArratList<String>();
		mahasiswa.add("sidratul");
		
		JLabel lnama = new JLabel("Nama");
		panel.add(lnama);
		
		combo.addItem("tidur");
		combo.addItem("makan");
		combo.addItem("belajar");
		
		panel.add(combo);
		
		fr.getContentPane().add(panel);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(500,400);
		fr.setLocationRelativeTo(null);
    }
}
