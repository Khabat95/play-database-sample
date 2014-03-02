package db;

import java.util.List;

import models.DbPokerTable;
import models.DbUser;
import play.db.ebean.Model.Finder;

public class DatabaseManager {

	private Finder<String, DbUser> userFinder = new Finder<String, DbUser>(
			String.class, DbUser.class);

	private Finder<String, DbPokerTable> pokerTableFinder = new Finder<String, DbPokerTable>(
			String.class, DbPokerTable.class);

	public DbUser authenticate(DbUser user) {
		return userFinder.where().eq("email", user.getEmail())
				.eq("password", user.getPassword()).findUnique();
	}

	public DbUser createUser(DbUser user) {
		if (userFinder.where().eq("email", user.getEmail()).findUnique() == null) {
			user.save();
			return user;
		}
		return null;
	}

	public DbUser getUser(String email) {
		return userFinder.where().eq("email", email).findUnique();
	}

	public int getUserCount() {
		return userFinder.findRowCount();
	}

	public DbPokerTable createPokerTable(DbPokerTable pokerTable) {
		if (pokerTableFinder.where().eq("name", pokerTable.getName())
				.findUnique() == null) {
			pokerTable.save();
			return pokerTable;
		}
		return null;
	}

	public List<DbPokerTable> getAllPokerTables() {
		return pokerTableFinder.all();
	}

	public DbPokerTable getPokerTable(String name) {
		return pokerTableFinder.byId(name);
	}

	public int getPokerTableCount() {
		return pokerTableFinder.findRowCount();
	}

	public boolean removePokerTable(String name) {
		DbPokerTable pokerTable = pokerTableFinder.ref(name);
		if(pokerTable != null) {
			for(DbUser user : pokerTable.getUsers()) {
				user.setPokerTable(null);
				user.update();
			}
			pokerTable.delete();
			return true;
		}
		return false;
	}

	public boolean addUserToPokerTable(DbUser user, DbPokerTable pokerTable) {
		user.setPokerTable(pokerTable);
		user.update();
		return true;
	}

	public boolean removeUserFromPokerTable(DbUser user, DbPokerTable pokerTable) {
		if(user.getPokerTable().equals(pokerTable)) {
			user.setPokerTable(null);
			user.update();
			return true;
		}
		return false;
	}

}
