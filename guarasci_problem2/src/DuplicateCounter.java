import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class DuplicateCounter {
	Map<String, String> wordCounter = new HashMap<String, String>();
	
	public void count (String dataFile) {
		Scanner in = null;
		
		try {
			in = new Scanner(Paths.get(dataFile));
			
			while (in.hasNext()) {
				String word = in.next().toLowerCase();
				if (wordCounter.containsKey(word)) {
					/*The literal only reason why I did all these conversions
					  from String to int is because the assignment asked
					  for a "map of strings" so I hope that's what you meant
					  because otherwise I wouldn't have done this*/
					
					int countInt = Integer.parseInt(wordCounter.get(word));
					countInt++;
					String countString = Integer.toString(countInt);
					wordCounter.put(word, countString);
				}
				else {
					wordCounter.put(word, "1");
				}
			}
		} 
		catch (IOException e) {
			System.out.println("An error has occured with the requested input file. Program terminated.");
			System.exit(0);
		}
		
		in.close();
	}
	
	public void write (String outputFile) {
		BufferedWriter out;
		
		try {
			FileWriter fileWriter = new FileWriter (outputFile);
			out = new BufferedWriter(fileWriter);
			
			out.write("The unique words in this file and their amount of appearances are: \n");
			
			for(Entry<String, String> entry : wordCounter.entrySet()) {
                out.write(entry.getKey() + ": " + entry.getValue());
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
