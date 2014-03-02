package test.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import services.DefaultTablesService;
import services.ITablesService;
import test.AbstractTest;
import db.DatabaseManager;
import dto.PokerTable;

public class DefaultTablesServiceTest extends AbstractTest {

	@Mock
	DatabaseManager dbManager;

	@InjectMocks
	ITablesService tablesService = new DefaultTablesService();

	@Test
	public void getTableList() {
		// TODO do I need to fix a return value for
		// dbManager.getAllPokerTables() ?
		// when(dbManager.getAllPokerTables()).thenReturn(new
		// ArrayList<DBPokerTable>());
		List<PokerTable> tableList = tablesService.getTableList();
		assertNotNull(tableList);
		verify(dbManager).getAllPokerTables();
		verify(dbManager, times(1)).getAllPokerTables();
	}

}
