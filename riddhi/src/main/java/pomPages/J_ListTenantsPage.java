package pomPages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import browserSetup.Browser;
import utility.Utils;

public class J_ListTenantsPage extends Browser {
	
	@FindBy(xpath="//span[text()='Users']")
	private WebElement users;
	
	@FindBy(xpath="//a[text()=' List Tenants']")
	private WebElement listTenantsPageLink;
	
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
	private WebElement TenantInfoTable;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement message;
	
	public J_ListTenantsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void getListTenantsPage() {
		users.click();
		listTenantsPageLink.click();
		assertEquals(driver.getTitle(), "List of Tenants");
		assertEquals(driver.getCurrentUrl(),"https://tronsoftech.in/projects/riddhi/list-users.php?role=Tenant");
	}
	
	
	public void entries() {
		Utils.entries(entries, 3);
	}
	
	public void getAllTenantsList() {
		Utils.getTableData(table, next);
	}
	
	public void searchTenant() throws IOException {
		String tenant=Utils.getDataFromFile("searchTenant");
		search.sendKeys(tenant);
		System.out.println("========== Search results for Tenant :"+tenant+" ===================================");
		Utils.getTableData(table, next);
		System.out.println("========================================================");
		}
	
	
	public void viewTenantInfo() {
		view.click();
		System.out.println("================== Information of resident =================");
		Utils.getTableData(TenantInfoTable);
		System.out.println("==============================================================");
		
	}
	
	public void deleteTenantInfo() {
		delete.click();
		driver.switchTo().alert().accept();
		assertEquals(message.getText(), "Success! User deleted successfully...");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
