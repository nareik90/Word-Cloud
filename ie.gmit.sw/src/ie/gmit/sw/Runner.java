package ie.gmit.sw;

public class Runner {
	
	public static void main(String[] args) throws Exception {
		
		 
		//FileParser p = new FileParser("C:/Users/kiera/OneDrive/Word Cloud/ie.gmit.sw/src/JamesText.txt");	
		 StopWordsMap stopWords = new StopWordsMap("C:/Users/kiera/OneDrive/Word Cloud/ie.gmit.sw/src/JamesText.txt");
		Parser toParse = new StoredWords("C:/Users/kiera/OneDrive/Word Cloud/ie.gmit.sw/src/JamesText.txt", stopWords, 100);	
			System.out.println("Done");
	}
}
