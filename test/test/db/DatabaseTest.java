package test.db;

import static org.junit.Assert.*;

import java.util.ArrayList;

import models.DbPokerTable;
import models.DbUser;
import models.DbPokerTable.TableLimit;
import models.DbPokerTable.TableType;

import org.junit.Test;

import db.DatabaseManager;
import test.AbstractTest;

public class DatabaseTest extends AbstractTest {

	private DatabaseManager dbManager = new DatabaseManager();

	@Test
	public void tryCreateUser() {
		// User already created
		assertNull(dbManager.createUser(new DbUser("sdubois87@gmail.com",
				"sdubois")));
		// New user
		assertNotNull(dbManager.createUser(new DbUser("sdubois86@gmail.com",
				"sdubois86")));
		DbUser sdubois86 = dbManager.getUser("sdubois86@gmail.com");
		assertNotNull(sdubois86);
		assertEquals("sdubois86", sdubois86.getPassword());
	}

	@Test
	public void tryAuthenticate() {
		// Valid user and password
		assertNotNull(dbManager.authenticate(new DbUser("sdubois87@gmail.com",
				"sdubois87")));
		// Invalid password
		assertNull(dbManager.authenticate(new DbUser("sdubois87@gmail.com",
				"sdubois")));
		// Invalid user
		assertNull(dbManager.authenticate(new DbUser("sdubois87@msn.com",
				"sdubois87")));
	}

	@Test
	public void tryCreatePokerTable() {
		// Table already created
		assertNull(dbManager.createPokerTable(new DbPokerTable("Sydney",
				TableType.OMAHA, TableLimit.LIMIT, 2, new ArrayList<DbUser>())));
		// New table
		assertNotNull(dbManager.createPokerTable(new DbPokerTable("Las Vegas",
				TableType.HOLDEM, TableLimit.NO_LIMIT, 9,
				new ArrayList<DbUser>())));
		DbPokerTable table = dbManager.getPokerTable("Las Vegas");
		assertNotNull(table);
		assertEquals(TableType.HOLDEM, table.getTableType());
		assertEquals(TableLimit.NO_LIMIT, table.getTableLimit());
		assertEquals(9, table.getSeatNumber().intValue());
	}

	@Test
	public void tryDeletePokerTable() {
		// Inexistent table
		assertFalse(dbManager.deletePokerTable("Las Vegas"));
		// Existent table
		assertNotNull(dbManager.getPokerTable("Sydney"));
		assertTrue(dbManager.deletePokerTable("Sydney"));
		assertNull(dbManager.getPokerTable("Sydney"));
	}

	@Test
	public void tryAddUserToPokerTable() {
		// Inexistent table
		assertFalse(dbManager.addUserToPokerTable("sdubois87@gmail.com",
				"Las Vegas"));
		// Inexistent user
		assertFalse(dbManager.addUserToPokerTable("sdubois86@gmail.com",
				"Sydney"));
		// Inexistent user and table
		assertFalse(dbManager.addUserToPokerTable("sdubois86@gmail.com",
				"Las Vegas"));
		// Existent user and table
		assertTrue(dbManager.addUserToPokerTable("sdubois87@gmail.com",
				"Sydney"));
	}

	@Test
	public void tryRemoveUserToPokerTable() {
		// Inexistent table
		assertFalse(dbManager.removeUserFromPokerTable("sdubois87@gmail.com",
				"Las Vegas"));
		// Inexistent user
		assertFalse(dbManager.removeUserFromPokerTable("sdubois86@gmail.com",
				"Sydney"));
		// Inexistent user and table
		assertFalse(dbManager.removeUserFromPokerTable("sdubois86@gmail.com",
				"Las Vegas"));
		// User not on table
		assertFalse(dbManager.removeUserFromPokerTable("sdubois87@gmail.com",
				"Sydney"));
		// User on table
		assertTrue(dbManager
				.addUserToPokerTable("sdubois87@gmail.com", "Paris"));
		assertTrue(dbManager.removeUserFromPokerTable("sdubois87@gmail.com",
				"Paris"));
		// User no more on table
		assertFalse(dbManager.removeUserFromPokerTable("sdubois87@gmail.com",
				"Paris"));
	}

	@Test
	public void globalTest() {
		DbUser user;
		DbPokerTable pokerTabe;

		assertEquals(1, dbManager.getUserCount());
		assertEquals(3, dbManager.getPokerTableCount());

		assertNotNull(dbManager.authenticate(new DbUser("sdubois87@gmail.com",
				"sdubois87")));
		assertNull(dbManager.authenticate(new DbUser("sdubois87@gmail.com",
				"sdubois")));
		assertNull(dbManager.authenticate(new DbUser("sdubois87@msn.com",
				"sdubois87")));

		assertEquals(1, dbManager.getAllUsers().size());

		user = dbManager.getUser("sdubois87@gmail.com");
		assertNotNull(user);
		assertEquals("sdubois87", user.getPassword());

		assertEquals(3, dbManager.getAllPokerTables().size());

		pokerTabe = dbManager.getPokerTable("Sydney");
		assertNotNull(pokerTabe);
		assertEquals(TableType.HOLDEM, pokerTabe.getTableType());
		assertEquals(TableLimit.NO_LIMIT, pokerTabe.getTableLimit());
		assertEquals(10, pokerTabe.getSeatNumber().intValue());

		pokerTabe = dbManager.getPokerTable("Paris");
		assertNotNull(pokerTabe);
		assertEquals(TableType.OMAHA, pokerTabe.getTableType());
		assertEquals(TableLimit.POT_LIMIT, pokerTabe.getTableLimit());
		assertEquals(9, pokerTabe.getSeatNumber().intValue());

		pokerTabe = dbManager.getPokerTable("Warszawa");
		assertNotNull(pokerTabe);
		assertEquals(TableType.OMAHA, pokerTabe.getTableType());
		assertEquals(TableLimit.LIMIT, pokerTabe.getTableLimit());
		assertEquals(6, pokerTabe.getSeatNumber().intValue());
	}

}
