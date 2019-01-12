package service.main.java.com.service;

import java.util.List;

import service.main.java.com.IBankingOperationsService;
import service.main.java.com.entity.BankingOperationsEntity;
import service.main.java.com.entity.CategoriesEntity;
import service.main.java.com.repository.BankingOperationsRepository;

public class BankingOperationsServiceImpl implements IBankingOperationsService{

	// ----- attributes
	BankingOperationsRepository bankingOperationsRepository = new BankingOperationsRepository();
	
	// ----- methods
	
	@Override
	public List<BankingOperationsEntity> convertDataFromExcelToList() {
				
		return bankingOperationsRepository.convertDataFromExcelToList();
	}

	@Override
	public void dataBaseAccessExample() {
		bankingOperationsRepository.dataBaseAccessExample();
	}
	
	public List<CategoriesEntity> getCategories() {
		return bankingOperationsRepository.categorizeOperations();
	}
	

}
