import java.io.*;
import java.util.*;

public class insertionSort{
	public static void main(String[] args){
	removeStopWords words = new removeStopWords();
	ArrayList<String> wordList = words.getNonStepWords();

	long startTime = System.nanoTime();
	sort(wordList,100);
	long endTime   = System.nanoTime();
	System.out.println(startTime-endTime);

	// sort(wordList,100);
	// sort(wordList,200);
	// sort(wordList,300);
	// sort(wordList,1000);
	}

	public static void sort(ArrayList<String> words,int count){
		if (count > words.size()){ count = words.size();}
		for (int i = 0; i< count; i++){
			String currentvalue = words.get(i);
			int position = i;
			while (position > 0 && words.get(position-1).compareTo(currentvalue) >= 0){
				words.set(position,words.get(position-1));
				position -= 1;
			}
			words.set(position,currentvalue);
		}
	}
}