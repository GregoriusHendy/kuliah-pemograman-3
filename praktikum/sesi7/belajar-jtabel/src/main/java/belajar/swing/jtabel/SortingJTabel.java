package belajar.swing.jtabel;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import javax.swing.event.*;
import java.util.List;
import java.util.ArrayList;

public class SortingJTabel{
	private static final JTable tabel = new JTable();
	private static final List<Produk> dataProduk = contohData();
	
	public static void main(String[] args){
		JPanel panel = new JPanel(new BorderLayout());
		
		JPanel panel2= new JPanel();
		JTextField tfFilter = new JTextField(30);
		panel2.add(new Label("Filter"));
		panel2.add(tfFilter);
		panel.add(panel2,BorderLayout.NORTH);
		
		JButton bFilter = new JButton("Filter");
		panel.add(bFilter,BorderLayout.SOUTH);
		
		TabelModelProduk tModel = new TabelModelProduk(dataProduk);
		tabel.setModel(tModel);
		
		JScrollPane scrTabel = new JScrollPane(tabel);
		panel.add(scrTabel,BorderLayout.CENTER);
		
		
		JFrame fr = new JFrame("Sorting JTabel");
		fr.getContentPane().add(panel);
		fr.setSize(400,300);
		fr.setResizable(false);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	}
	
	private static List<Produk> contohData(){
		List<Produk> dataP = new ArrayList<Produk>();
		
		Produk p1 = new Produk();
		p1.setSimbol("AMZN");
		p1.setNama("Amazon");
		p1.setHarga(4128);
		dataP.add(p1);
		
		Produk p2 = new Produk();
		p2.setSimbol("EBAY");
		p2.setNama("eBay");
		p2.setHarga(1157);
		dataP.add(p2);
		
		Produk p3 = new Produk();
		p3.setSimbol("GOOG");
		p3.setNama("Google");
		p3.setHarga(38833);
		dataP.add(p3);
		
		Produk p4 = new Produk();
		p4.setSimbol("AA");
		p4.setNama("aaaa");
		p4.setHarga(1231);
		dataP.add(p4);
		
		Produk p5 = new Produk();
		p5.setSimbol("BB");
		p5.setNama("bbbbbbb");
		p5.setHarga(1231);
		dataP.add(p5);
		
		Produk p6 = new Produk();
		p6.setSimbol("CC");
		p6.setNama("cccc");
		p6.setHarga(1231);
		dataP.add(p6);
		
		return dataP;
	}
}