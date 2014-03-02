package services;

import java.util.List;

import dto.PokerTable;
import play.data.Form;
import models.DBPokerTable;

public interface ITablesService {
	List<DBPokerTable> getTableList();
	Form<PokerTable> getForm();
	Form<PokerTable> getFilledForm();
	boolean newTable();
	void deleteTable(String name);
}
