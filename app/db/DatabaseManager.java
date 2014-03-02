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
		if (getUser(user.getEmail()) == null) {
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
	
	public List<DbUser> getAllUsers() {
		return userFinder.all();
	}

	public DbPokerTable createPokerTable(DbPokerTable pokerTable) {
		if (getPokerTable(pokerTable.getName()) == null) {
			pokerTable.save();
			return pokerTable;
		}
		return null;
	}

	public List<DbPokerTable> getAllPokerTables() {
		return pokerTableFinder.all();
	}

	public DbPokerTable getPokerTable(String name) {
		return pokerTableFinder.where().eq("name", name).findUnique();
	}

	public int getPokerTableCount() {
		return pokerTableFinder.findRowCount();
	}

	public boolean deletePokerTable(String name) {
		DbPokerTable pokerTable = getPokerTable(name);
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

	public boolean addUserToPokerTable(String userEmail, String pokerTableName) {
		DbPokerTable pokerTable = getPokerTable(pokerTableName);
		DbUser user = getUser(userEmail);
		if(pokerTable != null && user != null) {
			user.setPokerTable(pokerTable);
			user.update();
			return true;
		}
		return false;
	}

	public boolean removeUserFromPokerTable(String userEmail, String pokerTableName) {
		DbPokerTable pokerTable = getPokerTable(pokerTableName);
		DbUser user = getUser(userEmail);
		if(pokerTable != null && user != null) {
			if(user.getPokerTable() != null && pokerTable.equals(user.getPokerTable())) {
				user.setPokerTable(null);
				user.update();
				return true;
			}
		}
		return false;
	}

}
