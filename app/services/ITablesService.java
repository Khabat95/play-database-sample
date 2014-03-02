package services;

import java.util.List;

import dto.PokerTable;
import play.data.Form;

public interface ITablesService {
	List<PokerTable> getTableList();
	Form<PokerTable> getForm();
	Form<PokerTable> getFilledForm();
	boolean newTable();
	void deleteTable(String name);
}
