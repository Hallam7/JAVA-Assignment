/*
 * Description: Engine class used for scanning the user file.
 * Contains methods for checking for explicit content.
 * Checks for and scores the results.
 */

package com.Abusive_text_detector;

import java.util.ArrayList;

public class Engine {
	
	ArrayList<String> word_array = new ArrayList<String>();
	ArrayList<String> word_cap = new ArrayList<String>();
	String[] postword;
	
	private int count = 0;
	private int post_size = 0;
	private int upper = 0;
	private int multiply = 0;
	private int score = 0;
	final String newline = System.getProperty("line.separator");
	
	public Engine(ArrayList<String> word_array, String[] postword)
	{
		this.word_array = word_array;
		this.postword = postword;
	}
	
	public void checkwords()
	{
		//Checking for Explicit words
		for (String s : postword)
		{
			if (word_array.contains(s))
			{ 
				count++;
				System.out.println("Found");
			}
		}
		
		word_cap.clear();
		word_cap = (ArrayList<String>) word_array.clone();
		word_cap.replaceAll(String::toUpperCase);
		System.out.println(word_cap);
		
		//Check against Upper Case
		for (String s : postword)
		{
			if(word_cap.contains(s));
			{
				count++;
				System.out.println("Found in Caps");
			}
		}
		
		//Check Lenght of 
		post_size = postword.length;
		
		System.out.println("Offensive words found: " + (count) + "/n" + "post_size = " + (post_size));
		
		//Check the String for Caps
		for (String s: postword)
		{
			if (s.equals(s.toUpperCase()))
			{
				if(s.length() != 1)
				{
					if (!s.contentEquals(""))
					{
						if (!Character.isDigit(s.charAt(0)))
						{
							upper++;
							System.out.println("Uppercase marked: " + s);
						}
					}
				}	
			}
		}
	//need record score
		//display words in caps
	
    //set returns and public
		// 
	  
		
		
		
	}

}
