import java.io.*;
import java.util.*;

public class mergeSort{
	static int swaps = 0;
	static int comparisons = 0;

	public static void main(String[] args){
		for (int i = 100; i <= 500; i += 100){
			removeStopWords words = new removeStopWords();
			ArrayList<String> wordList = words.getNonStepWords();
			if (i > wordList.size()){i = wordList.size();}
			ArrayList<String> toSort = new ArrayList<String>(wordList.subList(0,i));
			double startTime = System.nanoTime();
			merge(toSort);
			double endTime = System.nanoTime();
			System.out.print(	"\n\n");
			System.out.println("Sorting "+i+" items took: " + (endTime-startTime)/1000000000 + " Seconds");
			System.out.print("Took a total of: "+swaps+" Swaps, and "+comparisons+" Comparisons.\n\n");
		} 
	}

	public static void merge(ArrayList<String> words) {
		if (words.size()<=1) {return;}
		int mid = words.size()/2;

		ArrayList<String> left = new ArrayList<String>();
		ArrayList<String> right = new ArrayList<String>();

		for(int i = 0; i < mid; i++){
			left.add(words.remove(0));
		}
		while (words.size()!=0){
			right.add(words.remove(0));
		}

		merge(left);
		merge(right);

		while (left.size()!=0 && right.size()!=0){
			if (left.get(0).compareTo(right.get(0)) < 0){
				words.add(left.remove(0));
			}
			else{
				words.add(right.remove(0));
			}
			swaps++;
			comparisons++;
		}
		while(left.size()!=0){
			words.add(left.remove(0));
			swaps++;
		}
		while(right.size()!=0){
			words.add(right.remove(0));
			swaps++;
		}
	}
}