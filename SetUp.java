package com.atmecs.dataexcel.testsuit;

	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.atmecs.dataexcel.constants.constants;

	public class SetUp {

		public static WebDriver driver;
		public static Properties properties;

		@BeforeMethod
		public void browserSetUp() throws FileNotFoundException, IOException {
			System.setProperty("webdriver.chrome.driver", constants.CHROME_PATH);
			driver = new ChromeDriver();

			driver.get("https://phptravels.com/");
			driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		}

		@AfterMethod
		public void closeBrowser() {
			driver.close();
		}

}
