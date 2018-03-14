package org.itstep.dao;

import static org.junit.Assert.*;

import org.itstep.model.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountDAOTest {

	Account account;
	AccountDAO accDAO;
	private String firstName;
	private String secondName;
	
	@Before
	public void setDataBeforeTest() {
		firstName = "Alex";
		secondName = "Dzuba";
		AccountDAO accDao = new AccountDAO();
		Account account = new Account(firstName, secondName);
		accDao.save(account);
	}

	@Test
	public void testUpdate() {
		AccountDAO accDao = new AccountDAO();
	/*	System.out.println(firstName + secondName);*/

		assertNotNull(accDao.get(firstName, secondName).getLogin());

		Account updatedAccount = new Account();
		updatedAccount.setFirst_name("Poiuytr");
		updatedAccount.setSecond_name("Zxcvbnm");
		updatedAccount.setLogin("Poiuytr@ukr.net");
		updatedAccount.setPassword("123456789");

		accDao.update(firstName, secondName, updatedAccount);

		assertNull(accDao.get(firstName, secondName).getLogin());

		firstName = updatedAccount.getFirst_name();
		secondName = updatedAccount.getSecond_name();
		System.out.println(firstName + secondName);
		System.out.println(accDao.get(firstName, secondName).getLogin());
		assertEquals(accDao.get(firstName, secondName).getLogin(), "Poiuytr@ukr.net");

	}
	@Test
	public void testSave() {

		AccountDAO accDao = new AccountDAO();

		Account savedAccount = new Account();
		savedAccount.setFirst_name("Alex2");
		savedAccount.setSecond_name("Dzuba2");
		savedAccount.setLogin("alex_dzuob@ukr.net");
		savedAccount.setPassword("7894561230");

		accDao.save(savedAccount);

		assertNull(accDao.get(firstName, secondName).getLogin());

		firstName = savedAccount.getFirst_name();
		secondName = savedAccount.getSecond_name();

		assertEquals(accDao.get(firstName, secondName).getLogin(), "alex_dzuob@ukr.net");

	}


	@Test
public void testDelete() {
	
}
	
	@After
	public void deleteDataAfterTest() {
		AccountDAO accDao = new AccountDAO();
	accDao.delete(firstName, secondName);
	}

}
