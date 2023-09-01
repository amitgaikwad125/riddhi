package riddhi_test;

import java.io.IOException;
import org.testng.annotations.Test;
import browserSetup.Browser;
import pomPages.J_ListTenantsPage;

public class J_ListTenantsTest extends Browser {

	
	@Test(priority=41)
	public void getTenantsPage() {
	J_ListTenantsPage ts = new J_ListTenantsPage();
	ts.getListTenantsPage();	
	}
	
	@Test(priority=42,enabled=false)
	public void showEntries() {
		J_ListTenantsPage ts1 = new J_ListTenantsPage();
		ts1.entries();
	}
	
	@Test(priority=43)
	public void getAllTenantsInfo() {
		J_ListTenantsPage ts3 = new J_ListTenantsPage();
		ts3.getAllTenantsList();
		
	}
	
	@Test(priority=44)
	public void searchTenant() throws IOException {
		J_ListTenantsPage ts4 = new J_ListTenantsPage();
		ts4.searchTenant();
	}
	
	@Test(priority=45,dependsOnMethods="searchTenant")
	public void viewTenantinfo() {
		J_ListTenantsPage ts5 = new J_ListTenantsPage();
		ts5.viewTenantInfo();
	}
	
	@Test(enabled=false,priority=46)
	public void deleteTenant() {
		J_ListTenantsPage ts6 = new J_ListTenantsPage();
		ts6.deleteTenantInfo();
	}
	
	
	
	
	
}
