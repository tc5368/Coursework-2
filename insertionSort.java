import java.io.*;
import java.util.*;

public class insertionSort{
	static int swaps = 0;
	static int comparisons = 0;
	public static void main(String[] args){
		for (int i = 100; i <= 500; i += 100){
			removeStopWords words = new removeStopWords();
			ArrayList<String> wordList = words.getNonStepWords();
			if (i > wordList.size()){i = wordList.size();}
			ArrayList<String> toSort = new ArrayList<String>(wordList.subList(0,i));
			double startTime = System.nanoTime();
			insert(toSort);
			double endTime = System.nanoTime();
			System.out.println("Sorting "+i+" items took: " + (endTime-startTime)/100000000 + " Seconds");
			System.out.print("Took a total of: "+swaps+" Swaps, and "+comparisons+" Comparisons.\n\n");
		} 
	}

	public static void insert(ArrayList<String> words){
		for (int i = 0; i< words.size(); i++){
			String currentvalue = words.get(i);
			int position = i;
			while (position > 0 && words.get(position-1).compareTo(currentvalue) >= 0){
				swaps ++;
				words.set(position,words.get(position-1));
				comparisons++;
				position -= 1;
			}
			words.set(position,currentvalue);
			comparisons ++;
		}
	}
}
