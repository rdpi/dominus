package com.dominus.dominus;


import static org.junit.Assert.*;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import junit.framework.TestCase;

public class loginTest extends TestCase {
	
	//Testing null and empty inputs
	@Test()
	public void testNullInput1() throws invalidInputException 
	{
		assertEquals(authorize(null, "12345678"),false);
	}
	
	@Test()
	public void testNullInput2() throws invalidInputException 
	{
		assertEquals(authorize("12345678", null),false);
	}
	
	@Test()
	public void testNullInput2() throws invalidInputException 
	{
		assertEquals(authorize(null, null),false);
	}
	
	@Test()
	public void testNullInput1() throws invalidInputException 
	{
		assertEquals(authorize("", "12345678"),false);
	}
	
	@Test()
	public void testNullInput2() throws invalidInputException 
	{
		assertEquals(authorize("12345678", ""),false);
	}
	
	@Test()
	public void testNullInput2() throws invalidInputException 
	{
		assertEquals(authorize("", ""),false);
	}
	
	//Username too short
	@Test()
	public void testNullInput2() throws invalidInputException 
	{
		assertEquals(authorize("1234567", "12345678"),false);
	}
	
	//Password too short
	@Test()
	public void testNullInput2() throws invalidInputException 
	{
		assertEquals(authorize("12345678", "1234567"),false);
	}
	
	//Username and password too short
	@Test()
	public void testNullInput2() throws invalidInputException 
	{
		assertEquals(authorize("1234567", "1234567"),false);
	}
	
	//Correct input
	@Test()
	public void testNullInput2() throws invalidInputException 
	{
		assertEquals(authorize("12345678", "12345678"),false);
	}
	
	
	
	
}