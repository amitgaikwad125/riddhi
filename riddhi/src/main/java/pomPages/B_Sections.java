package pomPages;


import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import browserSetup.Browser;
import utility.Utils;

public class B_Sections extends Browser {

	@FindBy(xpath = "//span[text()='Sections']")
	private WebElement sectionslink;

	@FindBy(xpath = "//input[@name='sectionname']")
	private WebElement input;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement button;

	@FindBy(xpath = "//select[@name='sampleTable_length']")
	private WebElement entries;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement search;

	@FindBy(id = "sampleTable_previous")
	private WebElement previous;

	@FindBy(id = "sampleTable_next")
	private WebElement next;

	@FindBy(xpath = "//div[contains(@class,'alert')]")
	private WebElement message;

	@FindBys({ @FindBy(xpath = "//table[@id='sampleTable']/tbody/tr/td/h5") })
	private List<WebElement> list;

	@FindBy(xpath = "//table[@id='sampleTable']")
	private WebElement table;

	@FindBys({ @FindBy(xpath = "//ul[@class='pagination']/li") })
	private List<WebElement> noOfPages;

	public B_Sections() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnSections() {
		sectionslink.click();
	}

	public void addSection() throws IOException {
		String section = Utils.getDataFromFile("createSection");
		input.sendKeys(section);

	}

	public void clickOnSubmit() {
		button.click();

	}

	public void displayMessage() {
		String displayMessage = message.getText();
		System.out.println(displayMessage);
	}

//	public void getSections() {
//		int row = table.findElements(By.xpath("//table[@id='sampleTable']/tbody/tr")).size();
//		int col = table.findElements(By.xpath("//table[@id='sampleTable']/tbody/tr[1]/td")).size();
//		String getClass=next.getAttribute("class");
//		System.out.println("********************"+getClass);
//		while(!getClass.contains("disabled")) {
//			for (int i = 1; i <= row; i++) {
//				for (int j = 1; j <= col; j++) {
//					System.out.print(
//							table.findElement(By.xpath("//table[@id='sampleTable']/tbody/tr[" + i + "]/td[" + j + "]"))
//									.getText() + "	");
//				}
//				System.out.println();
//			}
//			getClass=next.getAttribute("class");
//			next.click();
//		}
//	}
	
	public void showEntries(int option) {
		Utils.entries(entries, option);
	}
	
	public void getSectionsTable() {
		System.out.println("==========List of sections ==================");
		Utils.getTableData(table, next);
		System.out.println("=============================================");
	}

	public void clickOnNextButton() {
		next.click();
	}

	public void searchSections() throws IOException {
		String input=Utils.getDataFromFile("searchSection");
		search.sendKeys(input);
		System.out.println("======== Search results for section:"+input+" =========================");
		Utils.getTableData(table, next);
		System.out.println("================================================================");

	}
	
	
	
	
}
