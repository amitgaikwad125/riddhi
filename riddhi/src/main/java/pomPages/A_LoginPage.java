package pomPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import browserSetup.Browser;
import utility.Utils;

public class A_LoginPage extends Browser {

	@FindBy(xpath = "//label[text()='Riddhi Co-op Housing Society']")
	private WebElement projectName;

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement username;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(tagName = "button")
	private WebElement signinBtn;

	// constructor to initialize the webelements
	public A_LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void getPage() throws IOException {
		String url = Utils.getDataFromFile("url");
		Utils.getPage(url);

	}

	public void checktitle() {
		String expTitle = "Riddhi Co-op Housing Society";
		String actTitle = projectName.getText();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actTitle, expTitle);
		sa.assertAll();
	}

	public void setUsername() throws IOException {
		String userName=Utils.getDataFromFile("username");
		username.sendKeys(userName);

	}

	public void setPassword() throws IOException {
		String passWord=Utils.getDataFromFile("password");
		password.sendKeys(passWord);

	}

	public void checkSigninBtn() {
		signinBtn.click();
	}

	public void successLogin() {
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(driver.getCurrentUrl(), "https://tronsoftech.in/projects/riddhi/listenquiries.php",
				"URL verification failed");
		sa.assertAll();
	}
}
