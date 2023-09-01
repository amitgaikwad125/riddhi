package riddhi_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import browserSetup.Browser;
import pomPages.E_AddReceiptsPage;

public class E_AddReceiptsTest extends Browser{
	
	@BeforeClass
	public void getPage() {
		E_AddReceiptsPage ar=new E_AddReceiptsPage();
		ar.getAddReceiptsPAge();
	}
	
	@Test
	public void createNewReceipt() throws EncryptedDocumentException, IOException {
		E_AddReceiptsPage ar1=new E_AddReceiptsPage();
		ar1.addNewReceiptForm(6);
		ar1.clickSumbit();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
