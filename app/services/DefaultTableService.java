package services;

import models.DbPokerTable;
import models.DbUser;
import db.DatabaseManager;
import dto.PokerTable;
import dto.User;
import play.data.Form;

public class DefaultTableService implements ITableService {

	private Form<User> form = Form.form(User.class);
	private Form<User> filledForm;

	private DatabaseManager dbManager = new DatabaseManager();

	@Override
	public PokerTable getTable(String name) {
		return PokerTable.fromDbPokerTableWithUsers(dbManager
				.getPokerTable(name));
	}

	@Override
	public Form<User> getForm() {
		return form;
	}

	@Override
	public Form<User> getFilledForm() {
		return filledForm;
	}

	@Override
	public boolean addUser(String tableName) {
		filledForm = form.bindFromRequest();
		if (!filledForm.hasErrors()) {
			DbUser dbUser = dbManager.getUser(filledForm.get().getEmail());
			if (dbUser == null) {
				filledForm.reject("This user doesn't exist");
			} else {
				DbPokerTable dbPokerTable = dbManager.getPokerTable(tableName);
				if (dbPokerTable.getUsers().contains(dbUser)) {
					filledForm.reject("This user is already on the table");
				} else {
					return dbManager.addUserToPokerTable(dbUser.getEmail(),
							dbPokerTable.getName());
				}
			}
		}
		return !filledForm.hasErrors();
	}

	@Override
	public boolean removeUser(String tableName, String email) {
		return dbManager.removeUserFromPokerTable(email, tableName);
	}

}
