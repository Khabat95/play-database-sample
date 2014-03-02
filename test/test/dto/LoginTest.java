package test.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import models.DbUser;

import org.junit.Test;

import db.DatabaseManager;
import dto.Login;
import test.AbstractTest;

public class LoginTest extends AbstractTest {

	DatabaseManager dbManager = new DatabaseManager();
	
	@Test
	public void dtoConversion() {
		// Same email and password
		DbUser dbUser = dbManager.getUser("sdubois87@gmail.com");
		Login login = new Login("sdubois87@gmail.com", "sdubois87");
		assertEquals(login, Login.fromDbUser(dbUser));
		assertEquals(dbUser, login.toDbUser());
		assertEquals(login, Login.fromDbUser(login.toDbUser()));
		assertEquals(dbUser, Login.fromDbUser(dbUser).toDbUser());
		// Different email
		login = new Login("sdubois86@gmail.com", "sdubois87");
		assertNotEquals(login, Login.fromDbUser(dbUser));
		assertNotEquals(dbUser, login.toDbUser());
		// Different password
		login = new Login("sdubois87@gmail.com", "sdubois86");
		assertNotEquals(login, Login.fromDbUser(dbUser));
		assertNotEquals(dbUser, login.toDbUser());
		// Different email and password
		login = new Login("sdubois86@gmail.com", "sdubois86");
		assertNotEquals(login, Login.fromDbUser(dbUser));
		assertNotEquals(dbUser, login.toDbUser());
	}

}
