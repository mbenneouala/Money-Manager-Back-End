package ws.main.java.com.ws;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.istack.logging.Logger;

import database.ConnectToMySqlDataBase;
import service.main.java.com.entity.BankingOperationsEntity;
import service.main.java.com.entity.CategoriesEntity;
import service.main.java.com.repository.BankingOperationsRepository;
import service.main.java.com.service.BankingOperationsServiceImpl;
import ws.main.java.com.constants.FacadeUrlConst;

/*
 * url http://192.168.1.16:8080/MoneyManager/
 */
@Path(FacadeUrlConst.PATH)
public class BankingOperationsResource {
	
	/*
	 * Declaration of the logger
	 */
	private static Logger logger = Logger.getLogger(BankingOperationsRepository.class);	
	
	@GET
	@Path(FacadeUrlConst.BANKING_OPERATIONS_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBankingOperations() {
		BankingOperationsServiceImpl bankingOperationsServiceImpl = new BankingOperationsServiceImpl();
		
		logger.info("Start method :  convertDataFromExcelToList");

		// dsdsdList<BankingOperationsEntity> bankingOperations = bankingOperationsServiceImpl.convertDataFromExcelToList();
		logger.info("toto");
		logger.info("End method :  convertDataFromExcelToList");
		logger.info("toto");
		// szszszbankingOperatszszionsServiceImpl.dataBaseAccessExample();
		
		return Response
				.ok(bankingOperationsServiceImpl.convertDataFromExcelToList())
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@GET
	@Path(FacadeUrlConst.CATEGORIES_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategories() {
		BankingOperationsServiceImpl bankingOperationsServiceImpl = new BankingOperationsServiceImpl();
		
		logger.info("Start method :  convertDataFromExcelToList");

		List<CategoriesEntity> categories = bankingOperationsServiceImpl.getCategories();
		
		logger.info("End method :  convertDataFromExcelToList");
		
		return Response
				.ok(categories)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
}
