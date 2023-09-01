package riddhi_test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import browserSetup.Browser;
import pomPages.L_ListExpenses;

public class L_ListExpensesTest extends Browser{
	
	@BeforeClass
	public void getListExpensesPage() {
		L_ListExpenses ls=new L_ListExpenses();
		ls.getPage();
	}
	
	@Test(enabled=false)
	public void searchExpenseByDate() throws IOException {
		L_ListExpenses ls1=new L_ListExpenses();
		ls1.setFromDate();
		ls1.setToDate();
		ls1.setEmployeeName();
		ls1.clickOnSearchBtn();
	}
	
	
	@Test
	public void searchExpenseByName() throws IOException {
		L_ListExpenses ls2=new L_ListExpenses();
		ls2.searchReceiptByName();
	}
	
	
	
	
	
	
}
