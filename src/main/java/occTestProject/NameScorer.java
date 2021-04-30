package occTestProject;

/**
 *  Implementations of this interface provide the algorithm to get each name's score
 *  based on its position in the list.
 *  
 *  can be implemented to have more complex designs.
 *  can be implemented to evaluate both first and last names.
 */

public interface NameScorer {
	/**
	 * Find a name's score based on it's index and name. 
	 * @param name is the first name of the name needs to be calculated. 
	 * Format need to be  "first".
	 * @param index the name's position in the name list
	 * @throws IllegalArgumentException thrown if the contents of name or index cannot be processed
	 * @return the calculate score of the name
	 */
	public int getNameScore(String name, int index);
}






