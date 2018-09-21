package com.newtours.demoaur.library;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;



public class Excel_Library {
	 static  int RowM;
     static  int ColumnN;
     static int LastRowValue;
     public static int lastColumNnum;
     
     public static String testDataPath="C:\\Users\\mbijalwa\\workspace\\mercury_newtours_com_DataDriven\\Mercury_Test_Data\\MercuryTestData.xlsx";
     static HashMap<String, String> hm;
     static String excelData ="";
	
	//HSSFWorkbook=Is a class representation of XLS file.
	//XSSFWorkbook= Is a class representation of XLSX file.
	@Test
		public static String readExcelData(String sheet, int row, int column) throws IOException, EncryptedDocumentException, InvalidFormatException
		{
			FileInputStream fis= new FileInputStream(testDataPath);
			Workbook wb= WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheet);
			Row r=sh.getRow(row);
			Cell cl=r.getCell(column);
			int cellType = 0 ;
		
			//String excelData ="";
			try{
			 cellType=cl.getCellType();
				
				
			/*
				RowM=sh.getLastRowNum();
					
				ColumnN=r.getLastCellNum();*/
						
			
				if(cellType==1)// if cell type is 1 :- it means cell contain string value if its 0 it means integer value in that partocular cell.
				{
					excelData=	r.getCell(column).getStringCellValue();
				}
				else if(cellType==0) {
					//excelData=Double.toString(r.getCell(column).getNumericCellValue());
					double x=r.getCell(column).getNumericCellValue();
					int y=(int) x;
					excelData= Integer.toString(y);
					}
				
				else
				{
					excelData="";
				}
			}
			catch(Exception e){
				excelData="";
			}
			
			return excelData;	
		
		}
	
	public static int getLastRow(String sheet, int row) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis= new FileInputStream(testDataPath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		Row r=sh.getRow(row);
		lastColumNnum=r.getLastCellNum();
		LastRowValue=sh.getLastRowNum();
		return lastColumNnum;
	}
	
	public static void setHashMapValue(String sheet) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		int lastColumn=getLastRow(sheet,0);
		hm=new HashMap<String, String>();
		for(int i=0;i<lastColumn;i++)
		{
			String Key=readExcelData(sheet, 0, i);
			String Value=readExcelData(sheet, 1, i);
			hm.put(Key, Value);
			
		}
	}
			
	public static String getKeyvalue(String Key)
	{
		return hm.get(Key);
	}
	//-----------------------------------------**********************------------------------------------------
	//public static void writeExcelData( String sheetName, int LastRowValue, int cellNumber, String dataStatus) throws EncryptedDocumentException, InvalidFormatException, IOException
	public static void writeExcelData( String sheetName, String dataStatus) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		FileInputStream fis= new FileInputStream(testDataPath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row rw= sh.getRow(LastRowValue);
		//Cell cell=rw.createCell(colName);
		Cell cell=rw.createCell(lastColumNnum);
		cell.setCellType(cell.CELL_TYPE_STRING);
		FileOutputStream fOut=new FileOutputStream(testDataPath);
		cell.setCellValue(dataStatus);
		hm=new HashMap<String, String>();
		String Key=readExcelData(sheetName, 0, LastRowValue);
		String Value=readExcelData(sheetName, 1, LastRowValue);
		hm.put(Key, Value);
		wb.write(fOut);
		wb.close();		
	}
	
	/*public static void setKeyvalue(String Key)
	{
		hm.put(Key, Value);
	}*/
}
