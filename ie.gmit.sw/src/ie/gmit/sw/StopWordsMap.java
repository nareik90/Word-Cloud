package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

public class StopWordsMap implements Parser
{
	private HashSet<String> stopWordsSet;
	
	StopWordsMap(String filename) throws Exception
	{
		stopWordsSet = new HashSet<String>();
		parse(filename);
	}
	public void parse(String filename) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		StringBuffer sb = new StringBuffer();
		
		int i;
		while((i = br.read()) != -1)
		{
			char next = (char)i;
			
			if (next != '\n') sb.append(next);
			
			else 
			{
				String sWord = sb.toString().toUpperCase();
				sb = new StringBuffer();	
				stopWordsSet.add(sWord);
			}
		}
		br.close();
	}
	public boolean hasWord(String word)
	{
		boolean isThere = false;
		if(stopWordsSet.contains(word))
		{
			isThere = true;
		}
		return isThere;
	}
}