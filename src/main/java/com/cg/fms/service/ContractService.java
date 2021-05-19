package com.cg.fms.service;
/******************************
 * @author       Abu Md Faisal
 * Description : This is the Service class for Contract. 
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 *****************************/
import java.util.List;
import java.util.Optional;

import com.cg.fms.dto.Contract;



public interface ContractService {
	public Optional<Contract> getContract(String contractNumber);
	public Contract addContract(Contract contract);
	public Contract updateContract(Contract contract);
	public void deleteContract(String contractNumber);
	public List<Contract> getAllContracts();
}
