/*
 * Description: 
 * Class used for reading the text file with explicit content.
 * The text file is loaded into an arraylist.
 * 
 */

package src.com.Abusive_text_detector;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.charset.Charset;
import java.io.IOException;
import java.io.PrintWriter;



public class ReadFile {

	String filename;
	File txtfile;
	Scanner scanner;
	ArrayList<String> word_array = new ArrrayList<String>();
	String templine;
	PrintWriter pwInput;
	String input;
	
	//Filename Constructor
	public ReadFile(String filename, ArrayList<String> word_array;
	{
		this.filename = filename;
		this.word_array = word_array;
	}
	
	//Opening the file
	public void openfile()
	{
		txtfile = new File(filename)
	}
	
	public void read
	{
		try
		{
			scanner = new Scanner(txtfile);
			
			while (scanner.hasNextLine())
			{
				templine = scanner.nextLine();
				word_array.add(templine);
			}
		}
		
		catch (FileNotFoundExpection e)
		{
			System.out.println(e.getMessage());
		}
		
		//Error - line 62 - Finally not recognised 
		Finally 
		{
			System.out.println((filename) + "=" + (word_array));
			scanner.close();
		}
		
	}
	
	public void closefile()
	{
		scanner.close();
	}
	
}
