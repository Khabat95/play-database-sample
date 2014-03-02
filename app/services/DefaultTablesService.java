package services;

import java.util.List;

import db.DatabaseManager;
import dto.PokerTable;
import play.data.Form;

public class DefaultTablesService implements ITablesService {

	private Form<PokerTable> form = Form.form(PokerTable.class);
	private Form<PokerTable> filledForm;
	
	private DatabaseManager dbManager = new DatabaseManager();

	@Override
	public List<PokerTable> getTableList() {
		return PokerTable.fromDBPokerTableListWithoutUsers(dbManager.getAllPokerTables());
	}

	@Override
	public Form<PokerTable> getForm() {
		return form;
	}

	@Override
	public Form<PokerTable> getFilledForm() {
		return filledForm;
	}

	@Override
	public boolean newTable() {
		filledForm = form.bindFromRequest();
		if (!filledForm.hasErrors()
				&& dbManager.createPokerTable(filledForm.get().toDBPokerTable()) == null) {
			filledForm.reject("This table name already exists");
		}
		return !filledForm.hasErrors();
	}

	@Override
	public boolean deleteTable(String name) {
		return dbManager.removePokerTable(name);
	}

}
