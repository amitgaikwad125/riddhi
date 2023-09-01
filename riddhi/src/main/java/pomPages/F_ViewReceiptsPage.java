package pomPages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import browserSetup.Browser;
import utility.Utils;

public class F_ViewReceiptsPage extends Browser {

	@FindBy(xpath = "//span[text()=\"Receipt's\"]")
	private WebElement receiptsLink;

	@FindBy(xpath = "//a[text()=\" View Receipt's\"]")
	private WebElement viewReceiptsLink;

	@FindBy(xpath = "//input[@name='from_date']")
	private WebElement fromDate;

	@FindBy(xpath = "//input[@name='to_date']")
	private WebElement toDate;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement searchByDate;

	@FindBy(xpath = "//button[contains(@class,'buttons-copy')]")
	private WebElement copyBtn;

	@FindBy(xpath = "//button[contains(@class,'buttons-excel')]")
	private WebElement excelBtn;

	@FindBy(xpath = "//button[contains(@class,'buttons-csv')]")
	private WebElement csvBtn;

	@FindBy(xpath = "//button[contains(@class,'buttons-pdf')]")
	private WebElement pdfBtn;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchInput;

	@FindBy(xpath = "//table[@id='sampleTable']")
	private WebElement table;

	@FindBy(xpath = "//a[@id='sampleTable_next']")
	private WebElement next;
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement message;
	
	

	public F_ViewReceiptsPage() {
		PageFactory.initElements(driver, this);
	}

	public void viewReceiptsPage() {
		receiptsLink.click();
		viewReceiptsLink.click();
		assertEquals(driver.getTitle(), "List of Receipts");
	}

	public void selectFromDate() throws IOException {

		String from_Date = Utils.getDataFromFile("receipt_fromDate");
		System.out.println(from_Date);
		fromDate.sendKeys(from_Date);

	}

	public void selectToDate() throws IOException {

		String to_Date = Utils.getDataFromFile("receipt_toDate");
		System.out.println(to_Date);
		toDate.sendKeys(to_Date);
	}

	public void clickOnSearchbyDateBtdn() {
		searchByDate.click();
	}

	public void getListOfReceipts() {
		System.out.println("================List of receipts =================");
		Utils.getTableData(table, next);
		System.out.println("==================================================");

	}

	public void search() throws IOException {
		String input = Utils.getDataFromFile("searchReceipt");
		searchInput.sendKeys(input);
	}

	public void copyReceiptInfo() {
		assertTrue(copyBtn.isEnabled());
		copyBtn.click();
	}

	public void excelReceiptInfo() {
		assertTrue(excelBtn.isEnabled());
		excelBtn.click();
	}

	public void csvReceiptInfo() {
		assertTrue(csvBtn.isEnabled());
		csvBtn.click();
	}

	public void pdfReceiptInfo() {
		assertTrue(pdfBtn.isEnabled());
		pdfBtn.click();
	}

	public void viewReceiptByID() throws IOException {
		String id = Utils.getDataFromFile("receiptID");
		searchInput.sendKeys(id);
//		int rows = table.findElements(By.xpath("//tbody/tr")).size();
//		int cols = table.findElements(By.xpath("//tbody/tr[1]/td")).size();
//
//		String classText = next.getAttribute("class");
//		boolean value=false;
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		do {
//			for(int i=1;i<=rows;i++) {
//				String rowText=table.findElement(By.xpath("//tbody/tr["+i+"]/td[1]")).getText();
//				if(rowText.equalsIgnoreCase(id)) {
//					WebElement element = table.findElement(By.xpath("//tbody/tr["+i+"]/td[11]"));
//
//					element.click();
//					value=true;
//					break;
//				}
//			}
//			if(value==true) {
//				break;
//			}
//			next.click();
//			rows = table.findElements(By.xpath("//tbody/tr")).size();
//			classText = next.getAttribute("class");
//			
//		}while(!classText.contains("disabled"));
		
		WebElement element=Utils.findelement(table, next,id);
		element.findElement(By.xpath("//td[11]")).click();
	}
	
	public void editReceipt() throws IOException {
		String id = Utils.getDataFromFile("receiptID");
		searchInput.sendKeys(id);
//		int rows = table.findElements(By.xpath("//tbody/tr")).size();
//		int cols = table.findElements(By.xpath("//tbody/tr[1]/td")).size();
//
//		String classText = next.getAttribute("class");
//		boolean value=false;
//		WebElement element = null ;
//		do {
//			for(int i=1;i<=rows;i++) {
//				String rowText=table.findElement(By.xpath("//tbody/tr["+i+"]/td[1]")).getText();
//				if(rowText.equalsIgnoreCase(id)) {
//					 element = table.findElement(By.xpath("//tbody/tr["+i+"]/td[12]"));
//					element.click();	
//					value=true;
//					break;
//				}
//			}
//			if(value==true) {
//				break;
//			}
//			next.click();
//			rows = table.findElements(By.xpath("//tbody/tr")).size();
//			classText = next.getAttribute("class");
//			
//		}while(!classText.contains("disabled"));	
//			element.findElement(By.xpath("//a[text()='Edit']")).click();
		
		
		WebElement element=Utils.findelement(table, next, id);
		System.out.println(element);
		
		WebElement actions=element.findElement(By.xpath("//td[12]"));
		actions.click();
		actions.findElement(By.xpath("//div/div/a[@title='Edit Receipt']")).click();
	}
	
	
	
	
public void deleteReceipt() throws IOException {
	try {String id = Utils.getDataFromFile("receiptID");
	searchInput.sendKeys(id);
	WebElement element=Utils.findelement(table, next, id);
//	System.out.println(element);
	
	WebElement actions=element.findElement(By.xpath("//td[12]"));
	actions.click();
	actions.findElement(By.xpath("//div/div/a[text()='Delete']")).click();
	Utils.alert().accept();
	assertEquals(message.getText(), "Success! Receipt deleted successfully..");
	}
	catch(Exception e) {
		System.out.println("receipt not found");
	}
	
	
	}
	
	
	
	
	
	
	
	
}
