package riddhi_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import browserSetup.Browser;
import pomPages.C_AddNewContents;



public class C_AddNewContentsTest extends Browser{

	@BeforeClass
	public void getAddNewContentsPage() {
		C_AddNewContents c=new C_AddNewContents();
		c.contentsLink();
		c.addNewContentLink();
	}
	
	
@Test(priority=11)
public void getdata() throws EncryptedDocumentException, IOException{
	C_AddNewContents c1=new C_AddNewContents();

	c1.addNewContentForm(8);
}


}
