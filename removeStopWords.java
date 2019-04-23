import java.io.*;
import java.util.*;

public class removeStopWords{
	public static void main(String[] args) {

	ArrayList<String> stopwords = collect("stopwords.txt");
	ArrayList<String> gpt2 = collect("GPT2.txt");

	gpt2.removeAll(stopwords);
	System.out.println(gpt2);
	}

	public static ArrayList<String> collect(String filename){
		ArrayList<String> found = new ArrayList<String>();
		try{
			Scanner s = new Scanner(new File(filename));
			while(s.hasNext()){
				found.add(s.next());
			}
			s.close();
		}
		catch(IOException e){
			System.out.println("Error in reading "+filename);
		}
		return found;
	}
}