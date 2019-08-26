package com.atmecs.dataprovider;

import java.util.Scanner;

import com.atmecs.locaters.methods.Data;

public class FindLocaters {
	Scanner scanner = new Scanner(System.in);
	static DataProvider dataProvider = new DataProvider();
	static Object[][] data;
	static Data d = new Data();

	public static String getLocater(String element) {
		int noOfRows = d.getNoOfRows();
		int noOfColumns = d.getNoOfColumns();
		data = new Object[noOfRows][noOfColumns];
		data = dataProvider.provideData();
		String data1 = null;

		saurabh: for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				if (data[i][j].toString().equalsIgnoreCase(element)) {
					System.out.println(data[i][j + 1]);
					data1 = data[i][j + 1].toString();
					break saurabh;
				}
			}
		}
		return data1;
	}
}
