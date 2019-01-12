package service.main.java.com;

import java.util.List;

import service.main.java.com.entity.BankingOperationsEntity;
import service.main.java.com.entity.CategoriesEntity;

public interface IBankingOperationsService {

	public List<BankingOperationsEntity> convertDataFromExcelToList();
	
	public void dataBaseAccessExample();
	
	public List<CategoriesEntity> getCategories();
	
}
