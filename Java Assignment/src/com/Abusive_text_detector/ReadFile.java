/*
 * Description: 
 * Class used for reading the text file with explicit content.
 * The text file is loaded into an arraylist.
 * 
 */

package src.com.Abusive_text_detector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

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

	
}
