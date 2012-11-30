package belajar.event;

import javax.swing.*;
import java.awt.event.*;

public class EventDemo{
	
	public EventDemo(){
		JFrame fr = new JFrame("belajar Event");
		JLabel lNama = new JLabel("nama");
		final JTextField tfNama=new JTextField(21);
		JLabel lIsi = new JLabel("isi");
		JTextArea taIsi = new JTextArea(10,20);
		JButton bOke=new JButton("oke");
		JButton bBatal=new JButton("Batal");
		JPanel panel = new JPanel();
		
		panel.add(lNama);
		panel.add(tfNama);
		panel.add(lIsi);
		panel.add(taIsi);
		panel.add(bOke);
		panel.add(bBatal);
		
		fr.getContentPane().add(panel);
		fr.setSize(300,400);
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

    public static void main( String[] args ){
		new EventDemo();
    }
}
