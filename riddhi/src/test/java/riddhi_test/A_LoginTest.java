package riddhi_test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import browserSetup.Browser;
import pomPages.A_LoginPage;

public class A_LoginTest extends Browser {

	@BeforeTest
	public void getBrowser() throws IOException {
		openBrowser();
	}

	@Test(priority=1)
	public void loginTest() throws IOException {
		A_LoginPage lp = new A_LoginPage();
		lp.getPage();
		lp.checktitle();
		lp.setUsername();
		lp.setPassword();
		lp.checkSigninBtn();
		lp.successLogin();
	}



	@AfterTest(enabled=false)
	public void tearDown() {
		closeBrowser();
	}

}