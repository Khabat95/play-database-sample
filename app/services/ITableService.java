package services;

import play.data.Form;
import dto.PokerTable;
import dto.User;

public interface ITableService {
	PokerTable getTable(String name);
	Form<User> getForm();
	Form<User> getFilledForm();
	boolean addUser(String tableName);
	boolean removeUser(String tableName, String email);
}
