package com.artivisi.project;

import java.awt.FlowLayout;
import javax.swing.*;

public class DemoFlowLayout{
	public static void main(String[] args){
		//beberapa buttton untuk demo
		JButton btn1= new JButton("Tombol 1");
		JButton btn2= new JButton("#2");
		JButton btn3= new JButton("Tombil tiga");
		JButton btn4= new JButton("Tombol 4:panjang");
		JButton btn5= new JButton("btn 5");
		JButton btn6= new JButton("no. 5");
		
		JPanel panel= new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		
		JFrame fr = new JFrame("Belajar Layout");
		fr.getContentPane().add(panel);
		fr.setSize(800,200);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
		
		
	}
}