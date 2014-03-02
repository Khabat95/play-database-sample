package db;

import java.util.List;

import models.DBPokerTable;
import models.DBUser;
import play.db.ebean.Model.Finder;

public class DatabaseManager {

	private Finder<String, DBUser> userFinder = new Finder<String, DBUser>(
			String.class, DBUser.class);

	private Finder<String, DBPokerTable> pokerTableFinder = new Finder<String, DBPokerTable>(
			String.class, DBPokerTable.class);

	public DBUser authenticate(DBUser user) {
		return userFinder.where().eq("email", user.getEmail())
				.eq("password", user.getPassword()).findUnique();
	}

	public DBUser createUser(DBUser user) {
		if (userFinder.where().eq("email", user.getEmail()).findUnique() == null) {
			user.save();
			return user;
		}
		return null;
	}

	public DBUser getUser(String email) {
		return userFinder.where().eq("email", "sdubois86@gmail.com")
				.findUnique();
	}

	public int getUserCount() {
		return userFinder.findRowCount();
	}

	public List<DBPokerTable> getAllPokerTables() {
		return pokerTableFinder.all();
	}

	public DBPokerTable createPokerTable(DBPokerTable pokerTable) {
		if (pokerTableFinder.where().eq("name", pokerTable.getName()).findUnique() == null) {
			pokerTable.save();
			return pokerTable;
		}
		return null;
	}

	public void removePokerTable(String name) {
		pokerTableFinder.ref(name).delete();
	}

	public DBPokerTable getPokerTable(String name) {
		return pokerTableFinder.byId(name);
	}

	public int getPokerTableCount() {
		return pokerTableFinder.findRowCount();
	}

}
