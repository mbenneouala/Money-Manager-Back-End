package service.main.java.com.entity;

public class CategoriesEntity {

	// -------- Attributes
	// List<BankingOperationsEntity> listOfOperationsEntity;
	
	Double sumOfOperations;
	
	String category;

	// -------- Constructor	
	public CategoriesEntity(String category, Double sumOfOperations) {
		super();
		this.sumOfOperations = sumOfOperations;
		this.category = category;
	}

	// -------- Setters & Getters

	/**
	 * @return the sumOfOperations
	 */
	public Double getSumOfOperations() {
		return sumOfOperations;
	}

	/**
	 * @param sumOfOperations the sumOfOperations to set
	 */
	public void setSumOfOperations(Double sumOfOperations) {
		this.sumOfOperations = sumOfOperations;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
}
