import static org.junit.Assert.*;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import org.apache.commons.jxpath.ri.model.beans.NullElementPointer;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.testng.Assert;
import junit.framework.TestCase;

public class loginTest extends TestCase {
	
	
	
	@Test()
	public void testNullInput1() throws invalidInputException {
	Authorizer testAuthorizer = new Authorizer(null, "2383726");
		
	}
	
	@Test()
	public void testNullInput2() throws invalidInputException {
	Authorizer testAuthorizer = new Authorizer("hiiiiii", null);
		
	}
	
	@Test()
	public void testNullInput3() throws invalidInputException {
	Authorizer testAuthorizer = new Authorizer(null, null);
		
	}
	
	
	
	
}