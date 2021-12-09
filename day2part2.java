package adventOfCode6;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class day2part1 {

	public static void main(String[] args) {
		ArrayList<String> divePosition = new ArrayList<>();
		divePosition = importFile("day2");
		System.out.println(addPosition(divePosition));
	}
	
	public static int addPosition(ArrayList<String> divePosition) {
		int horizontal = 0;
		int depth = 0;
		int aim = 0;
		for(int i = 0; i < divePosition.size(); i++) {
			if(divePosition.get(i).length() == 9) {
				int n = Integer.parseInt(divePosition.get(i).substring(8));
				horizontal += n;
				depth += aim * n;
			} else if (divePosition.get(i).length() == 4) {
				aim -= Integer.parseInt(divePosition.get(i).substring(3));
			} else if (divePosition.get(i).length() == 6) {
				aim += Integer.parseInt(divePosition.get(i).substring(5));
			}
		}
		
		return Math.abs(horizontal * depth);
	}
	
	public static ArrayList<String> importFile(String fileName) {
	    ArrayList<String> words = new ArrayList<>();
	    try {
	      File myObj = new File(fileName);
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        words.add(data);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    return words;
	  }

}
