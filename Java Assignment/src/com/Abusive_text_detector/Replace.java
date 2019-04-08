/*
 * Description: Used for adding / removing words from the list * of Explicit words.
 * It rewrites the file using the FileUtils.writeStringToFile 
 * method from the Apache Commons library.
 */

package com.Abusive_text_detector;

import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.commons.io.FileUtils;

public class Replace {
	
	File txtfile;
	final String newline = System.getProperty("line.separator");
	ArrayList<String> explicit = new ArrayList<String>();
	
	//Constructor
	public Replace(ArrayList<String> explicit)
	{
		this.explicit = explicit;
	}
	
	public void openfile()
	{
		txtfile = new File("abusive.txt");
	}
	
	public void deletefile()
	{
		txtfile.delete();
	}

	public void writefile()
	{
		try
		{
			for (String s : explicit)
			{
				//Method from Apache Commons Library
				FileUtils.writeStringToFile(txtfile, (s) + (newline), Charset.forName("utf-8"), true);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
