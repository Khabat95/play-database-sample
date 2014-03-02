package test.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import models.DbPokerTable;
import models.DbPokerTable.TableLimit;
import models.DbPokerTable.TableType;

import org.junit.Test;

import db.DatabaseManager;
import dto.PokerTable;
import dto.User;
import test.AbstractTest;

public class PokerTableTest extends AbstractTest {

	DatabaseManager dbManager = new DatabaseManager();
	
	@Test
	public void dtoConversion() {
		// Same name, type, limit and seatNumber
		DbPokerTable dbPokerTable = dbManager.getPokerTable("Sydney");
		PokerTable pokerTable = new PokerTable("Sydney", TableType.HOLDEM, TableLimit.NO_LIMIT, 10, new ArrayList<User>());
		assertEquals(pokerTable, PokerTable.fromDbPokerTableWithUsers(dbPokerTable));
		assertEquals(dbPokerTable, pokerTable.toDbPokerTable());
		assertEquals(pokerTable, PokerTable.fromDbPokerTableWithUsers(pokerTable.toDbPokerTable()));
		assertEquals(dbPokerTable, PokerTable.fromDbPokerTableWithUsers(dbPokerTable).toDbPokerTable());
		// Different name
		pokerTable = new PokerTable("Melbourne", TableType.HOLDEM, TableLimit.NO_LIMIT, 10, new ArrayList<User>());
		assertNotEquals(pokerTable, PokerTable.fromDbPokerTableWithUsers(dbPokerTable));
		assertNotEquals(dbPokerTable, pokerTable.toDbPokerTable());
		// Different type
		pokerTable = new PokerTable("Sydney", TableType.OMAHA, TableLimit.NO_LIMIT, 10, new ArrayList<User>());
		assertNotEquals(pokerTable, PokerTable.fromDbPokerTableWithUsers(dbPokerTable));
		assertNotEquals(dbPokerTable, pokerTable.toDbPokerTable());
		// Different limit
		pokerTable = new PokerTable("Sydney", TableType.HOLDEM, TableLimit.POT_LIMIT, 10, new ArrayList<User>());
		assertNotEquals(pokerTable, PokerTable.fromDbPokerTableWithUsers(dbPokerTable));
		assertNotEquals(dbPokerTable, pokerTable.toDbPokerTable());
		// Different seatNumber
		pokerTable = new PokerTable("Sydney", TableType.HOLDEM, TableLimit.NO_LIMIT, 6, new ArrayList<User>());
		assertNotEquals(pokerTable, PokerTable.fromDbPokerTableWithUsers(dbPokerTable));
		assertNotEquals(dbPokerTable, pokerTable.toDbPokerTable());

		// fromDbPokerTableListWithUsers
		List<DbPokerTable> dbList = dbManager.getAllPokerTables();
		List<PokerTable> list = PokerTable.fromDbPokerTableListWithUsers(dbList);
		assertEquals(dbList.size(), list.size());
		for(int i=0; i<list.size(); i++) {
			assertEquals(dbList.get(i), list.get(i).toDbPokerTable());
			assertEquals(list.get(i), PokerTable.fromDbPokerTableWithUsers(dbList.get(i)));
		}

		// fromDbPokerTableListWithoutUsers
		dbList = dbManager.getAllPokerTables();
		list = PokerTable.fromDbPokerTableListWithoutUsers(dbList);
		assertEquals(dbList.size(), list.size());
		for(int i=0; i<list.size(); i++) {
			assertEquals(dbList.get(i), list.get(i).toDbPokerTable());
			assertEquals(list.get(i), PokerTable.fromDbPokerTableWithoutUsers(dbList.get(i)));
		}
		
		// toDbPokerTableList
		dbList = dbManager.getAllPokerTables();
		list = PokerTable.fromDbPokerTableListWithUsers(dbList);
		List<DbPokerTable> dbList2 = PokerTable.toDbPokerTableList(list);
		assertEquals(dbList.size(), dbList2.size());
		for(int i=0; i<list.size(); i++) {
			assertEquals(dbList.get(i), dbList2.get(i));
		}
	}

}
