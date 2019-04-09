package explicit;

import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JFrame implements ActionListener
{
	JButton showexplicit, button, choosefile, checkfor, add, remove;
	private ArrayList<String> explicit = new ArrayList<String>();
	
	JFileChooser choose;
	JTextArea postpart, badpart, result;
	JScrollPane postmove, badmove;
	JPanel panel_l;
	
	private String[] words;
	private boolean exist = false;
	
	//Constructor here
	Display(String title)
	{
		super(title);
		setSize(800, 550);
		setResizable(false);
		setLayout(new FlowLayout());
		button = new JButton("Load Explicit File");
		showexplicit = new JButton("Show Explcit Content");
		choosefile = new JButton("Choose File to Scan");
		checkfor = new JButton("Check for Explicit Content");
		add = new JButton ("Add Word");
		remove = new JButton ("Remove Word");
		
		choose = new JFileChooser();
		postpart = new JTextArea(20, 25);
		postmove = new JScrollPane(postpart);
		badpart = new JTextArea(20, 20);
		badmove = new JScrollPane(badpart);
		result = new JTextArea();
		panel_l = new JPanel();
		
		//.setEnabled(false);
		//.setDisabledTextColor(Color.BLACK);
		postpart.setEnabled(false);
		postpart.setDisabledTextColor(Color.BLACK);
		badpart.setEnabled(false);
		badpart.setDisabledTextColor(Color.BLACK);
		result.setEnabled(false);
		result.setDisabledTextColor(Color.BLACK);

		//.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		badmove.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		postmove.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//Buttons
		add(showexplicit);
		add(choosefile);
		add(checkfor);
		add(add);
		add(remove);
		add(postmove);
		add(badmove);
		add(result);
	
		//.addActionListener(this);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ReadFile read = new ReadFile("abusive.txt", explicit);
		read.openfile();
		read.read();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	// Add content of array list to text
	
	// Add new explicit content to array list
	
	
	// Check if word is there already or not
	// Error checking: 1. If it does'nt already contain word write it in
	// 2. Do'nt allow to add blank "_"
	
	
	// Refresh word list
	// Add list to text
	
	//select file to be scanned
	//read to string
	//display
	
	
	//make sure file is loaded
	
	//display the results
	//
	
	
	
}
