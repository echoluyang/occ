package occTestProject.impl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import occTestProject.fileReader;
public class TextFileReader implements fileReader {
	
	 /*
     * This function is for reading local .txt file
     * */
	public List<String> openLocalText(String name) throws IOException {
		List<String> list = new ArrayList<String>();
		File file = new File(name);
		BufferedReader read = new BufferedReader(new FileReader(file));
		  
		String currLine = null;
		while ((currLine = read.readLine()) != null) {
			String[] words = currLine.split(",");	 // split to whole line into names, and add the formatted name to list
			for(String word: words) {
				list.add(formatName(word));
			}
					
		}
		read.close();
		
		return list;
	}
		    
		
		
	
    /*
     * This function is for reading URL file
     * */
	public List<String> openURLFile(URL url) throws IOException {
		List<String> list = new ArrayList<String>();
		BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
		String currLine = null;
		while ((currLine = read.readLine()) != null) {
			String[] words = currLine.split(",");	 // split to whole line into names, and add the formatted name to list
			for(String word: words) {
				list.add(formatName(word));
			}
		}
		            
		read.close();
		return list;
	}
	
	
	/*
	 * This function process the input string to valid names by removing invalid characters including " "
	 * eg: amy123 -> amy
	 * full name if fine. "Bob Smith" -> BobSmith
	 * 
	 * */
	private String formatName(String s) {
		char[] array = s.toCharArray();
		int i = 0;
		int j = 0;
		while(j < array.length) {
			// remove leading space and illegal characters, only keep letters
			if((array[j] >= 'A' && array[j] <= 'Z') || (array[j] >= 'a' && array[j] <= 'z')) {
				array[i++] = array[j++];
			} else {
				j++;
			}
		}
		return new String(array, 0, i);
	}
}



