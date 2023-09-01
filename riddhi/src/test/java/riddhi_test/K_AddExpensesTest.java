package riddhi_test;



import static org.testng.Assert.fail;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pomPages.K_AddExpenses;
import utility.Utils;

public class K_AddExpensesTest {

	@BeforeClass
	public void getAddExpensesPage() {
		K_AddExpenses ad=new K_AddExpenses();
		ad.getPage();
	}
	
	
	@Test
	public void addExpenseForm() throws EncryptedDocumentException, IOException {
		K_AddExpenses ad1=new K_AddExpenses();
		ad1.employeName();
		ad1.expenseAmount();
		ad1.expenseType();
		ad1.expenseMode();
		ad1.expenseDate();
		ad1.expenseNote();
		ad1.clickOnSubmit();
		ad1.successMessage();
	}
	
	
	
	
	
	
}
