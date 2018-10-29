package com.housingboard.junittests;
import static net.sourceforge.jwebunit.junit.JWebUnit.*;
import org.junit.*;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;

public class LoginTest {
	@Before
	public void prepare() {
	     setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT); 
	     setBaseUrl("http://localhost:8080/HousingBoard");
	}
	@Test
	public void testLoginPage() {
		beginAt("login.jsp");
	    assertTitleEquals("HousingBoard Login");
	    assertLinkPresent("register");
	    clickLink("register");
	    assertTitleEquals("HousingBoard Registration");
	}
}
