package adventOfCode6;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
public class Day1Part1 {

	public static void main(String[] args) {
		ArrayList<Integer> depth = new ArrayList<>();
	    depth = importFile("sonarDepth");
	    System.out.println(depthIncrease(depth));
	}
	
	public static int depthIncrease(ArrayList<Integer> depth) {
		int count = 0;
		for(int i = 0; i < depth.size() - 1; i++) {
			if(depth.get(i) < depth.get(i + 1)) {
				count++;
			}
		}
		return count;
	}
	
	public static ArrayList<Integer> importFile(String fileName) {
	    ArrayList<Integer> nums = new ArrayList<>();
	    try {
	      File myObj = new File(fileName);
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextInt()) {
	        int data = myReader.nextInt();
	        nums.add(data);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    return nums;
	  }
}
