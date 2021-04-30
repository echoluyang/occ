package occTestProject;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import occTestProject.impl.TextFileReader;

public class MainScoreCalculatorTest {

	/*
	 * Test if the names is in order, will the answer be correct
	 * */
	@Test
	public void twoNamesInOrder() throws IOException {
		File file = File.createTempFile("myTempFile", ".txt");
		FileWriter fw = new FileWriter(file);
		fw.write("Amy,");  //(1+13+25) = 39
		fw.write("Bb,");  //(2+2) = 4
		fw.close();		// 39 * 1 + 4*2 = 47
		MainScoreCalculator cal = new MainScoreCalculator();
		int totalScore = cal.getFileScores(file.getAbsolutePath());
		assertEquals(47, totalScore);
		file.delete();
	}
	
	/*
	 * Test if the names is not in order, will the answer be correct
	 * */
	@Test
	public void twoNamesNotInOrder() throws IOException {
		File file = File.createTempFile("myTempFile", ".txt");
		FileWriter fw = new FileWriter(file);
		fw.write("Bb,");  //(2+2) = 4
		fw.write("Amy,");  //(1+13+25) = 39
		fw.close();		
		MainScoreCalculator cal = new MainScoreCalculator();
		int totalScore = cal.getFileScores(file.getAbsolutePath());
		assertEquals(47, totalScore);
		file.delete();
	}
}

