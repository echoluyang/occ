package occTestProject;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

/**
 * This class calculates the scores for all names in the list of names get from source file
 * It utilizes multiple plug-in components for easy modifications and expansions*/

public class FileScoresCalculator {
	private fileReader freader = null;
	private NameScorer nscorer = null;
	
	public FileScoresCalculator(fileReader freader, NameScorer nscorer) {
		this.freader = freader;
		this.nscorer = nscorer;
	}
	
	
	/*
	 * This function is for local text file
	 * */
	public int getFileScore(String fileName) throws IOException {
		List<String> names = freader.openLocalText(fileName);
		Collections.sort(names, (a,b) -> (a.compareTo(b))); // sort the name alphabetically
		int total = 0;
		for(int i = 0; i < names.size(); i++) {
			total += nscorer.getNameScore(names.get(i), i);  // for each name in the file, add its score to the total score
		}
		
		return total;
	}
	
	
	/*
	 * This function is for URL file
	 * */
	public int getFileScore(URL fileName) throws IOException {
		List<String> names = freader.openURLFile(fileName);
		Collections.sort(names, (a,b) -> (a.compareTo(b))); // sort the name alphabetically
		int total = 0;
		for(int i = 0; i < names.size(); i++) {
			total += nscorer.getNameScore(names.get(i), i);
		}
		
		return total;
	}
	
}

