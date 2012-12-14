package source.suplier;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class TabelSuplier{
	private JTable tabel = new JTable();
	private JTextField tfFilter;
	private JButton bFilter;
	private JButton bHapus;
		
	private JPanel panelUtama;
	private JPanel panelFilter;	
	private JPanel panelButton;
	private JScrollPane srcTabel;
	public TabelSuplier(){
		tfFilter   = new JTextField(30);
		bFilter    = new JButton("filter");
		bHapus     = new JButton("hapus");
		
		panelUtama = new JPanel(new BorderLayout());
		panelFilter= new JPanel();  
		panelButton= new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		//data tabel
		setDataTabel();
		srcTabel = new JScrollPane(tabel);
		
		panelUtama.add(panelFilter,"North");
		panelUtama.add(srcTabel,"Center");
		panelUtama.add(panelButton,"South");
		
		//filter
		panelFilter.add(new JLabel("filter : "));
		panelFilter.add(tfFilter);
		panelFilter.add(bFilter);
		
		//untuk button
		panelButton.add(bHapus);
	}
	
	public void setDataTabel(){
		List<Suplier> dataSuplier = new ArrayList<Suplier>();
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
	}
	
	public JPanel getPanel(){
		return panelUtama;
	}
	
	public TabelSuplier getObject(){
		return this;
	}
}
