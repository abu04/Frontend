package com.cg.fms;
/******************************
 * @author Amit Anveri
 * Description: This is the JUNIT class for Admin  module. 
 * Created Date: 26 April, 2021 
 * Version : v1.1.0
 *****************************/
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.cg.fms.dto.Admin;

import com.cg.fms.service.IAdminServiceImpl;

@SpringBootTest
class AdminTestClass {
	@Autowired
	IAdminServiceImpl adminService;

	@Test
	void testgetAdmin() {
		Admin a = new Admin(100, "Amit", "cypher");
		Admin a1 = adminService.getAdmin(100).get();
		assertEquals(a.getAdminName(), a1.getAdminName());
	}

	@Test
	void testaddAdmin() {
		Admin a = new Admin(105, "Sansa", "stark");
		adminService.addAdmin(a);
		assertEquals(a.getAdminName(),adminService.getAdmin(105).get().getAdminName() );
	}

	@Test
	void testupdateAdmin() {
		Admin a = new Admin(100, "Amit", "stark");
		 adminService.updateAdmin(a);
		assertEquals(a.getAdminName(),adminService.getAdmin(100).get().getAdminName());
	}

	@Test
	void testgetAllAdmins() {
		List<Admin> admins = adminService.getAllAdmins();
		Admin a1 = new Admin(100, "Amit", "stark");
		Admin a2 = new Admin(101, "Anant", "raze");
		Admin a3 = new Admin(102, "Abhay", "jett");
		Admin a4 = new Admin(103, "Grace", "reyna");
		Admin a5 = new Admin(104, "Jayden", "viper");
		Admin a6 = new Admin(105, "Sansa", "stark");
		List<Admin> exp = new ArrayList<Admin>();
		exp.add(a1);
		exp.add(a2);
		exp.add(a3);
		exp.add(a4);
		exp.add(a5);
		exp.add(a6);
		assertArrayEquals(exp.toArray(), admins.toArray());
	}

	@Test
	void testdeleteAdmin() {
		Admin a = new Admin(106, "Virat", "Dhoni");
		adminService.addAdmin(a);
		adminService.deleteAdmin(106);
		assertEquals(Optional.empty(), adminService.getAdmin(106));
	}


}
