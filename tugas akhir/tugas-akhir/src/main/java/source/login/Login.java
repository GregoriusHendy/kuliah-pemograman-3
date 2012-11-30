package source.login;

import javax.swing.*;
import java.awt.*;

public class Login{
	private JFrame fr;
	private JTextField tfUsername;
	private JPasswordField pfPass;
	private JButton bLogin;
	private JPanel panel;
	
	public Login(){
		fr = new JFrame("login");
		
		tfUsername = new JTextField(20);
		pfPass = new JPasswordField(20);
		bLogin = new JButton("login");
		panel = new JPanel();
		
		GridBagLayout gBag = new GridBagLayout();
		panel.setLayout(gBag);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,10,5,10);
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.gridy =0;
		gbc.gridx =0;
		panel.add(new JLabel("username"),gbc);
		
		gbc.gridy =1;
		panel.add(new JLabel("password"),gbc);
		
		gbc.gridwidth=2;
		gbc.gridy =0;
		gbc.gridx =1;
		gBag.setConstraints(tfUsername,gbc);
		panel.add(tfUsername,gbc);
		
		gbc.gridy =1;
		gbc.gridx =1;
		gBag.setConstraints(pfPass,gbc);
		panel.add(pfPass,gbc);
		
		gbc.gridwidth=1;
		gbc.gridy =2;
		gbc.gridx =1;
		gBag.setConstraints(bLogin,gbc);
		panel.add(bLogin,gbc);
		
		fr.getContentPane().add(panel);
		fr.setLocationRelativeTo(null);
		fr.setSize(500,300);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public void setTampil(boolean tampil){
		fr.setVisible(tampil);
	}
	
}