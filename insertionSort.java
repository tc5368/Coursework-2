import java.io.*;
import java.util.*;

public class insertionSort{
	public static void main(String[] args){
		for (int i = 100; i < 500; i += 100){
			removeStopWords words = new removeStopWords();
			ArrayList<String> wordList = words.getNonStepWords();
			sort(wordList,i);
		} 
	}

	public static void sort(ArrayList<String> words,int count){
		if (count > words.size()){ count = words.size();}
		int swaps = 0;
		int comparisons = 0;
		long startTime = System.nanoTime();

		//Sorting Start
		for (int i = 0; i< count; i++){
			swaps += 1;
			String currentvalue = words.get(i);
			int position = i;
			while (position > 0 && words.get(position-1).compareTo(currentvalue) >= 0){
				comparisons += 1;
				swaps += 1;
				words.set(position,words.get(position-1));
				position -= 1;
			}
			words.set(position,currentvalue);
			comparisons += 1;
			swaps += 1;
		}
		long endTime = System.nanoTime();
		System.out.print(words.subList(0,count)+"\n\n");
		System.out.println("Sorting "+count+" items took: " + (endTime-startTime) + " Nanoseconds");
		System.out.print("Took a total of: "+swaps+" Swaps, and "+comparisons+" Comparisons.\n\n");
	}
}