package test.dto;

import static org.junit.Assert.*;

import java.util.List;

import models.DbUser;

import org.junit.Test;

import db.DatabaseManager;
import dto.User;
import test.AbstractTest;

public class UserTest extends AbstractTest {

	DatabaseManager dbManager = new DatabaseManager();
	
	@Test
	public void dtoConversion() {
		DbUser dbUser = dbManager.getUser("sdubois87@gmail.com");
		User user = new User("sdubois87@gmail.com");
		assertEquals(user, User.fromDbUser(user.toDbUser()));
		assertEquals(user, User.fromDbUser(dbUser));
		dbUser.setPassword("");
		assertEquals(dbUser, User.fromDbUser(dbUser).toDbUser());
		assertEquals(dbUser, user.toDbUser());
		
		// fromDbUserList
		List<DbUser> dbList = dbManager.getAllUsers();
		List<User> list = User.fromDbUserList(dbList);
		assertEquals(dbList.size(), list.size());
		for(int i=0; i<list.size(); i++) {
			assertEquals(list.get(i), User.fromDbUser(dbList.get(i)));
			dbList.get(i).setPassword("");
			assertEquals(dbList.get(i), list.get(i).toDbUser());
		}
		
		// toDbUserList
		List<DbUser> dbList2 = User.toDbUserList(list);
		assertEquals(dbList.size(), dbList2.size());
		for(int i=0; i<list.size(); i++) {
			assertEquals(dbList.get(i), dbList2.get(i));
		}
	}

}
