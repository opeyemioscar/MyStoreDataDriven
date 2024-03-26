package com.mystore.dataprovider;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.mystore.base.BaseClass;
import com.mystore.utilities.ExcelReader;

public class DataProviders extends BaseClass{
	
	public ExcelReader excel;

	@DataProvider(name="dp")
	public Object[][] getData(Method m) {
	
		String sheetName = m.getName();
		
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
			
		Object[][] data = new Object[rows-1][cols];
	
		
		for(int rowNum=2; rowNum<=rows; rowNum++) {
			
			for(int colNum=0; colNum<cols;colNum++) {
				
				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				
			}
			
		}
		
		
		return data;
		
		
	}
	
	@DataProvider(name = "newAcountDetailsData")
	public Object[][] accountCreation() {
		
		// Totals rows count
		int rows = excel.getRowCount("AccountCreationData");
		// Total Columns
		int column = excel.getColumnCount("AccountCreationData");
		int actRows = rows - 1;
		//Created an object of array to store data
		Object[][] data = new Object[actRows][1];
		
		for (int i = 0; i < actRows; i++) {
			Map<String, String> hashMap = new HashMap<>();
			for (int j = 0; j < column; j++) {
				hashMap.put(excel.getCellData("AccountCreationData", j, 1),
						excel.getCellData("AccountCreationData", j, i + 2));
			}
			data[i][0]=hashMap;
		}
		return data;
	}
	
	
}
