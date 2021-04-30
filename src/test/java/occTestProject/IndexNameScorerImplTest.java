package occTestProject;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import occTestProject.impl.IndexNameScorerImpl;
import occTestProject.impl.TextFileReader;

public class IndexNameScorerImplTest {
	/*
	 * Test for illegal Names. Name should only contain letters
	 * */
	@Test
	public void testForIllegalName() {
		IndexNameScorerImpl target = new IndexNameScorerImpl();
		Assertions.assertThrows(IllegalArgumentException.class, () ->target.getNameScore("Amy123", 1));
		Assertions.assertThrows(IllegalArgumentException.class, () ->target.getNameScore("Allen&", 1));
	}

	@Test
	public void test() {
		IndexNameScorerImpl target = new IndexNameScorerImpl();
		assertEquals(22,target.getNameScore("B", 10));    //B:1, 2*11 = 22
		assertEquals(78,target.getNameScore("Amy", 1));  //(0-base index: 1, 1-based -index: 2)
		// A:0, M: 12, Y: 24, (1+13+25) * 2 =  78   
	}
}
