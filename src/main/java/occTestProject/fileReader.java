package occTestProject;

import java.io.IOException;
import java.net.URL;
import java.util.List;


/*
Implementation of this interface takes in a file, process the file and output a list of strings
 * */
public interface fileReader {
	/*
	 * This function can read a text file located in local directory.
	 * @param url: the directory of the given file.
	 * @return the content of the source file.
	 * @throws FileNotFoundException: if the file is not located in the given directory.
	 * */
	
	public List<String> openLocalText(String name) throws IOException;
	
	/*
	 * This function can read a file located at the given URL.
	 * @param url: the URL of given source.
	 * @return the content of the source file.
	 * @throws IOException, FileNotFoundException: if there are I/O error when reading the file
	 * */
	public List<String> openURLFile(URL url) throws IOException;
	

}
