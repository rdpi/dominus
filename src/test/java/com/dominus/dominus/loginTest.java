package com.dominus.dominus;


import static org.junit.Assert.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import junit.framework.TestCase;

import org.powermock.api.easymock.PowerMock;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.api.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when; 
import org.mockito.Matchers;
import static org.mockito.Matchers.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest({Authorizer.class})
public class loginTest extends TestCase {
	
@Mock
private Authorizer AuthorizerMocked;
	
	@Test(expected = NullPointerException.class)
	public void testNullInput1() throws NoSuchAlgorithmException{
	Authorizer testAuthorizer = new Authorizer();
	testAuthorizer.authorize(null, "bbdf43338");
	Mockito.when(AuthorizerMocked.hashIt("df43338")).thenReturn("");
  
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullInput2() throws NoSuchAlgorithmException {
	Authorizer testAuthorizer = new Authorizer();
	testAuthorizer.authorize("bbdf43338", null);
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullInput3() throws NoSuchAlgorithmException {
		Authorizer testAuthorizer = new Authorizer();
		testAuthorizer.authorize(null, null);
		
	}
	
	@Test
	public void testNullInput4() throws NoSuchAlgorithmException {
		Authorizer testAuthorizer = new Authorizer();
		testAuthorizer.authorize("us9090090", "bbdf43338");
		
	}
}