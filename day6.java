package adventOfCode6;

import java.util.ArrayList;
import java.math.BigInteger;

public class fishProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//printMe(initializeOcean(), 0);
		System.out.println();
		System.out.println(Simulation(80));

	}
	public static ArrayList<Integer> initializeOcean() {
		int[] input = new int[] {1,3,4,1,5,2,1,1,1,1,5,1,5,1,1,1,1,3,1,1,1,1,1,1,1,2,1,5,1,1,1,1,1,4,4,1,1,4,1,1,2,3,1,5,1,4,1,2,4,1,1,1,1,1,1,1,1,2,5,3,3,5,1,1,1,1,4,1,1,3,1,1,1,2,3,4,1,1,5,1,1,1,1,1,2,1,3,1,3,1,2,5,1,1,1,1,5,1,5,5,1,1,1,1,3,4,4,4,1,5,1,1,4,4,1,1,1,1,3,1,1,1,1,1,1,3,2,1,4,1,1,4,1,5,5,1,2,2,1,5,4,2,1,1,5,1,5,1,3,1,1,1,1,1,4,1,2,1,1,5,1,1,4,1,4,5,3,5,5,1,2,1,1,1,1,1,3,5,1,2,1,2,1,3,1,1,1,1,1,4,5,4,1,3,3,1,1,1,1,1,1,1,1,1,5,1,1,1,5,1,1,4,1,5,2,4,1,1,1,2,1,1,4,4,1,2,1,1,1,1,5,3,1,1,1,1,4,1,4,1,1,1,1,1,1,3,1,1,2,1,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2,5,1,2,1,1,1,1,1,1,1,1,1};
		ArrayList<Integer> ocean = new ArrayList<>();
		for (int i =0 ; i<input.length; i++) {
			ocean.add(input[i]);
			
		}
		return ocean;
	}

	public static int Simulation(int totalDays) {
		ArrayList<Integer> ocean = initializeOcean();
		for(int days = 1; days <= totalDays; days++) {
			int temp = ocean.size();
			for(int i = 0; i < temp; i++) {
				if(ocean.get(i) == 0) {
					ocean.add(8);
					ocean.set(i, 6);
				} else {
					int curr = ocean.get(i);
					ocean.set(i, curr - 1);
				}
			}
			//printMe(ocean, days);
		}
		//returns the amount of total fish at the end

		return ocean.size();
	}

	//public static int getTotal(ArrayList<Integer> fishies) {
		
		// calculated total
	//}

	public static void printMe(ArrayList<Integer> fishies, int days) {
		System.out.println();
		System.out.print("After " + days + " days:" + fishies);
	}

}
