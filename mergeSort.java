import java.io.*;
import java.util.*;

public class mergeSort{
	public static void main(String[] args){
	removeStopWords words = new removeStopWords();
	ArrayList<String> wordList = words.getNonStepWords();

	System.out.print("Sorting"+wordList);
	}
}