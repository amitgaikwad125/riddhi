package riddhi_test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import browserSetup.Browser;
import pomPages.B_Sections;

public class B_SectionTest extends  Browser{


//test to create a new section

	@BeforeClass
	public void sections() {
		B_Sections sect=new B_Sections();

		sect.clickOnSections();
	}

	@Test(priority=2,enabled=false)
	public void createSection() throws IOException {

		B_Sections sect1=new B_Sections();

//		sect1.clickOnSections();
		sect1.addSection();
		sect1.clickOnSubmit();
		sect1.displayMessage();
	}
	
	@Test(priority=4)
	public void showEntries() {
		B_Sections sect4=new B_Sections();
		sect4.showEntries(2);
	}
	
	

	@Test(priority=5)
	public void getListOfSections() {
		B_Sections sect2=new B_Sections();
		sect2.getSectionsTable();
	}

	@Test(priority=6,enabled=false)
	public void searchSection() throws IOException {
		B_Sections sect3=new B_Sections();
		sect3.searchSections();
		
	}
}
