package pomPages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import browserSetup.Browser;
import utility.Utils;

public class K_AddExpenses extends Browser {

	@FindBy(xpath = "//span[text()='Expenses']")
	private WebElement expensesLink;

	@FindBy(xpath = "//a[text()=' Add Expense']")
	private WebElement AddexpenseLink;

	@FindBy(xpath = "//input[@name='employee_name']")
	private WebElement empName;

	@FindBy(xpath = "//input[@name='expense_amount']")
	private WebElement expAmount;

	@FindBy(xpath = "(//select[@name='expense_mode'])[1]")
	private WebElement expType;

	@FindBy(xpath = "(//select[@name='expense_mode'])[2]")
	private WebElement expMode;

	@FindBy(xpath = "//input[@name='expense_date']")
	private WebElement expDate;

	@FindBy(xpath = "//textarea[@name='expense_note']")
	private WebElement expNote;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[@type='reset']")
	private WebElement clearBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successMessage;

	public K_AddExpenses() {
		PageFactory.initElements(driver, this);
	}

	public void getPage() {
		expensesLink.click();
		AddexpenseLink.click();
		assertEquals(driver.getTitle(), "Add Expense - Riddhi Co-op Housing Society");
		assertEquals(driver.getCurrentUrl(), "https://tronsoftech.in/projects/riddhi/add_expense.php");
	}

	public void employeName() throws EncryptedDocumentException, IOException {
		String expDoneBy = Utils.getDatafromexcel("Expenses", 8, 1);
		empName.sendKeys(expDoneBy);
	}

	public void expenseAmount() throws EncryptedDocumentException, IOException {
		String amount = Utils.getDatafromexcel("Expenses", 8, 2);
		expAmount.sendKeys(amount);
	}

	public void expenseType() throws EncryptedDocumentException, IOException {
		String type = Utils.getDatafromexcel("Expenses", 8, 3);
		expType.sendKeys(type);
	}

	public void expenseMode() throws EncryptedDocumentException, IOException {
		String type = Utils.getDatafromexcel("Expenses", 8, 4);
		expType.sendKeys(type);
	}

	public void expenseDate() throws EncryptedDocumentException, IOException {
		String date = Utils.getDatafromexcel("Expenses", 8, 5);
		expDate.sendKeys(date);
	}

	public void expenseNote() throws EncryptedDocumentException, IOException {
		String note = Utils.getDatafromexcel("Expenses", 8, 4);
		expNote.sendKeys(note);
	}

	public void clickOnSubmit() {
		assertTrue(submitBtn.isEnabled());
		submitBtn.click();
	}

	public void clickOnClear() {
		assertTrue(clearBtn.isEnabled());
		clearBtn.click();
	}
	
	public void successMessage() {
		assertEquals(successMessage.getText(), "Success! Expense added successfully!");
	}

}
