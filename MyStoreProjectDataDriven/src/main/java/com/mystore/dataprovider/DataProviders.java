package com.mystore.dataprovider;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

import com.mystore.base.BaseClass;

public class DataProviders extends BaseClass{

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
	
	
	
	
}
