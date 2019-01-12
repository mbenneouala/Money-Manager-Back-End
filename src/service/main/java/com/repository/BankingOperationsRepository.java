package service.main.java.com.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import database.DataBase;
import service.main.java.com.entity.BankingOperationsEntity;
import service.main.java.com.entity.CategoriesEntity;
import ws.main.java.com.constants.StringConst;


public class BankingOperationsRepository {

	//attributes
	private String FILE_NAME="/Users/Mourad/eclipse-workspace/myProject1/data/T_cpte_05031_245289Q_du_31-10-2018_au_29-11-2018.xlsx";
	private Workbook workbook;

	public static List<BankingOperationsEntity> bankingOperationList = new ArrayList<>();
	public boolean isEmpty = false;
	
	private DataBase dataBase;

	// contructor
	public BankingOperationsRepository() {
		
	}

	// merthods
	
	// ------- Method to convert Excel file content into a list of banking operations
	public List<BankingOperationsEntity> convertDataFromExcelToList() {
		if (bankingOperationList.isEmpty()) {
			try {
				FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
				workbook = new XSSFWorkbook(excelFile);
				Sheet dataTypeSheet = workbook.getSheetAt(0);

				for(Row row : dataTypeSheet) {
					Cell date = row.getCell(0);
					Cell amount = row.getCell(1);
					Cell type = row.getCell(2);
					Cell operation = row.getCell(3);

					if (amount.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						if (operation != null) {
							if (operation.getCellType() == Cell.CELL_TYPE_STRING)
							{
								bankingOperationList.add(new BankingOperationsEntity(operation.getStringCellValue(), Math.round(amount.getNumericCellValue()), date.getStringCellValue(), type.getStringCellValue()));
							}					
						}
					}
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println(bankingOperationList.size());
		
		for (int i = 0; i < bankingOperationList.size(); i++) {
			System.out.println(bankingOperationList.get(i).toString());
		}
		
		return bankingOperationList;
	}
	
	// Mothod to categorize banking operations
	public List<CategoriesEntity> categorizeOperations() {
		
		// Get banking ops from excel file
		List<BankingOperationsEntity> bankingOperations = convertDataFromExcelToList();
		List<CategoriesEntity> categories = new ArrayList<>();
		
		
		List<BankingOperationsEntity> uberOperations = new ArrayList<>();
		List<BankingOperationsEntity> amazonOperations = new ArrayList<>();
		List<BankingOperationsEntity> lufthansaOperations = new ArrayList<>();
		List<BankingOperationsEntity> lillydooOperations = new ArrayList<>();
		List<BankingOperationsEntity> lclOperations = new ArrayList<>();
		List<BankingOperationsEntity> deliverooOperations = new ArrayList<>();
		List<BankingOperationsEntity> carrefourOperations = new ArrayList<>();
		List<BankingOperationsEntity> cashOperations = new ArrayList<>();



		Double sumOfUberOperations = 0.00;
		Double sumOfAmazonOperations = 0.00;
		Double sumOfLufthansaOperations = 0.00;
		Double sumOfLillydooOperations = 0.00;
		Double sumOfLclOperations = 0.00;
		Double sumOfDeliverooOperations = 0.00;
		Double sumOfCarrefourOperations = 0.00;
		Double sumOfCashOperations = 0.00;


		// list of categories and categorized ops (category name and sum of ops)
		for (BankingOperationsEntity bankingOp : bankingOperations) {				
			if(bankingOp.getBankingOperationLabel().toLowerCase().contains(StringConst.UBER.toLowerCase())) {
				uberOperations.add(bankingOp);
				sumOfUberOperations += -(bankingOp.getBankingOperationValue());
			}
			if(bankingOp.getBankingOperationLabel().toLowerCase().contains(StringConst.AMAZON.toLowerCase())) {
				amazonOperations.add(bankingOp);
				sumOfAmazonOperations += -(bankingOp.getBankingOperationValue());
				
			}
			if(bankingOp.getBankingOperationLabel().toLowerCase().contains(StringConst.LUFTHANSA.toLowerCase())) {
				lufthansaOperations.add(bankingOp);
				sumOfLufthansaOperations += -(bankingOp.getBankingOperationValue());
				
			}
			if(bankingOp.getBankingOperationLabel().toLowerCase().contains(StringConst.LILLYDOO.toLowerCase())) {
				lillydooOperations.add(bankingOp);
				sumOfLillydooOperations += -(bankingOp.getBankingOperationValue());
				
			}
			if(bankingOp.getBankingOperationLabel().toLowerCase().contains(StringConst.LCL.toLowerCase())) {
				lclOperations.add(bankingOp);
				sumOfLclOperations += -(bankingOp.getBankingOperationValue());
			}
			if(bankingOp.getBankingOperationLabel().toLowerCase().contains(StringConst.DELIVEROO.toLowerCase())) {
				deliverooOperations.add(bankingOp);
				sumOfDeliverooOperations += -(bankingOp.getBankingOperationValue());
			}
			if(bankingOp.getBankingOperationLabel().toLowerCase().contains(StringConst.CARREFOUR.toLowerCase())) {
				carrefourOperations.add(bankingOp);
				sumOfCarrefourOperations += -(bankingOp.getBankingOperationValue());
			}
			if(bankingOp.getBankingOperationLabel().toLowerCase().contains(StringConst.CASH.toLowerCase())) {
				cashOperations.add(bankingOp);
				sumOfCashOperations += -(bankingOp.getBankingOperationValue());
			}
		}
		
		categories.add(new CategoriesEntity(StringConst.UBER, sumOfUberOperations));
		categories.add(new CategoriesEntity(StringConst.AMAZON, sumOfAmazonOperations));
		categories.add(new CategoriesEntity(StringConst.LUFTHANSA, sumOfLufthansaOperations));
		categories.add(new CategoriesEntity(StringConst.LILLYDOO, sumOfLillydooOperations));
		categories.add(new CategoriesEntity(StringConst.LCL, sumOfLclOperations));
		categories.add(new CategoriesEntity(StringConst.DELIVEROO, sumOfDeliverooOperations));
		categories.add(new CategoriesEntity(StringConst.CARREFOUR, sumOfCarrefourOperations));
		categories.add(new CategoriesEntity(StringConst.CASH, -sumOfCashOperations));

		return categories;

	}
	
	// ------- TODO: Database acess examples
	public void dataBaseAccessExample() {
		
		String connectionUrl = "jdbc:mysql://localhost:8889/job_advertisements";
		String username = "root";
		String password = "root";
		
		try {
			// 1. GET databse conenction
			Connection myConn = DriverManager.getConnection(connectionUrl, username, password);
			
			// 2. Create statement
			Statement stmt = myConn.createStatement();
			
			// 3. Execute SQL query
			String sql = "SELECT * FROM ADVERTISEMENTS";
			ResultSet result = stmt.executeQuery(sql);
			
			// 4. Process the result set
			while(result.next()) {
			    String title = result.getString("TITLE");
			    System.out.println(String.format(title));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
