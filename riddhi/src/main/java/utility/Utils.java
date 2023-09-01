package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import browserSetup.Browser;

public class Utils extends Browser {

	public static void getPage(String url) {
		driver.get(url);
	}

	public static String getDataFromFile(String property) throws IOException {
//		C:\\Users\\amitg\\New folder\\riddhi
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\info.properties");
		Properties p = new Properties();
		p.load(fs);
		return p.getProperty(property);

	}

	public static String getDatafromexcel(String sheet, int row, int col)
			throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\testdata.xlsx");

		Sheet element = WorkbookFactory.create(file).getSheet(sheet);
		String input = element.getRow(row-1).getCell(col-1).getStringCellValue();
		return input;
	}

	public static void getTableData(WebElement table, WebElement next) {
//		table[@id='sampleTable']/  //table[@id='sampleTable']/  //table[@id='sampleTable']/
		int row = table.findElements(By.xpath("//tbody/tr")).size();
		int col = table.findElements(By.xpath("//tbody/tr[1]/td")).size();
//		System.out.println(row);
//		System.out.println(col);
		String getClass = next.getAttribute("class");
		do {
			for (int i = 1; i <= row; i++) {
				for (int j = 1; j <= col; j++) {
					System.out
							.print(table.findElement(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]")).getText() + "	");
				}

				System.out.println();
			}
			getClass = next.getAttribute("class");
			next.click();
			row=table.findElements(By.xpath("//tbody/tr")).size();
		} while (!getClass.contains("disabled"));

	}

	public static void getTableData(WebElement table) {

		int row = table.findElements(By.xpath("//tbody/tr")).size();
		int col = table.findElements(By.xpath("//tbody/tr[1]/th")).size()
				+ table.findElements(By.xpath("//tbody/tr[1]/td")).size();
//		System.out.println("row=" + row);
//		System.out.println("col=" + col);

		for (int i = 1; i <= row; i++) {
			for (int j = 1; j < col; j++) {
				System.out.print(table.findElement(By.xpath("//tbody/tr[" + i + "]/th[" + j + "]")).getText()+" : "+table.findElement(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]")).getText());
			}
			System.out.println();
		}
	}

//	public static void getTable22(WebElement table, WebElement next) {
//		int row = table.findElements(By.xpath("//table[@id='sampleTable']/tbody/tr")).size();
//		int col = table.findElements(By.xpath("//table[@id='sampleTable']/tbody/tr[1]/td")).size();
//		String getClass=next.getAttribute("class");
//		System.out.println("********************"+getClass);
//		System.out.println("row="+row);
//		System.out.println("col="+col);
//		while(!getClass.contains("disabled")) {
//			for (int i = 1; i <= row; i++) {
//				for (int j = 1; j <= col; j++) {
//					System.out.print(
//							table.findElement(By.xpath("//table[@id='sampleTable']/tbody/tr[" + i + "]/td[" + j + "]"))
//									.getText() + "	");
//				}
//				System.out.println();
//			}
//			getClass=next.getAttribute("class");
//			next.click();
//		}
//	}

	public static void entries(WebElement entries, int option) {
		Select sa = new Select(entries);
		if (option == 1) {
			sa.selectByVisibleText("10");
		} else if (option == 2) {
			sa.selectByVisibleText("25");
		} else if (option == 3) {
			sa.selectByVisibleText("50");
		} else if (option == 4) {
			sa.selectByVisibleText("100");
		} else {
			System.out.println("please enter value between 1 to 4");
		}
	}

	
	public static WebElement findelement(WebElement table,WebElement next,String search) throws IOException {
		
//		searchInput.sendKeys(id);
		int rows = table.findElements(By.xpath("//tbody/tr")).size();
//		int cols = table.findElements(By.xpath("//tbody/tr[1]/td")).size();

		String classText = next.getAttribute("class");
		boolean value=false;
		WebElement element = null;
//		JavascriptExecutor js=(JavascriptExecutor)driver;
		do {
			for(int i=1;i<=rows;i++) {
				String rowText=table.findElement(By.xpath("//tbody/tr["+i+"]/td[1]")).getText();
				if(rowText.equalsIgnoreCase(search)) {
					 element = table.findElement(By.xpath("//tbody/tr["+i+"]"));
					value=true;
					break;
				}
			}
			if(value==true) {
				break;
			}
			next.click();
			rows = table.findElements(By.xpath("//tbody/tr")).size();
			classText = next.getAttribute("class");
			
		}while(!classText.contains("disabled"));
		return element;		
	}
	
	public static Alert alert() {
	 Alert alert = driver.switchTo().alert();
	 return alert;
	}
	
	public static String getscreenshot(String testName) throws IOException {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/reports/"+testName+".png";
//		System.out.println(path);
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		return path;
		
		
	}
	
}
