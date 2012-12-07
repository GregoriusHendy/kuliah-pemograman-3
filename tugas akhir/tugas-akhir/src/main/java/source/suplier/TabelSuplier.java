package source.suplier;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class TabelSuplier{
	private JTable tabel = new JTable();
	private List<Suplier> dataSuplier = new ArrayList<Suplier>();
	private JPanel panel= new JPanel();
	
	public TabelSuplier(){
		try{
			Connection koneksi= DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
			String qry = "SELECT * FROM suplier";
			Statement stm =koneksi.createStatement();
			ResultSet rs = stm.executeQuery(qry);
			while(rs.next()){
				Suplier s = new Suplier();
				s.setIdSuplier(rs.getInt("id_suplier"));
				s.setNamaSuplier(rs.getString("nama_suplier"));
				s.setEmail(rs.getString("email"));
				s.setTelpon(rs.getString("telpon"));
				s.setKota(rs.getString("kota"));
				s.setAlamat(rs.getString("alamat"));
				dataSuplier.add(s);
			}
		}catch(Exception err){
			err.printStackTrace();
		}
		
		TableModelSuplier model = new TableModelSuplier(dataSuplier);
		tabel.setModel(model);
		JScrollPane srcTabel = new JScrollPane(tabel);
		panel.add(srcTabel);
	}
	
	public JPanel getPanel(){
		return panel;
	}
}
