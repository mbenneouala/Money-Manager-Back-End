package service.main.java.com.entity;

public class BankingOperationsEntity {

	// -------------------------------------------------- attributes -------------------------------------------------------
	
	String bankingOperationLabel;
	Long bankingOperationValue;
	String bankingOperationDate;
	String bankingOperationType;


	// -------------------------------------------------- constructor -------------------------------------------------------

	public BankingOperationsEntity(String pBankingOperationLabel, Long pBankingOperationValue, String pBankingOperationDate, String pBankingOperationType) {
		this.bankingOperationLabel = pBankingOperationLabel;
		this.bankingOperationValue = pBankingOperationValue;
		this.bankingOperationDate = pBankingOperationDate;
		this.bankingOperationType = pBankingOperationType;
	}
	
	// -------------------------------------------------- getters & setters -------------------------------------------------
	
	/**
	 * @return the bankingOperationDate
	 */
	public String getBankingOperationDate() {
		return bankingOperationDate;
	}

	/**
	 * @return the bankingOperationLabel
	 */
	public String getBankingOperationLabel() {
		return bankingOperationLabel;
	}

	/**
	 * @param bankingOperationLabel the bankingOperationLabel to set
	 */
	public void setBankingOperationLabel(String bankingOperationLabel) {
		this.bankingOperationLabel = bankingOperationLabel;
	}

	/**
	 * @return the bankingOperationValue
	 */
	public Long getBankingOperationValue() {
		return bankingOperationValue;
	}

	/**
	 * @param bankingOperationValue the bankingOperationValue to set
	 */
	public void setBankingOperationValue(Long bankingOperationValue) {
		this.bankingOperationValue = bankingOperationValue;
	}

	/**
	 * @param bankingOperationDate the bankingOperationDate to set
	 */
	public void setBankingOperationDate(String bankingOperationDate) {
		this.bankingOperationDate = bankingOperationDate;
	}
	
	/**
	 * @return the bankingOperationType
	 */
	public String getBankingOperationType() {
		return bankingOperationType;
	}

	/**
	 * @param bankingOperationType the bankingOperationType to set
	 */
	public void setBankingOperationType(String bankingOperationType) {
		this.bankingOperationType = bankingOperationType;
	}

	//  ------------------------------------------------------- methods ----------------------------------------------------
	@Override
	public String toString() {
		return this.bankingOperationLabel + " : " + this.bankingOperationValue;
	}
	
}
