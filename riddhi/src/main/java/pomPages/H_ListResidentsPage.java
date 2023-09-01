package pomPages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import browserSetup.Browser;
import utility.Utils;

public class H_ListResidentsPage extends Browser {

	@FindBy(xpath="//span[text()='Users']")
	private WebElement users;
	
	@FindBy(xpath="//a[text()=' List Residents']")
	private WebElement listResindetsLink;
	
	@FindBy(xpath="//select[@name='sampleTable_length']")
	private WebElement entries;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement search;
	
	@FindBy(xpath="//table[@id='sampleTable']")
	private WebElement table;
	
	@FindBy(xpath="//li[@id='sampleTable_next']")
	private WebElement next;
	
	@FindBy(xpath="//a[text()='View']")
	private WebElement view;
	
	@FindBy(xpath="//a[text()='Delete']")
	private WebElement delete;
	
	@FindBy(xpath="//table[@id='sampleTable']")
	private WebElement residentInfoTable;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement message;
	
	
	
	
	public H_ListResidentsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void getListRedidentsPage() {
		users.click();
		listResindetsLink.click();
	}
	
	public void entries() {
		Utils.entries(entries, 3);
	}
	
	public void getAllResidents() {
		Utils.getTableData(table, next);
	}
	
	public void searchResident() throws IOException {
	String resident=Utils.getDataFromFile("searchResident");
	search.sendKeys(resident);
	System.out.println("========== Search results for Resident :"+resident+" ===================================");
	Utils.getTableData(table, next);
	System.out.println("========================================================");
	}
	
	public void viewResidentInfo() {
		view.click();
		System.out.println("================== Information of resident =================");
		Utils.getTableData(residentInfoTable);
		System.out.println("==============================================================");
		
	}
	
	public void deleteResidentInfo() {
		delete.click();
		driver.switchTo().alert().accept();
		assertEquals(message.getText(), "Success! User deleted successfully...");
	}
	
	
	
}
