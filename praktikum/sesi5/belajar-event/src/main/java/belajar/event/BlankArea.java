package belajar.event;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

public class BlankArea extends JLabel{
	Dimension miniSize = new Dimension(100,50);
	
	public BlankArea(Color color){
		setBackground(color);
		setOpaque(true);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public Dimension getMinimumSize(){
		return miniSize;
	}
	
	public Dimension getPreferredSize(){
		return miniSize;
	}
}