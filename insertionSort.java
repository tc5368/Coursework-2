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
		long startTime = System.nanoTime();
		for (int i = 0; i< count; i++){
			String currentvalue = words.get(i);
			int position = i;
			while (position > 0 && words.get(position-1).compareTo(currentvalue) >= 0){
				words.set(position,words.get(position-1));
				position -= 1;
			}
			words.set(position,currentvalue);
		}
		long endTime = System.nanoTime();
		System.out.println("Sorting "+count+" items took: " + (endTime-startTime) + " Nanoseconds");

	}
}