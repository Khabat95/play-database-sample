package test.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import models.DbPokerTable;
import models.DbPokerTable.TableLimit;
import models.DbPokerTable.TableType;
import models.DbUser;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import play.data.Form;
import db.DatabaseManager;
import dto.PokerTable;
import dto.User;
import services.DefaultTablesService;
import services.ITablesService;
import test.AbstractTest;

public class DefaultTablesServiceTest extends AbstractTest {

	@Mock
	Form<PokerTable> form;
	@Spy
	Form<PokerTable> filledForm = Form.form(PokerTable.class);
	@Spy
	DatabaseManager dbManager = new DatabaseManager();

	@InjectMocks
	ITablesService tablesService = new DefaultTablesService();

	@Test
	public void tryGetTableList() {
		List<PokerTable> tableList = tablesService.getTableList();
		assertNotNull(tableList);
		assertEquals(3, tableList.size());
		verify(dbManager).getAllPokerTables();
	}

	@Test
	public void tryNewTable() {
		// Inexistent table
		PokerTable pokerTable = new PokerTable("Las Vegas", TableType.HOLDEM,
				TableLimit.NO_LIMIT, 9, new ArrayList<User>());
		DbPokerTable dbPokerTable = new DbPokerTable("Las Vegas",
				TableType.HOLDEM, TableLimit.NO_LIMIT, 9,
				new ArrayList<DbUser>());
		when(form.bindFromRequest()).thenReturn(filledForm);
		doReturn(pokerTable).when(filledForm).get();
		assertTrue(tablesService.newTable());
		verify(dbManager).createPokerTable(dbPokerTable);
		verify(filledForm, times(2)).hasErrors();
		verify(filledForm, times(0)).reject("This table name already exists");
		// Existent table
		reset(dbManager);
		filledForm = spy(Form.form(PokerTable.class));
		pokerTable = new PokerTable("Sydney", TableType.HOLDEM,
				TableLimit.NO_LIMIT, 9, new ArrayList<User>());
		dbPokerTable = new DbPokerTable("Sydney", TableType.HOLDEM,
				TableLimit.NO_LIMIT, 9, new ArrayList<DbUser>());
		when(form.bindFromRequest()).thenReturn(filledForm);
		doReturn(pokerTable).when(filledForm).get();
		assertFalse(tablesService.newTable());
		verify(dbManager).createPokerTable(dbPokerTable);
		verify(filledForm, times(2)).hasErrors();
		verify(filledForm).reject("This table name already exists");
	}

	@Test
	public void tryDeleteTable() {
		// Existent table
		assertTrue(tablesService.deleteTable("Sydney"));
		verify(dbManager).deletePokerTable("Sydney");
		// Inexistent table
		reset(dbManager);
		assertFalse(tablesService.deleteTable("Las Vegas"));
		verify(dbManager).deletePokerTable("Las Vegas");
	}

}
