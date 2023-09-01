package riddhi_test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import browserSetup.Browser;
import pomPages.F_ViewReceiptsPage;

public class F_ViewReceiptsTest extends Browser {
	
	@BeforeClass
	public void getViewReceiptsPage() {
		F_ViewReceiptsPage vs=new F_ViewReceiptsPage();
		vs.viewReceiptsPage();
	}
	
	@Test(enabled=false)
	public void searchByDate() throws IOException {
		F_ViewReceiptsPage vs1=new F_ViewReceiptsPage();
		vs1.selectFromDate();
		vs1.selectToDate();
		vs1.clickOnSearchbyDateBtdn();
	}
	
	@Test(enabled=false)
	public void getAllReceipts() {
		F_ViewReceiptsPage vs2=new F_ViewReceiptsPage();
		vs2.getListOfReceipts();

	}
	
	@Test(enabled=false)
	public void searchReceipts() throws IOException {
		F_ViewReceiptsPage vs3=new F_ViewReceiptsPage();
		vs3.search();

	}
	
	@Test(enabled=true)
	public void viewReceiptByID() throws IOException {
		F_ViewReceiptsPage vs4=new F_ViewReceiptsPage();
		vs4.viewReceiptByID();
	}
	
	@Test(enabled=false)
	public void editReceiptByID() throws IOException {
		F_ViewReceiptsPage vs5=new F_ViewReceiptsPage();
		vs5.editReceipt();

}
	@Test(enabled=false)
	public void deleteReceiptByID() throws IOException {
		F_ViewReceiptsPage vs6=new F_ViewReceiptsPage();
		vs6.deleteReceipt();
		}
	}
