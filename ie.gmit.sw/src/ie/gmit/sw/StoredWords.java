package ie.gmit.sw;

import java.io.*;
import java.util.*;

public class StoredWords implements Parser
{
	//Originaly tried to use a tree map because it could be ordered based on a value.
	//This was intended to give a list of the top used words. Decided to go with a 
	// #hash map as it is much faster.
	
	private Map<String, Integer> wordMap = new HashMap<String, Integer>();
	private StopWordsMap s;
	private WordCloud img;
	private int maxWords;
	
	
	//private Map<String, Integer> sorted_map = new TreeMap<String,Integer>();

	
	public StoredWords(String filename, StopWordsMap sl, int max) throws Exception
	{
		s = sl;	
		parse(filename);
		this.maxWords = max;
		img = new WordCloud(getMap(), maxWords);
		img.drawImage();
	}
	public void parse(String filename) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		StringBuffer sb = new StringBuffer();
		
		int j;
		while((j = br.read()) != -1){
			char next = (char)j;
			
			if (next >= 'A' && next <= 'z' || next == '\'')
			{
				sb.append(next);
			}	
			else 
			{
				String word = sb.toString().toUpperCase();
				sb = new StringBuffer();
				
				// add words unless word is in stopword
				if (!s.hasWord(word)&& word.length() > 5) 
				{
					
					int frequency = 0;
					if(wordMap.containsKey(word))
					{
						frequency = wordMap.get(word);
					}
					frequency++;
					
					wordMap.put(word, frequency);
					//sorted_map.put(word, frequency);
					//System.out.println(word + " : " + frequency);
				}
			}
		}
		br.close();		
	}
	
	static <K,V extends Comparable<? super V>>
	
	SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> sorted_map) 
	{
	    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
	        new Comparator<Map.Entry<K,V>>() 
	        {
	            @Override 
	            public int compare(Map.Entry<K,V> e2, Map.Entry<K,V> e1) {
	                int res = e1.getValue().compareTo(e2.getValue());
	                return res != 0 ? res : 1;
	            }
	        }
	    );
	    sortedEntries.addAll(sorted_map.entrySet());
	    return sortedEntries;
	}
	
	public Map<String, Integer> getMap()
	{	
		//System.out.println(entriesSortedByValues(sorted_map));
		//System.out.println(wordMap);
		return wordMap;
		
	}
}
