package services;

import dto.PokerTable;
import dto.User;
import play.data.Form;

public interface ITableService {
	PokerTable getTable(String name);
	Form<User> getForm();
	Form<User> getFilledForm();
	boolean addUser(String tableName);
	boolean removeUser(String tableName, String email);
}
