package test.dto;

import static org.junit.Assert.*;
import models.DbUser;

import org.junit.Test;

import db.DatabaseManager;
import dto.Account;
import test.AbstractTest;

public class AccountTest extends AbstractTest {

	DatabaseManager dbManager = new DatabaseManager();

	@Test
	public void dtoConversion() {
		// Same email and password
		DbUser dbUser = dbManager.getUser("sdubois87@gmail.com");
		Account account = new Account("sdubois87@gmail.com",
				"sdubois87@gmail.com", "sdubois87", "sdubois87");
		assertEquals(account, Account.fromDbUser(dbUser));
		assertEquals(dbUser, account.toDbUser());
		assertEquals(account, Account.fromDbUser(account.toDbUser()));
		assertEquals(dbUser, Account.fromDbUser(dbUser).toDbUser());
		// Different email
		account = new Account("sdubois86@gmail.com", "sdubois86@gmail.com",
				"sdubois87", "sdubois87");
		assertNotEquals(account, Account.fromDbUser(dbUser));
		assertNotEquals(dbUser, account.toDbUser());
		// Different password
		account = new Account("sdubois87@gmail.com", "sdubois87@gmail.com",
				"sdubois86", "sdubois86");
		assertNotEquals(account, Account.fromDbUser(dbUser));
		assertNotEquals(dbUser, account.toDbUser());
		// Different email and password
		account = new Account("sdubois86@gmail.com", "sdubois86@gmail.com",
				"sdubois86", "sdubois86");
		assertNotEquals(account, Account.fromDbUser(dbUser));
		assertNotEquals(dbUser, account.toDbUser());
	}

}
