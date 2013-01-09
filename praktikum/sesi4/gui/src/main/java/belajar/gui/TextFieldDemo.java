package belajar.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.GroupLayout.*;

public class TextFieldDemo extends JFrame implements DocumentListener{
	private JTextField tfEntry;
	private JLabel lLabel1;
	private JLabel lStatus;
	private JScrollPane spScroll;
	private JTextArea taKonten;
	
	final static Color HILIT_COLOR = Color.LIGHT_GRAY;
	final static Color ERROR_COLOR = Color.PINK;
	final static String CANCEL_ACTION = "cancel-Search";
	
	final Color entryBg;
	final Highlighter hilit;
	final Highlighter.HighlightPainter painter;
	
	public TextFieldDemo(){
		initComponents();
		
		InputStream in = getClass().getResourceAsStream("content.txt");
		try{
			taKonten.read(new InputStreamReader(in), null);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		hilit = new DefaultHighlighter();
		painter = new DefaultHighlighter.DefaultHighlightPainter(HILIT_COLOR);
		taKonten.setHighlighter(hilit);
		
		entryBg = tfEntry.getBackground();
		tfEntry.getDocument().addDocumentListener(this);
		
		InputMap im = tfEntry.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = tfEntry.getActionMap();
		im.put(KeyStroke.getKeyStroke("ESCAPE"), CANCEL_ACTION);
		am.put(CANCEL_ACTION, new CancelAction());
	}
	
	private void initComponents(){
		tfEntry = new JTextField();
		taKonten = new JTextArea();
		lLabel1 = new JLabel();
		lStatus = new JLabel();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("TextFieldDemo");
		
		taKonten.setColumns(20);
		taKonten.setLineWrap(true);
		taKonten.setRows(5);
		taKonten.setWrapStyleWord(true);
		taKonten.setEditable(false);
		spScroll = new JScrollPane(taKonten);
		
		lLabel1.setText("Search : ");
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		//create a parallel group for horizontal axis
		ParallelGroup hGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		
		//create a sequential and parallel groups
		SequentialGroup h1 = layout.createSequentialGroup();
		ParallelGroup h2 = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);
		
		//ad container gap to sequential group h1
		h1.addContainerGap();
		
		//add a scroll pane and label to parallel group h2
		h2.addComponent(spScroll, GroupLayout.Alignment.LEADING,GroupLayout.DEFAULT_SIZE,450,Short.MAX_VALUE);
		h2.addComponent(lStatus, GroupLayout.Alignment.LEADING,GroupLayout.DEFAULT_SIZE,450,Short.MAX_VALUE);
		
		//create sequential group h3
		SequentialGroup h3 = layout.createSequentialGroup();
		h3.addComponent(lLabel1);
		h3.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
		h3.addComponent(tfEntry,GroupLayout.DEFAULT_SIZE,321,Short.MAX_VALUE);
		
		//add the group h3 to h2
		h2.addGroup(h3);
		//menambahkan group h2 ke h1
		h1.addGroup(h1);
		
		h1.addContainerGap();
		
		//add the group h1 to the group
		hGroup.addGroup(GroupLayout.Alignment.TRAILING, h1);
		//create the horizontal group
		layout.setHorizontalGroup(hGroup);
		
		//create a parallel group for the vertical axis
		ParallelGroup vGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		//create a sequential group v1
		SequentialGroup v1 = layout.createSequentialGroup();
		//add a container gap to the sequential group v1
		v1.addContainerGap();
		
		//Crate a parallel group v2
		ParallelGroup v2 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
		v2.addComponent(lLabel1);
		v2.addComponent(tfEntry,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
		
		//add the group v2 to the group v1
		v1.addGroup(v2);
		v1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
		v1.addComponent(spScroll, GroupLayout.DEFAULT_SIZE, 233,Short.MAX_VALUE);
		
		v1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
		v1.addComponent(lStatus);
		v1.addContainerGap();
		
		//add the group v1 to the group vGroup
		vGroup.addGroup(v1);
		//Create the tactical group
		layout.setVerticalGroup(vGroup);
		pack();
	}
	
	public void search(){
		hilit.removeAllHighlights();
		
		String s = tfEntry.getText();
		if(s.length() <=0){
			message("Nothing to Search");
			return;
		}
		
		String content = taKonten.getText();
		int index = content.indexOf(s,0);
		if(index >= 0){
			try{
				int end = index + s.length();
				hilit.addHighlight(index, end, painter);
				taKonten.setCaretPosition(end);
				tfEntry.setBackground(entryBg);
				message("'"+s+"' found. Press ESC to end Search");	
			}catch(BadLocationException e){
				e.printStackTrace();
			}
		}else{
			tfEntry.setBackground(ERROR_COLOR);
			message("'"+s+"' not found. Press ESC to start a new seach");
		}
	}
	
	void message(String msg){
		lStatus.setText(msg);
	}
	
	public void insertUpdate(DocumentEvent ev){
		search();
	}
	
	public void removeUpdate(DocumentEvent ev){
		search();
	}
	
	public void changedUpdate(DocumentEvent ev){
	}
	
	class CancelAction extends AbstractAction{
		public void actionPerformed(ActionEvent ev){
			hilit.removeAllHighlights();
			tfEntry.setText("");
			tfEntry.setBackground(entryBg);
		}
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				//turn off metal's use of bold font
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				new TextFieldDemo().setVisible(true);
			}
		});
	}
}