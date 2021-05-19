package com.cg.fms.controller;
/******************************
 * @author Akash P Galagali
 * Description: This is the rest controller class for Orders. 
 * Created Date: 23 April, 2021 
 * Version : v1.1.0
 *****************************/
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.fms.dto.Orders;
import com.cg.fms.exception.NoDataFoundException;
import com.cg.fms.service.OrderServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/orders")
public class OrdersController {
@Autowired
OrderServiceImpl orderService=new OrderServiceImpl();
public OrderServiceImpl getOrderService() {
	return orderService;
}

public void setOrderService(OrderServiceImpl orderService) {
	this.orderService = orderService;
}
/***********
 * Method      : getAllOrders
 * @return       Response Entity of Object type
 * Description : This method fetches all the orders.
 * @getmapping : Get mapping expects a PathVariable to be passed 
	 *               which is then used to return the entity object 
	 *               that is fetched from the database.
 **********/
@GetMapping(value="/all",produces="application/json")
public ResponseEntity<List<Orders>> getAllOrders(){
	System.out.println("it worked");
	return new ResponseEntity<List<Orders>>(orderService.getAllOrders(),HttpStatus.OK);
}
/***********
 * Method      : getOrder  
 * @param        Id
 * @return       Response Entity of Object type
 * Description : This method fetches the Order based on id.
 * @getmapping : Get mapping expects a PathVariable to be passed 
	 *               which is then used to return the entity object 
	 *               that is fetched from the database.
 **********/
@GetMapping(value="/get/{ordid}",produces="application/json")
public ResponseEntity<Optional<Orders>> getOrder(@PathVariable("ordid")String ordid){
	Optional<Orders> o=null; 
	o=orderService.getOrder(ordid);
	System.out.println(o.toString());
	if(o.isPresent()) {
		return new ResponseEntity<Optional<Orders>>(o,HttpStatus.OK);
	}
	else 
		throw new NoDataFoundException("No Order data found with given Order ID: "+ ordid);
}
/***********
 * Method      : addOrder
 * @param        Order
 * @return       Response Entity of Object type
 * Description : This method adds a new Order.
 * @postmapping: Post mapping requests a body from the user which is then persisted onto the database.
 **********/
@PostMapping(value="/add",consumes="application/json")
public ResponseEntity<HttpStatus> addOrder(@RequestBody Orders odd) {
	orderService.addOrder(odd);
	return new ResponseEntity<HttpStatus>(HttpStatus.OK);
}
/***********
 * Method      : modifyOrder      
 * @param        order
 * @return       Response Entity of Object type
 * Description : This method updates the Order details.
 * @PutMapping annotation  is used for mapping HTTP PUT requests onto specific handler methods.
 **********/
@PutMapping(value="/update/{order_number}",produces="application/json")
public ResponseEntity<Orders> updateScheduler(@PathVariable("order_number")String order_number,@RequestBody Orders orders){
Optional<Orders> l=null;
l=orderService.getOrder(order_number);
l.get().setOrder_number(orders.getOrder_number());
l.get().setDeliveryPlace(orders.getDeliveryPlace());
l.get().setDeliveryDate(orders.getDeliveryDate());
l.get().setQuantity(orders.getQuantity());
l.get().setCustomer_id(orders.getCustomer_id());
l.get().setProductId(orders.getProductId());
l.get().setSchedulerId(orders.getSchedulerId());
final Orders updatedOrder= orderService.updateOrder(orders);
if(l.isPresent()) {
return new ResponseEntity<Orders>(updatedOrder,HttpStatus.OK);
}
else
throw new NoDataFoundException("No Order data found with given ID: "+ order_number);
}
/***********
 * Method      : deleteOrder      
 * @param        Id
 * @return       Response Entity of Object type
 * Description : This method deletes the Order based on id.
 * @deletemapping: @DeleteMapping annotation maps HTTP DELETE requests onto specific handler methods.
 **********/
@DeleteMapping(value="/{ordid}")
public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("ordid")String ordid){
	Optional<Orders> o=null; 
	o=orderService.getOrder(ordid);
	if(o.isPresent()) {
		orderService.deleteOrder(ordid);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	else 
		throw new NoDataFoundException("No Order data found with given Order ID: "+ ordid);
}
}
