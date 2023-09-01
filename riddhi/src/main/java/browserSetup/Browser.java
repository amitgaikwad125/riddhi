package browserSetup;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Utils;

public class Browser {

	public static WebDriver driver;

	public static void openBrowser() throws IOException {
		String getBrowser=Utils.getDataFromFile("browser");

		if(getBrowser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver","C://selenium/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();

		}else if(getBrowser.equalsIgnoreCase("edge")){
//			System.setProperty("webdriver.edge.driver", "C://selenium/msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void closeBrowser() {
		driver.quit();
	}
}
