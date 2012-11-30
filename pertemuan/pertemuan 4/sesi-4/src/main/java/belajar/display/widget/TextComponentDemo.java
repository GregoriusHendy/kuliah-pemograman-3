package belajar.display.widget;

import javax.swing.*;
import java.awt.*;

public class TextComponentDemo{
	public TextComponentDemo(){
		JFrame frame = new JFrame("BElajar Widget");
		JLabel lNama =new  JLabel("Nama");
		JLabel lAlamat =new  JLabel("Alamat");
		JTextField tfNama =new JTextField(20);
		JTextArea taAlamat =new JTextArea(10,20); 
		
		JPanel pGrid = new JPanel(new GridLayout(2,2));
		JPanel pBorder = new JPanel(new BorderLayout());
		JPanel pFlow = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		
		pGrid.add(lNama);
		pGrid.add(tfNama);
		pGrid.add(lAlamat);
		pGrid.add(taAlamat);
		pFlow.add(pGrid);
		
		
		
		pBorder.add(pFlow,"Center");
		frame.getContentPane().add(pBorder);
		
		frame.setLocationRelativeTo(null);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		new TextComponentDemo();
	}
}