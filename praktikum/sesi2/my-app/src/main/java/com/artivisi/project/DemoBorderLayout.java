package com.artivisi.project;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.*;

public class DemoBorderLayout{
	public static void main(String[] args){
		
		JFrame fr = new JFrame("Belajar Layout");
		
		//beberapa buttton untuk demo
		JButton btn1= new JButton("Tombol 1");
		JButton btn2= new JButton("#2");
		JButton btn3= new JButton("Tombil tiga");
		JButton btn4= new JButton("Tombol 4:panjang");
		JButton btn5= new JButton("btn 5");
		JButton btn6= new JButton("no. 5");
		
		Container kontainer = fr.getContentPane();
		kontainer.setLayout(new BorderLayout(3,2));
		kontainer.add(btn1,BorderLayout.NORTH);
		kontainer.add(btn2,BorderLayout.SOUTH);
		kontainer.add(btn3,BorderLayout.WEST);
		kontainer.add(btn4,BorderLayout.EAST);
		kontainer.add(btn5,BorderLayout.CENTER);
		
		fr.setSize(800,400);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
		
	}
}