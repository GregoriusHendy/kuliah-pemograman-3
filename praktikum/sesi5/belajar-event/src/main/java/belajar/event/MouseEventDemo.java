package belajar.event;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventDemo extends JPanel implements MouseListener{
	BlankArea blankArea;
	JTextArea ta;
	
	static final String NEWLINE = System.getProperty("line.separator");
	
	public static void main(String[] args){
		/*use an appropriate look and feel*/
		try{
			/*
				UImanager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				UImanager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			*/
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		}catch(UnsupportedLookAndFeelException ex){
			ex.printStackTrace();
		}catch(IllegalAccessException ex){
			ex.printStackTrace();
		}catch(InstantiationException ex){
			ex.printStackTrace();
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}
		/*turn off metal's use of bold fonts*/
		UIManager.put("swing.boldMetal",Boolean.FALSE);
		/*
			Schedule a job for the event dispatch thread
			creating and showing this application's GUI
		*/
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void  run(){
				createAndShowGUI();
			}
		});
	}

	/*
		create the GUI and show it. for thread safety,
		this method should be invoke from the event dispacth thread
	*/
	private static void createAndShowGUI(){
		//create and setup the window
		JFrame fr = new JFrame("Mouse Event");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create and setup the content pane
		JComponent newContentPane = new MouseEventDemo();
		newContentPane.setOpaque(true);
		fr.setContentPane(newContentPane);
		
		fr.pack();
		fr.setVisible(true);
	}

	public MouseEventDemo(){
		super(new GridLayout(0,1));
		blankArea = new BlankArea(Color.YELLOW);
		add(blankArea);
		ta= new JTextArea();
		ta.setEditable(false);
		JScrollPane scrollPane= new JScrollPane(ta);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(200,75));
		add(scrollPane);
		
		//register for mouse event on blankArea and the panel
		blankArea.addMouseListener(this);
		addMouseListener(this);
		setPreferredSize(new Dimension(450,450));
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	}	

	void eventOutput(String penjelasan, MouseEvent e){
		ta.append(penjelasan+"detected on "+e.getComponent().getClass().getName()+"."+NEWLINE);
		ta.setCaretPosition(ta.getDocument().getLength());
	}

	public void mousePressed(MouseEvent e){
		eventOutput("Mouse Pressed(# of Click:)"+e.getClickCount()+")",e);
	}

	public void mouseReleased(MouseEvent e){
		eventOutput("Mouse releassed(# of Click:)"+e.getClickCount()+")",e);
	}

	public void mouseEntered(MouseEvent e){
		eventOutput("Mouse entered",e);
	}

	public void mouseExited(MouseEvent e){
		eventOutput("Mouse exited",e);
	}

	public void mouseClicked(MouseEvent e){
		eventOutput("Mouse Clicked(# of Click:)"+e.getClickCount()+")",e);
	}
}