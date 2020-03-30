import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
	HashSet<String> uniqueWords = new HashSet<String>();
	Set<String> inputWords = new HashSet<String>();
	
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
			uniqueWords.add(in.next().toLowerCase());
		}
		
		in.close();
	}
	
	public void write (String outputFile) {
		BufferedWriter out;
		
		try {
			FileWriter fileWriter = new FileWriter (outputFile);
			out = new BufferedWriter(fileWriter);
			
			for (String word : uniqueWords) {
				out.write(word);
				out.newLine();
			}
			
			out.close();
		} 
		catch (IOException e) {
			System.out.println("An error has occured with the requested input file. Program terminated.");
			System.exit(0);
		}
	}
}
