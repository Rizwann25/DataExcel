package com.atmecs.dataexcel.pages;

	import java.io.IOException;

	import org.testng.annotations.DataProvider;

import com.atmecs.dataexcel.constants.constants;


	public class DataProviderClass {

	  @DataProvider(name="Data")
	   public static Object[][] getData() throws IOException
	   {
			XlsReader xls= new XlsReader(constants.TESTDATA_PATH);
			Object[][] data=xls.readExcelData("DataSheet");
			return data;
			
	   }
	}

