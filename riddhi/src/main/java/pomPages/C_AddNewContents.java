package pomPages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import browserSetup.Browser;
import utility.Utils;

public class C_AddNewContents extends Browser {

	@FindBy(xpath = "//span[text()='Contents']")
	private WebElement contents;

	@FindBy(xpath = "//a[text()=' Add New Content']")
	private WebElement addNewContentsLink;

	@FindBy(xpath = "//a[text()=' View Contents']")
	private WebElement viewContentsLink;

	@FindBy(xpath = "//select[@id='select']")
	private WebElement listOfSections;

	@FindBy(xpath = "//input[@name='contenttitle']")
	private WebElement contentTitle;

	@FindBy(xpath = "//input[@name='price']")
	private WebElement contentCharges;

	@FindBy(xpath = "//input[@name='sequence']")
	private WebElement sequence;

	@FindBy(xpath = "//input[@name='alt_tag']")
	private WebElement contentAltTag;

	@FindBy(xpath = "//textarea[@name='contentdesc']")
	private WebElement contentDesc;

	@FindBy(xpath = "//input[@name='content_date']")
	private WebElement selectDate;

	@FindBy(xpath = "//input[@name='content_location']")
	private WebElement location;

	@FindBy(xpath = "//input[@name='link']")
	private WebElement addLink;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement submitBtn;

	public C_AddNewContents() {
		PageFactory.initElements(driver, this);
	}

	public void contentsLink() {
		contents.click();
	}

	public void addNewContentLink() {
		addNewContentsLink.click();
	}

	public void addNewContentForm(int row) throws EncryptedDocumentException, IOException {

		String section = Utils.getDatafromexcel("Contents", row, 1);

		Select sa = new Select(listOfSections);
		sa.selectByValue(section);

		String title = Utils.getDatafromexcel("Contents", row, 2);
		contentTitle.sendKeys(title);

		String charges=Utils.getDatafromexcel("Contents", row, 3);
		contentCharges.sendKeys(charges);

		String contentSeq=Utils.getDatafromexcel("Contents", row, 4);
		sequence.sendKeys(contentSeq);

		String altImg=Utils.getDatafromexcel("Contents", row, 5);
		contentAltTag.sendKeys(altImg);

		String desc=Utils.getDatafromexcel("Contents", row, 6);
		contentDesc.sendKeys(desc);

		String date=Utils.getDatafromexcel("Contents", row, 7);
		selectDate.sendKeys(date);

		String locate=Utils.getDatafromexcel("Contents", row, 8);
		location.sendKeys(locate);

		String link=Utils.getDatafromexcel("Contents", row, 9);
		addLink.sendKeys(link);

		submitBtn.click();

		

	}

}
