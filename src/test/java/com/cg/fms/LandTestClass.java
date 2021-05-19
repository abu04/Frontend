package com.cg.fms;
/******************************
 * @author       Abu Md Faisal
 * Description : This is the Junit Test class for Land Module. 
 * Created Date: 26 April, 2021 
 * Version     : v1.1.0
 *****************************/
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fms.dao.ILandDao;
import com.cg.fms.dto.Land;
import com.cg.fms.service.LandServiceImpl;


@SpringBootTest
class LandTestClass {
	
	@Autowired
	LandServiceImpl lser;
	@Autowired
	ILandDao ldao;
	@Test
	void testGetLandById() {
		Land l= new Land(101,"L101","RAGHAV","BENGALURU");
		Land l2=lser.getLand("L101").get();
		assertEquals(l.getOwnerName(),l2.getOwnerName());
	}
	
	@Test
	void testAddLand() {
		Land l= new Land(105,"L105","Anmol","Mysore");
		lser.addLand(l);
		assertEquals(l.getOwnerName(),lser.getLand("L105").get().getOwnerName());
	}
	
	@Test 
	void testUpdateLand() {
		Land l= new Land(105,"L105","ANMOL","Mysore");
		lser.updateLand(l);
		assertEquals(l.getOwnerName(),lser.getLand("L105").get().getOwnerName());

	}
	
	@Test
	void testDeleteLand() {
		
		lser.removeLandDetails("L105");
		assertEquals(Optional.empty(),lser.getLand("L105"));
	}
	@Test
	void testGetAllLands() {
		
		List<Land> la= lser.getAllLands();
		List<Land> ela= new ArrayList<Land>();
		
		ela.addAll(ldao.findAll());
		
		assertArrayEquals(ela.toArray(),la.toArray());

	}
	
}
