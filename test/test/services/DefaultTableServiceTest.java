package test.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import play.data.Form;
import db.DatabaseManager;
import dto.User;
import services.DefaultTableService;
import services.ITableService;
import test.AbstractTest;

public class DefaultTableServiceTest extends AbstractTest {

	@Mock
	Form<User> form;
	@Mock
	Form<User> filledForm;
	@Spy
	DatabaseManager dbManager = new DatabaseManager();

	@InjectMocks
	ITableService tableService = new DefaultTableService();

	@Test
	public void tryGetTable() {
		assertNotNull(tableService.getTable("Sydney"));
		verify(dbManager).getPokerTable("Sydney");
	}

	@Test
	public void tryAddUser() {
		// User not on table
		User user = new User("sdubois87@gmail.com");
		when(form.bindFromRequest()).thenReturn(
				Form.form(User.class).fill(user));
		assertTrue(tableService.addUser("Sydney"));
		verify(dbManager, times(2)).getUser("sdubois87@gmail.com");
		verify(dbManager, times(2)).getPokerTable("Sydney");
		verify(dbManager).addUserToPokerTable("sdubois87@gmail.com", "Sydney");
		// User already on table
		reset(dbManager);
		user = new User("sdubois87@gmail.com");
		when(form.bindFromRequest()).thenReturn(
				Form.form(User.class).fill(user));
		assertFalse(tableService.addUser("Sydney"));
		verify(dbManager).getUser("sdubois87@gmail.com");
		verify(dbManager).getPokerTable("Sydney");
		verify(dbManager, times(0)).addUserToPokerTable("sdubois87@gmail.com",
				"Sydney");
		// Inexistent user
		reset(dbManager);
		user = new User("sdubois86@gmail.com");
		when(form.bindFromRequest()).thenReturn(
				Form.form(User.class).fill(user));
		assertFalse(tableService.addUser("Sydney"));
		verify(dbManager).getUser("sdubois86@gmail.com");
		verify(dbManager, times(0)).getPokerTable("Sydney");
		verify(dbManager, times(0)).addUserToPokerTable("sdubois86@gmail.com",
				"Sydney");
	}

	@Test
	public void tryRemoveUser() {
		User user = new User("sdubois87@gmail.com");
		when(form.bindFromRequest()).thenReturn(
				Form.form(User.class).fill(user));
		assertTrue(tableService.addUser("Sydney"));
		// User on table
		reset(dbManager);
		assertTrue(tableService.removeUser("Sydney", "sdubois87@gmail.com"));
		verify(dbManager).removeUserFromPokerTable("sdubois87@gmail.com",
				"Sydney");
		// User not on table
		reset(dbManager);
		assertFalse(tableService.removeUser("Sydney", "sdubois87@gmail.com"));
		verify(dbManager).removeUserFromPokerTable("sdubois87@gmail.com",
				"Sydney");
	}

}
