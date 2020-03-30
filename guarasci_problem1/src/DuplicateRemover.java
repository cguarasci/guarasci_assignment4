import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DuplicateRemover {
	ArrayList<String> uniqueWords = new ArrayList<String>();
	ArrayList<String> inputWords = new ArrayList<String>();
	
	public void remove (String dataFile) {
		Scanner in = null;
		
		try {
			in = new Scanner(Paths.get(dataFile));
		} 
		catch (IOException e) {
			System.out.println("An error has occured with the requested input file. Program terminated.");
			System.exit(0);
		}
		
		while (in.hasNext()) {
			inputWords.add(in.next());
		}
		
		for (String word : inputWords) {
			if(!uniqueWords.contains(word)) {
				uniqueWords.add(word);
			}
		}
		
		System.out.println(uniqueWords);
	}
	
	public void write (String outputFile) {
		
	}
	
}
