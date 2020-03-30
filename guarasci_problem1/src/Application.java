
public class Application {

	public static void main(String[] args) {
		DuplicateRemover duplicateRemover = new DuplicateRemover();
		String dataFile = "problem1.txt";
		String outputFile = "unique_words.txt";
		
		duplicateRemover.remove(dataFile);
		duplicateRemover.write(outputFile);
	}

}
