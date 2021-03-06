package com.atmecs.dataprovider;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.atmecs.locaters.methods.Data;

public class DataProvider {

	Object[][] object;
	Data provider;

	public DataProvider() {
		provider = new Data();
	}

	@org.testng.annotations.DataProvider(name = "data-provider")
	public Object[][] provideData() {

		Iterator<Row> rows = null;
		try {
			rows = provider.getData();

			int noOfRows = provider.getNoOfRows();
			System.out.println(noOfRows);
			int noOfColumns = provider.getNoOfColumns();
			System.out.println(noOfColumns);
			object = new Object[noOfRows][noOfColumns];

		} catch (IOException e) {
			System.out.println("Exception");
		}
		int i = 0;
		while (rows.hasNext()) {
			Row row = rows.next();
			Iterator<Cell> iterator = row.cellIterator();
			int j = 0;
			while (iterator.hasNext()) {
				Cell cell = iterator.next();
				object[i][j] = cell.toString();
				j++;
			}
			i++;
		}
		return object;
	}
}
