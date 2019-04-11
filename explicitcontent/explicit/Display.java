package explicit;

import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.commons.io.FileUtils;

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
		add = new JButton ("Add Word");
		remove = new JButton ("Remove Word");
		checkfor = new JButton("Check for Explicit Content");
		
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
		choosefile.addActionListener(this);
		checkfor.addActionListener(this);
		showexplicit.addActionListener(this);
		add.addActionListener(this);
		remove.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ReadFile read = new ReadFile("abusive.txt", explicit);
		read.openfile();
		read.read();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		if (e.getSource() == choosefile)
		{
			//Choose file and scan it in to be read for explicit content
			choose.setCurrentDirectory(new File(System.getProperty("user.dir")));
			int result = choose.showOpenDialog(this);
			
			if (result == JFileChooser.APPROVE_OPTION)
			{
				File user_file = choose.getSelectedFile();
				try
				{
					//String - read first!
					String data = FileUtils.readFileToString(user_file, Charset.forName("utf-8"));
					System.out.println(data);
					postpart.append(data);
					words = data.split("\\s");
					for (String s : words)
					{
						System.out.println(s);
					}
				}
			
			catch(IOException e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
		//Check for
		if (e.getSource() == checkfor)
		{
			//Check if file is loaded
			if(words == null)
			{
				JOptionPane.showMessageDialoge(null,  "Must select file to scan!", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				Engine check = new Engine(explicit, words);
				check.checkwords();
				
				//Scoring posts on how explicit they are
				//Over 50 is very explicit
				//Under is moderately explicit
				if (check.getScore()>= 100 || check.getScore()>= 60)
				{
					result.setText("High Explicit Rating " + "of: " + (check.getScore()) +  "\n" + "Explicit words: " + (check.getCount()) + "Words shouted: " + (check.getUpper()));
				}
				
				else if (check.getScore()< 60 && check.getScore()> 11)
				{
					result.setText("Moderate Explicit Rating " + "of: " +  (check.getScore()) + "\n" + "Explicit words: " + (check.getCount()) + "Words shouted: " + (check.getUpper()));
				}
				
				else if (check.getScore()< 11)
				{
					result.setText("Low Explicit Rating " + "of: " +  (check.getScore()) + "\n" + "Explicit words: " + (check.getCount()) + "Words shouted: " + (check.getUpper()));
				}
				
			}
			
		}
		
		//Show Explixit Content
		if (e.getSource() == showexplicit)
		{
			badpart.setText("");
			for(String s : explicit)
			{
				badpart.append(s + System.getProperty("line.separator"));
			}
		}
		
		//Add word to list
		if (e.getSource() == add)
		{
			String input = JOptionPane.showInputDialog(null, "Enter word to be added: ");
			
			//Error check - Check if list already contains word entered
			if (explicit.contains(input))
			{
				exist = true;
				JOptionPane.showMessageDialog(null, "Word entered is already considered explicit", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			//Error check - Do'nt allow user to enter nothing and submit to list
			if (input != null)
			{
				if (exist != true)
				{
					explicit.add(input);
					Replace replace = new Replace(explicit);
					replace.openfile();
					replace.deletefile();
					replace.writefile();
				}
			}
			
			System.out.println(explicit);
			
			badpart.setText("");
			//Refresh
			
			for(String s : explicit)
			{
				badpart.append(s + System.getProperty("line.separator"));
			}
		}
		
		//Remove word from list
		if (e.getSource() == remove)
		{
			String input = JOptionPane.showInputDialog(null, "Enter word to be removed: ");
			
			if(input != null)
			{
				if (explicit.contains(input))
				{
					explicit.remove(input);
					Replace replace = new Replace(explicit);
					replace.openfile();
					replace.deletefile();
					replace.writefile();
				}
				
				else
				{
					JOptionPane.showMessageDialog(null,  "Word not considered explicit ", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			badpart.setText("");
			//Refresh
			
			for (String s : explicit)
			{
				badpart.append(s + System.getProperty("line.seperator"));
			}
		}
		
	}
	
	public void setWords(String[] words)
	{
		this.words  = words;
	}
	
	public void setExplicit()
	{
		this.explicit = explicit;
	}
	
	public String[] getWords()
	{
		return words;
	}
	
	public void setExplicit(ArrayList<String>explicit)
	{
		this.explicit = explicit;
	}
//Last
}
