package belajar.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloSwing{
	public static void main(String args[]){
		JFrame fr = new JFrame();
		fr.setTitle(":: hallo GUI ::");
		
		JLabel lhallo = new JLabel("Hallo Swing");
		fr.getContentPane().add(lhallo);
		
		fr.setSize(300,300);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}