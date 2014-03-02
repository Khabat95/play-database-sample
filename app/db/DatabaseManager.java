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
		return userFinder.where().eq("email", email).findUnique();
	}

	public int getUserCount() {
		return userFinder.findRowCount();
	}

	public DBPokerTable createPokerTable(DBPokerTable pokerTable) {
		if (pokerTableFinder.where().eq("name", pokerTable.getName())
				.findUnique() == null) {
			pokerTable.save();
			return pokerTable;
		}
		return null;
	}

	public List<DBPokerTable> getAllPokerTables() {
		return pokerTableFinder.all();
	}

	public DBPokerTable getPokerTable(String name) {
		return pokerTableFinder.byId(name);
	}

	public int getPokerTableCount() {
		return pokerTableFinder.findRowCount();
	}

	public boolean removePokerTable(String name) {
		DBPokerTable pokerTable = pokerTableFinder.ref(name);
		if(pokerTable != null) {
			for(DBUser user : pokerTable.getUsers()) {
				user.setPokerTable(null);
				user.update();
			}
			pokerTable.delete();
			return true;
		}
		return false;
	}

	public boolean addUserToPokerTable(DBUser user, DBPokerTable pokerTable) {
		user.setPokerTable(pokerTable);
		user.update();
		return true;
	}

	public boolean removeUserFromPokerTable(DBUser user, DBPokerTable pokerTable) {
		if(user.getPokerTable().equals(pokerTable)) {
			user.setPokerTable(null);
			user.update();
			return true;
		}
		return false;
	}

}
