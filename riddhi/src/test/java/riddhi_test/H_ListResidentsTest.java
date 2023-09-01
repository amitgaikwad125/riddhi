package riddhi_test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import browserSetup.Browser;
import pomPages.H_ListResidentsPage;


public class H_ListResidentsTest extends Browser {

	@BeforeClass
	public void getResidentsPAge() {
		H_ListResidentsPage rs=new H_ListResidentsPage();
		rs.getListRedidentsPage();
	}
	
	@Test(priority=31,enabled=false)
	public void showEntries() {
		H_ListResidentsPage rs1=new H_ListResidentsPage();
		rs1.entries();
	}
	
	@Test(priority=32)
	public void getAllResidentsInfo() {
		H_ListResidentsPage rs2=new H_ListResidentsPage();
		rs2.getAllResidents();
		
	}
	
	@Test(priority=33,enabled=false)
	public void searchForResident() throws IOException {
		H_ListResidentsPage rs3=new H_ListResidentsPage();
		rs3.searchResident();
	}
	
	@Test(priority=34,dependsOnMethods= {"searchForResident"},enabled=false)
	public void viewResidentInfo() {
		H_ListResidentsPage rs4=new H_ListResidentsPage();
		rs4.viewResidentInfo();

	}
	
	@Test(priority=35,dependsOnMethods= {"searchForResident"},enabled=false)
	public void deleteResident() {
		H_ListResidentsPage rs4=new H_ListResidentsPage();
		rs4.deleteResidentInfo();

	}
	
}
