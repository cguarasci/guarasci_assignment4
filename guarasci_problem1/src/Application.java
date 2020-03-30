
public class Application {

	public static void main(String[] args) {
		DuplicateRemover duplicateRemover = new DuplicateRemover();
		String dataFile = "problem1.txt";
		
		duplicateRemover.remove(dataFile);
	}

}
