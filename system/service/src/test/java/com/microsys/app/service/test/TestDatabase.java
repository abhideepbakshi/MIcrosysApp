package com.microsys.app.service.test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.microsys.app.common.customenum.CustCompEnum;
import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.model.entity.MicAddress;
import com.microsys.app.model.entity.MicCustomer;
import com.microsys.app.model.entity.MicItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
@TransactionConfiguration(defaultRollback=false)
public class TestDatabase {

	@PersistenceContext
	private EntityManager manager;
	
	@Test
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly = false)
	public void testDatabaseCreateItem() {
	
	//	MicItem find = manager.find(MicItem.class, 1);
		//System.out.println(find.getItemDesc());
		
		MicItem micItem = new MicItem();
		micItem.setItemDesc("Hello");
		//micItem.setItemId(1);
		manager.persist(micItem);
	}
	
	@Test
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly = false)
	public void testDatabaseUpdateItem() {
	
		MicItem find = manager.find(MicItem.class, 9);
		System.out.println(find.getItemDesc());
		
		
		find.setItemDesc("Hello1");
		manager.merge(find);
	}
	
	@Test
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly = false)
	public void testDatabaseInsertCustomer() {
	
		MicCustomer micCustomer = new MicCustomer();
		micCustomer.setCompName("Microsys");
		micCustomer.setCustName("Abhideep");
		micCustomer.setContPerson("Sujoy");
		micCustomer.setStatus(RecordStatusEnum.Active);
		//micCustomer.setCustId(20);
		
		MicAddress micAddress = new MicAddress();
		micAddress.setAddrLineOne("7 Kaibartya Para Road");
		micAddress.setType(CustCompEnum.Customer);
		micAddress.setCustomer(micCustomer);
		micAddress.setStatus(RecordStatusEnum.Active);
		micCustomer.setCustAddress(micAddress);
		//micAddress.setAddrId(10);;
		
		MicItem micItem = new MicItem();
		micItem.setItemDesc("Hello");
		//micItem.setItemId(1);
		//manager.persist(micAddress);
		manager.persist(micCustomer);
		System.out.println(micCustomer.getCustId());
		
		
		
		
	}

	@Test
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly = false)
	public void testDatabaseRetrieveCustomer() {
	
		
		MicCustomer find = manager.find(MicCustomer.class,1);
		MicAddress addressList = find.getCustAddress();
		System.out.println(addressList.getAddrLineOne());
		
		
		
	}

	
	
}
