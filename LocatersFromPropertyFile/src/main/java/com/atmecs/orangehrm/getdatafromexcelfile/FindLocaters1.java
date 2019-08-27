package com.atmecs.orangehrm.getdatafromexcelfile;

import java.util.Scanner;

public class FindLocaters1 {
	Scanner scanner = new Scanner(System.in);
	static ProvideData dataProvider = new ProvideData();
	static Object[][] data;
	static ExcelFileOperation d = new ExcelFileOperation();

	public static String getLocater(String element) {
		int noOfRows = d.getNoOfRows();
		int noOfColumns = d.getNoOfColumns();
		data = new Object[noOfRows][noOfColumns];
		data = dataProvider.provideData();
		String data1 = null;

		saurabh: for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				if (data[i][j].toString().equalsIgnoreCase(element)) {
//					System.out.println(data[i][j + 1]);
					String[] arrOfStr = ((String) data[i][j + 1]).split(":", 2);
					data1 = arrOfStr[1];
					break saurabh;
				}
			}
		}
		return data1;
	}
}
