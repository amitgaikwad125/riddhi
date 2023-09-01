package pomPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import browserSetup.Browser;
import utility.Utils;

public class L_ListExpenses extends Browser{
	
	@FindBy(xpath="//span[text()='Expenses']")
	private WebElement expensesLink;
	
	@FindBy(xpath="//a[text()=' List Expenses']")
	private WebElement listExpensesLink;
	
	@FindBy(xpath="//input[@name='from_date']")
	private WebElement fromDate;
	
	@FindBy(xpath="//input[@name='to_date']")
	private WebElement toDate;
	
	@FindBy(xpath="//select[@id='selectbox']")
	private WebElement empList;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement searchByDate;
	
	@FindBy(xpath = "//button[contains(@class,'buttons-copy')]")
	private WebElement copyBtn;

	@FindBy(xpath = "//button[contains(@class,'buttons-excel')]")
	private WebElement excelBtn;

	@FindBy(xpath = "//button[contains(@class,'buttons-csv')]")
	private WebElement csvBtn;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchInput;

	@FindBy(xpath = "//table[@id='sampleTable']")
	private WebElement table;

	@FindBy(xpath = "//a[@id='sampleTable_next']")
	private WebElement next;
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement message;
	
	public L_ListExpenses() {
		PageFactory.initElements(driver, this);
	}
	
	public void getPage() {
		expensesLink.click();
		listExpensesLink.click();
	}
	
	public void setFromDate() throws IOException {
		String from=Utils.getDataFromFile("exp_fromDate");
		fromDate.sendKeys(from);
	}
	
	public void setToDate() throws IOException {
		String to=Utils.getDataFromFile("exp_toDate");
		toDate.sendKeys(to);
	}
	
	public void setEmployeeName() throws IOException {
		String employee=Utils.getDataFromFile("empName");
		Select sa= new Select(empList);
		sa.selectByVisibleText(employee);
		
	}
	
	public void clickOnSearchBtn() {
		searchByDate.click();
		
	}
	
	public void searchReceiptByName() throws IOException {
		String name=Utils.getDataFromFile("search");
		searchInput.sendKeys(name);
		int rows=table.findElements(By.xpath("//tbody/tr")).size();
		int cols=table.findElements(By.xpath("//tbody/tr[1]/td")).size();
//		System.out.println(rows);
//		System.out.println(cols);
		
		String getClass = next.getAttribute("class");
		do {
			for (int i = 1; i < rows; i++) {
				for (int j = 1; j < cols; j++) {
					System.out
							.print(table.findElement(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]")).getText() + "	");
				}

				System.out.println();
			}
			getClass = next.getAttribute("class");
			next.click();
			rows=table.findElements(By.xpath("//tbody/tr")).size();
		} while (!getClass.contains("disabled"));

		
	}
}
