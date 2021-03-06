package KataTest;


import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import Kata.DictionaryReplacer;

public class DictionaryReplacerTest {
	
	private DictionaryReplacer replacer;

	@Before
	public void beforeClass() {
		 replacer = new DictionaryReplacer();
	}
	
	// test a partir d'une entr?e vide - cas input:"", dic Empty, output:""
	
	@Test
	public void testEmptyInput() {
		
		String input ="";
		Map<String, String> dictionry = new HashMap<String, String>();
		dictionry.put("", "Empty");
		
		String dict = replacer.replace(input, dictionry);
		
		assertEquals("Empty", dict);
	}
	
	@Test
	public void testWithOneInput() {
		
		String input="$temp$";
		Map<String, String> dictionry = new HashMap<String, String>();
		dictionry.put("temp", "temporary");
		String dict = replacer.replace(input, dictionry);
		
		assertEquals("temporary", dict);
	}
	
	@Test
	public void testMultipleInput() {
		
		String input ="$temp$ here comes the name $name$";
		
		Map<String, String> dictionry = new HashMap<String, String>();
		dictionry.put("temp", "temporary");
		dictionry.put("name", "John Doe");
		String dict = replacer.replace(input, dictionry);
		
		assertEquals("temporary here comes the name John Doe", dict);
	}

}
