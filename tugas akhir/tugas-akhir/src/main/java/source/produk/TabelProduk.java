package source.produk;

import source.produk.input.InputProduk;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.event.*;
import java.awt.event.*;

public class TabelProduk{
	private static JTable tabel = new JTable();
	private JTextField tfFilter;
	private JButton bFilter;
	private JButton bHapus;
	
	private JPanel panelLengkap;
	private final JPanel panelInput;
	private JPanel panelUtama;
	private JPanel panelFilter;
	private JPanel panelTabel;
	private JPanel panelButton;
	private static JScrollPane srcTabel;
	
	public TabelProduk(){
		tfFilter = new JTextField(30);
		bFilter = new JButton("filter");
		bHapus= new JButton("hapus");
		
		panelLengkap = new JPanel();
		panelInput = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		panelUtama=new JPanel(new BorderLayout());
		panelFilter = new JPanel();
		panelTabel = new JPanel();
		panelButton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		//masukkan ke panel lengkap
		panelLengkap.add(panelUtama);
		panelLengkap.add(panelInput);
		
		//panel input
		InputProduk inProduk = new InputProduk(this);
		panelInput.add(inProduk.getPanel());				
		
		//panel utama
		panelUtama.add(panelFilter,"North");
		panelUtama.add(panelTabel,"Center");
		panelUtama.add(panelButton,"South");
		
		//filter
		panelFilter.add(new JLabel("filter : "));
		panelFilter.add(tfFilter);
		panelFilter.add(bFilter);
		
		//untuk button
		panelButton.add(bHapus);
		
		
		setDataTabel();
		srcTabel = new JScrollPane(tabel);
		panelTabel.add(srcTabel);
	}
	
	public static final void setDataTabel(){
		List<Produk> dataProduk = new ArrayList<Produk>();
		//ambil data dari database untuk tabel
		try{
			Connection koneksi= DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
			String qry = "SELECT * FROM produk,suplier,jenis WHERE produk.id_jenis = jenis.id_jenis AND produk.id_suplier = suplier.id_suplier";
			Statement stm =koneksi.createStatement();
			ResultSet rs = stm.executeQuery(qry);
			while(rs.next()){
				Produk p = new Produk();
				p.setIdProduk(rs.getInt("id_produk"));
				p.setNamaProduk(rs.getString("nama_produk"));
				p.setJenis(rs.getString("nama_jenis"));
				p.setHarga(rs.getInt("harga"));
				p.setStok(rs.getInt("stok"));
				p.setNamaSuplier(rs.getString("nama_suplier"));
				dataProduk.add(p);
			}
		}catch(Exception err){
			err.printStackTrace();
		}
		TableModelProduk model = new TableModelProduk(dataProduk);
		tabel.setModel(model);
	}
	
	public JPanel getPanel(){
		return panelLengkap;
	}
}