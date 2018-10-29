package com.housingboard.junittests;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertLinkPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.clickLink;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;
import static net.sourceforge.jwebunit.junit.JWebUnit.setTestingEngineKey;
import org.junit.Test;

public class LoginTest {

	@Test
	public void testLoginPage() {
		beginAt("login.jsp"); 
	    assertTitleEquals("HousingBoard");
	}
}
