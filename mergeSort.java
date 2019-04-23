import java.io.*;
import java.util.*;

public class mergeSort{
	public static void main(String[] args){
	removeStopWords words = new removeStopWords();
	ArrayList<String> wordList = words.getNonStepWords();

	sort(wordList);
	}

	public static void sort(ArrayList<String> words){
		System.out.print("Sorting" + words);
	}
}