package ie.gmit.sw.Testing;

import org.junit.*;
import ie.gmit.sw.*;

public class Tests {
	private StoredWords wordTest;
	private StopWordsMap stop;

	@Before
	@After
	public void destroyMap()
	{
		wordTest = null;
	}

	@Test
	public void testWordEntriesValid() throws Exception
	{
		stop = new StopWordsMap("./stopWords.txt");
		wordTest = new StoredWords("./JamesText.txt", stop, 100);
	}
	
	@Test
	public void testWordEntriesInValid() throws Exception
	{
		stop = new StopWordsMap("./stopWords.txt");
		wordTest = new StoredWords("./JamesesText.txt", stop, 100);
	}
	
	@Test
	public void checkValidStopWords() throws Exception
	{
		stop = new StopWordsMap("./stopWords.txt");
		stop.hasWord("to");
	}
	
	@Test
	public void checkInValidStopWords() throws Exception
	{
		//Test should be negative. Issue with the stop word list.
		stop = new StopWordsMap("./stopWords.txt");
		stop.hasWord("Camels");
	}

}
