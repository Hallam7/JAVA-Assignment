/*
 * Description: 
 * Engine class used for scanning the user file.
 * Contains methods for checking for explicit content.
 * Checks for and rates results on how explicit they are.
 */

package explicit;

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
			System.out.println(s);
			
			if(word_cap.contains(s))
			{
				count++;
				System.out.println("Found Caps");
			}
		}
		
		//Check Lenght of 
		post_size = postword.length;
		
		System.out.println("Offensive words found: " + (count) + "\n" + "post_size = " + (post_size));
		
		//Check the String for Caps
		for (String s: postword)
		{
			if (s.equals(s.toUpperCase()))
			{
				if(s.length() != 1)
				{
					if (!s.equals(""))
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
		System.out.println("Words in all Caps: " + (upper));
		
		multiply = count * 10;
		score = multiply;
		
		if (upper == post_size)
		{
			score = score + 100;
		}
		
		else if (upper >= 1)
		{
			multiply = 0;
			multiply = upper * 10;
			score = score + multiply;
		}
		
		System.out.println("Score: " + (score));
	}
    //set returns and public
	
	public int getUpper()
	{
		return upper;
	}
	
	public void setUpper(int upper)
	{
		this.upper = upper;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void setCount(int count)
	{
		this.count = count;
	}
	
	public int getPost_size()
	{
		return post_size;
	}
	
	public void setPost_size(int post_size)
	{
		this.post_size = post_size;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setSore(int score)
	{
		this.score = score;
	}
	
	public int getMultiply()
	{
		return multiply;
	}
	
	public void setMultiply(int multiply)
	{
		this.multiply = multiply;
	}
}
