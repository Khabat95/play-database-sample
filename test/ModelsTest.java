import java.util.List;

import static org.junit.Assert.*;

import models.DBPokerTable;
import models.DBPokerTable.TableLimit;
import models.DBPokerTable.TableType;
import models.DBUser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.avaje.ebean.Ebean;

import db.DatabaseManager;
import play.libs.Yaml;
import play.test.FakeApplication;
import play.test.Helpers;

public class ModelsTest {

	private FakeApplication app;

	private DatabaseManager dbManager = new DatabaseManager();

	@Before
	public void setUp() {
		this.app = Helpers.fakeApplication(Helpers.inMemoryDatabase());
		Helpers.start(this.app);
		Ebean.save((List<?>) Yaml.load("test-data.yml"));
	}

	@After
	public void tearDown() {
		Helpers.stop(this.app);
	}

	@Test
	public void createAndRetrieveDBUser() {
		dbManager.createUser(new DBUser("sdubois86@gmail.com", "sdubois86"));
		DBUser sdubois = dbManager.getUser("sdubois86@gmail.com");
		assertNotNull(sdubois);
		assertEquals("sdubois86", sdubois.getPassword());
	}

	@Test
	public void tryAuthenticate() {
		assertNotNull(dbManager.authenticate(new DBUser("sdubois87@gmail.com",
				"sdubois87")));
		assertNull(dbManager.authenticate(new DBUser("sdubois87@gmail.com",
				"sdubois")));
		assertNull(dbManager.authenticate(new DBUser("sdubois87@msn.com",
				"sdubois87")));
	}

	@Test
	public void createAndRetrieveDBPokerTable() {
		dbManager.createPokerTable(new DBPokerTable("Las Vegas",
				TableType.HOLDEM, TableLimit.NO_LIMIT, 9));
		DBPokerTable table = dbManager.getPokerTable("Las Vegas");
		assertNotNull(table);
		assertEquals(TableType.HOLDEM, table.getTableType());
		assertEquals(TableLimit.NO_LIMIT, table.getTableLimit());
		assertEquals(9, table.getSeatNumber().intValue());
	}

	@Test
	public void deleteTable() {
		assertNotNull(dbManager.getPokerTable("Sydney"));
		dbManager.removePokerTable("Sydney");
		assertNull(dbManager.getPokerTable("Sydney"));
	}

	@Test
	public void globalTest() {
		DBPokerTable pokerTabe;

		assertEquals(1, dbManager.getUserCount());
		assertEquals(3, dbManager.getPokerTableCount());

		assertNotNull(dbManager.authenticate(new DBUser("sdubois87@gmail.com",
				"sdubois87")));
		assertNull(dbManager.authenticate(new DBUser("sdubois87@gmail.com",
				"sdubois")));
		assertNull(dbManager.authenticate(new DBUser("sdubois87@msn.com",
				"sdubois87")));

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
