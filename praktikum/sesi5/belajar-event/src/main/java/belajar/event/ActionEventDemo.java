package belajar.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JButton;

public class ActionEventDemo{
	public static void main(String[] args){
		JFrame fr = new JFrame("button event");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JButton b1 = new JButton("select me");
		final JButton b2 = new JButton("No select me");
		final Random random= new Random();
		
		ActionListener aListener = new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				JButton b = (JButton) ae.getSource();
				int red = random.nextInt(225);
				int green = random.nextInt(225);
				int blue = random.nextInt(225);
				b.setBackground(new Color(red,green,blue));
			}
		};
		
		PropertyChangeListener pcListener = new PropertyChangeListener(){
			public void propertyChange(PropertyChangeEvent pce){
				String property = pce.getPropertyName();
				if("background".equals(property)){
					b2.setBackground((Color) pce.getNewValue());
				}
			}
		};
		
		b1.addActionListener(aListener);
		b1.addPropertyChangeListener(pcListener);
		b2.addActionListener(aListener);
		
		fr.add(b1,BorderLayout.NORTH);
		fr.add(b2,BorderLayout.SOUTH);
		fr.setSize(300,100);
		fr.setVisible(true);
	}
}