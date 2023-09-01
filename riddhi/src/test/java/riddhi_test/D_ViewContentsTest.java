package riddhi_test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import browserSetup.Browser;
import pomPages.D_ViewContents;

public class D_ViewContentsTest extends Browser {

	
	@BeforeClass
	public void getContentsListPage() {
		D_ViewContents vs=new D_ViewContents();
		vs.clickOnContents();
		vs.clickOnViewContents();

	}
	
	
	@Test(priority=21)
	public void viewContentsList() {
		D_ViewContents vs1=new D_ViewContents();
		vs1.getContentsTable();
	}

	@Test(priority=22)
	public void searchContentsTest() throws IOException {
		D_ViewContents vs2=new D_ViewContents();
		vs2.searchContents();
		
	}
}
