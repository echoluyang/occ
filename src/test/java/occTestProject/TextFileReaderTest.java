package occTestProject;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import java.nio.file.*;
import java.io.*;

import org.junit.jupiter.api.Test;

import occTestProject.impl.TextFileReader;

public class TextFileReaderTest {

	@Test
	/*
	 * Test for empty file
	 * */
	public void testEmptyLocalText() throws IOException {
		File file = File.createTempFile("myTempFile", ".txt");
		TextFileReader target = new TextFileReader();
		List<String> result = target.openLocalText(file.getAbsolutePath());
		assertEquals(0, result.size());
		file.deleteOnExit();
	}
	
	@Test
	/*
	 * Test for normal local file, check if invalid input is removed, 
	 * and all the names have been put into a list
	 * */
	public void testGeneralLocalText() throws IOException {
		File file = File.createTempFile("myTempFile", ".txt");
		FileWriter fw = new FileWriter(file);
		fw.write("Amy,"); 
		fw.write("Bob,");  
		fw.write("\t Allen,\n"); // (LHS whitespace to be trimmed)
		fw.write("Jim  \n"); // (RHS whitespace to be trimmed)
		fw.write("Jim RICE"); // Can handle full name
		fw.close();
		TextFileReader target = new TextFileReader();
		List<String> result = target.openLocalText(file.getAbsolutePath());
		assertEquals(5, result.size());
		assertEquals(result.get(2), "Allen");
		assertEquals(result.get(3), "Jim");
		assertEquals(result.get(4), "JimRICE");
		file.delete();
	}
	
	@Test
	/*
	 * Test for URL file, check if invalid input is removed,
	 * and all the names have been put into a list
	 * */
	public void testGeneralURLText() throws IOException {
		File file = File.createTempFile("myTempFile", ".txt");
		FileWriter fw = new FileWriter(file);
		fw.write("Amy,"); 
		fw.write("Bob,");  
		fw.write("\t Allen,\n"); // (LHS whitespace to be trimmed)
		fw.write("Jim  \n"); // (RHS whitespace to be trimmed)
		fw.write("Jim RICE"); // Can handle full name
		fw.close();
		TextFileReader target = new TextFileReader();
		List<String> result = target.openURLFile(file.toURI().toURL());
		assertEquals(5, result.size());
		assertEquals(result.get(2), "Allen");
		assertEquals(result.get(3), "Jim");
		assertEquals(result.get(4), "JimRICE");
		file.delete();
	}
}
