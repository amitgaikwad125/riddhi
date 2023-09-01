package pomPages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import browserSetup.Browser;
import utility.Utils;

public class E_AddReceiptsPage extends Browser{
	
	@FindBy(xpath="//span[text()=\"Receipt's\"]")
	private WebElement receiptsLink;
	
	@FindBy(xpath="//a[text()=' Add Receipt']")
	private WebElement addReceiptLink;
	
	@FindBy(xpath="//select[@name='userid']")
	private WebElement selectResident;
	
	@FindBy(xpath="//textarea[@name='payment_desc']")
	private WebElement paymentFor;
	
	@FindBy(xpath="//select[@name='mode_of_payment']")
	private WebElement paymentMode;
	
	@FindBy(xpath="//input[@id='total_amount']")
	private WebElement totalAmount;
	
	@FindBy(xpath="//input[@id='received_amount']")
	private WebElement receivedAmount;
	
	@FindBy(xpath="//input[@id='balance_amount']")
	private WebElement balanceAmount;
	
	@FindBy(xpath="//textarea[@name='payment_note']")
	private WebElement transactionDetails;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//button[@type='reset']")
	private WebElement clearBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successMessage;
	
	
	public E_AddReceiptsPage() {
		PageFactory.initElements(driver, this);
	}

	public void getAddReceiptsPAge() {
		receiptsLink.click();
		addReceiptLink.click();
		
		
	}
	
	public void addNewReceiptForm(int row) throws EncryptedDocumentException, IOException {
		String resident=Utils.getDatafromexcel("Receipts", row, 1);
		Select sa=new Select(selectResident);
		sa.selectByVisibleText(resident);
		
		String payFor=Utils.getDatafromexcel("Receipts", row, 2);
		paymentFor.sendKeys(payFor);
		
		String payMode=Utils.getDatafromexcel("Receipts", row, 3);
		Select sa1=new Select(paymentMode);
		sa1.selectByVisibleText(payMode);
		
		String totalAmt=Utils.getDatafromexcel("Receipts", row, 4);
		totalAmount.sendKeys(totalAmt);
		
		String receivedAmt=Utils.getDatafromexcel("Receipts", row, 5);
		receivedAmount.sendKeys(receivedAmt);
		
		String transactionDtls=Utils.getDatafromexcel("Receipts", row, 6);
		transactionDetails.sendKeys(transactionDtls);
		
	}
	
	@Test
	public void clickSumbit() {
		submitBtn.click();
		assertEquals(successMessage.getText(), "Success!Receipt added successfully!");
	}
	
	public void clickreset() {
		clearBtn.click();
		}
	
	
}
