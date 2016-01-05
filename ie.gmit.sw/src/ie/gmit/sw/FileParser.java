package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class FileParser {
	
	private Map<String, Integer> wordMap = new HashMap<String, Integer>();
	private StopWordsMap s = new StopWordsMap();
	// Saves top 20 highest occuring word frequencies


	public FileParser(String fileName) throws Exception {
		super();
		parse(fileName);
	}
	
	private void parse(String file) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		StringBuffer sb = new StringBuffer();
		
		int j;
		// Continue reading until end of file is reached
		while((j = br.read()) != -1){
			char next = (char)j;
			
			if (next >= 'A' && next <= 'z' || next == '\''){
				sb.append(next);
			}
			
			else {
				String word = sb.toString().toUpperCase();
				sb = new StringBuffer();
				
				// Only add word to map if it isn't in stopwords HashSet
				if (!s.compare(word) && word.length() > 0) {
					int frequency = 0;
					
					if(wordMap.containsKey(word)){
						frequency = wordMap.get(word);
					}
					frequency++;
					wordMap.put(word, frequency);
				}
			}
		}
		for(String word : wordMap.keySet())  {
			double score = getScore(word);
			
			System.out.println("word: " + word + " freq: " + wordMap.get(word) + " score " + score);
			
		}
		br.close();		
		
	}	
	
	private double getScore(String word) {
		double score;
		
		double freq = (double)wordMap.get(word);
		int total = wordMap.size();
		
		score = (freq+total)/total;
		score = round(score, 6);
		DecimalFormat f = new DecimalFormat("##.000000");
		return score;
	}


	private double round(double val, int places)
	{
		String s = String.format("%."+places+"f", val);
		double result = Double.parseDouble(s);
	    return result;
	}

}
