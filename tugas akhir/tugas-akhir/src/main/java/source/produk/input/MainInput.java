package source.produk.input;

import source.produk.TabelProduk;
import source.produk.input.baru.InputProduk;
import source.produk.input.masuk.InputMasuk;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainInput{
	private JButton bBaru;
	private JButton bMasuk;
	private JButton bKeluar;
	
	private JPanel panelUtama;	
	private JPanel panelButton;	
	
	public MainInput(TabelProduk tp){	
		
		panelUtama = new JPanel(new BorderLayout());
		panelButton = new JPanel();
		
		//button
		bBaru = new JButton("input produk");
		bMasuk =  new JButton("input pemasukkan");
		bKeluar =  new JButton("input pengeluaran");
		
		panelButton.add(bBaru);
		panelButton.add(bMasuk);
		panelButton.add(bKeluar);
		panelUtama.add(panelButton,"North");
		
		// InputMasuk im = new InputMasuk(tp);
		// panelUtama.add(im.getPanel(),"Center");
		
		InputProduk ip = new InputProduk(tp);
		panelUtama.add(ip.getPanel(),"Center");
		
	}
	
	public JPanel getPanel(){
		return panelUtama;
	}
}