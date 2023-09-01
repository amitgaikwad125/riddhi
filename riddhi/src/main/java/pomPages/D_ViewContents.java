package pomPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import browserSetup.Browser;
import utility.Utils;

public class D_ViewContents extends Browser {

	@FindBy(xpath = "//span[text()='Contents']")
	private WebElement contents;

	@FindBy(xpath = "//a[@href='listcontents.php']")
	private WebElement viewContents;

	@FindBy(xpath = "//select[@name='sampleTable_length']")
	private WebElement entries;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement search;

	@FindBy(xpath="//table[@id='sampleTable']")
	private WebElement table;
	
	@FindBy(xpath="//li[@id='sampleTable_next']")
	private WebElement next;



	public D_ViewContents() {
		PageFactory.initElements(driver, this);
	}


	public void clickOnContents() {
		contents.click();
	}

	public void clickOnViewContents() {
		viewContents.click();
	}

	public void getContentsTable() {
		System.out.println("=========================== Contents Table =============================");
		Utils.getTableData(table, next);
		System.out.println("========================================================================");

	}

	public void searchContents() throws IOException {
		String input=Utils.getDataFromFile("searchContents");
		System.out.println(input);
		search.sendKeys(input);
		System.out.println("==========Search results for content:"+input+" ==================================");
		Utils.getTableData(table,next);
		System.out.println("=====================================================================");
	}














}
