package com.cg.fms.service;
/******************************
 * @author       Abu Md Faisal
 * Description : This is the Service Implementation class for Contract. 
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 *****************************/
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.ContractDao;
import com.cg.fms.dto.Contract;


@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	ContractDao cdao;
	@Override
	public Optional<Contract> getContract(String contractNumber) {
		return cdao.findById(contractNumber);
	}

	@Override
	public Contract addContract(Contract contract) {
		cdao.save(contract);
		return null;
	}

	@Override
	public Contract updateContract(Contract contract) {
		cdao.save(contract);
		return null;
	}

	@Override
	public void deleteContract(String contractNumber) {
		cdao.deleteById(contractNumber);
		
	}

	@Override
	public List<Contract> getAllContracts() {

		return cdao.findAll();
	}

}
