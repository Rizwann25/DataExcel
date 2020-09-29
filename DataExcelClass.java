package com.atmecs.dataexcel.testscripts;

	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.atmecs.dataexcel.constants.constants;
import com.atmecs.dataexcel.helpers.HelperClass;
import com.atmecs.dataexcel.pages.DataProviderClass;
import com.atmecs.dataexcel.testsuit.SetUp;
import com.atmecs.dataexcel.utils.PropertyReader;

	public class DataExcelClass extends SetUp {

		Properties locators;

		@Test(dataProvider = "Data", dataProviderClass = DataProviderClass.class)

		public void startChat(String name, String address, String emailid, String mobile) throws InterruptedException {
			locators = PropertyReader.readProperty(constants.LOCATORS_PATH);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.switchTo().frame(locators.getProperty("Frame_Id"));
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators.getProperty("ChatWidget"))));

			HelperClass.jsClick(driver, locators.getProperty("ChatWidget"));
			HelperClass.sendKeyById(driver, locators.getProperty("NameData"), name);
			HelperClass.ElementSendKeys(driver, locators.getProperty("Mobile"), mobile);
			HelperClass.sendKeyById(driver, locators.getProperty("EmailData"), emailid);
			HelperClass.sendKeyById(driver, locators.getProperty("Address"), address);
			
			HelperClass.selectFromDropDown(driver, locators.getProperty("Dropdown"), locators.getProperty("value"));
			HelperClass.jsClick(driver, locators.getProperty("StartChat"));

			driver.switchTo().defaultContent();

		}

}
