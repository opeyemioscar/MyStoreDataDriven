package com.mystore.dataprovider;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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
	
	  public Object[][] accountCreation(Method m) {
        String sheetName = m.getName(); // Using method name for sheet name
        int rows = excel.getRowCount(sheetName);
        int column = excel.getColumnCount(sheetName);
        int actRows = rows - 1;
        Object[][] data = new Object[actRows][1];
        
        for (int i = 0; i < actRows; i++) {
            Map<String, String> hashMap = new HashMap<>();
            for (int j = 0; j < column; j++) {
                hashMap.put(excel.getCellData(sheetName, j, 1),
                            excel.getCellData(sheetName, j, i + 2));
            }
            data[i][0]=hashMap;
        }
        return data;
    }
	
}
