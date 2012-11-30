package com.artivisi.project;

import java.awt.GridLayout;
import java.awt.Container;
import javax.swing.*;

public class DemoGridLayout{
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
		kontainer.setLayout(new GridLayout(3,2));
		kontainer.add(btn1);
		kontainer.add(btn2);
		kontainer.add(btn3);
		kontainer.add(btn4);
		kontainer.add(btn5);
		kontainer.add(btn6);
		
		fr.setSize(800,400);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
		
		
	}
}