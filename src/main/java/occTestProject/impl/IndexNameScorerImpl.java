package occTestProject.impl;

import occTestProject.NameScorer;

/**
 * Calculate a name score by the following rule:
 * 1. sum the alphabetical value of each letter (A=1, B=2, C=3, etc...)
 * 2. multiply the sum by the name’s position in the list (1-based).
 */

public class IndexNameScorerImpl implements NameScorer {

	public int getNameScore(String name, int index) {
		if(name == null || name.length() == 0) {
			return 0;
		}
	
		int sum = 0;
		for(char ch: name.toCharArray()) {
			if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
				sum += Character.toUpperCase(ch) - 'A' + 1; // calculate the letter sum of each name
			} else {
				throw new IllegalArgumentException("Name should only contains letters");
				// after pre-process,name should only contains letters
			}
			
		}
		
		int score = sum * (index+1);   // input index is 0 based. Change it to 1 based when calculate score
		return score;
	}
}