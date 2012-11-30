package belajar.swing.layout;

import javax.swing.*;
import java.awt.FlowLayout;

public class DemoFlowLayout{

	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	
	public static void main(String[] xx){
		JFrame fr = new JFrame();
		
		btn1 = new JButton("tombol 1");
		btn1 = new JButton("tombol 1");
		btn1 = new JButton("tombol 1");
		btn1 = new JButton("tombol 1");
		btn1 = new JButton("tombol 1");
		btn1 = new JButton("tombol 1");
		
		JTextField tfNama = new JTextField("Nama");
		JTextField tfEmail = new JTextField("E-mail");
		JPasswordField pfPass = new JPasswordField("Password");
		
		fr.setSize(500,500);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	}
}