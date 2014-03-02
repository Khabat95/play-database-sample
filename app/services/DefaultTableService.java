package services;

import db.DatabaseManager;
import dto.PokerTable;

public class DefaultTableService implements ITableService {

	private DatabaseManager dbManager = new DatabaseManager();

	@Override
	public PokerTable getTable(String name) {
		return PokerTable.fromDBPokerTable(dbManager.getPokerTable(name));
	}

}
