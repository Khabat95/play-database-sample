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
	@Spy
	Form<User> filledForm = Form.form(User.class);
	@Spy
	DatabaseManager dbManager = new DatabaseManager();

	@InjectMocks
	ITableService tableService = new DefaultTableService();

	@Test
	public void tryGetTable() {
		// Existent table
		assertNotNull(tableService.getTable("Sydney"));
		verify(dbManager).getPokerTable("Sydney");
		// Inexistent table
		reset(dbManager);
		assertNull(tableService.getTable("Las Vegas"));
		verify(dbManager).getPokerTable("Las Vegas");
	}

	@Test
	public void tryAddUser() {
		// User not on table
		User user = new User("sdubois87@gmail.com");
		when(form.bindFromRequest()).thenReturn(filledForm);
		doReturn(user).when(filledForm).get();
		assertTrue(tableService.addUser("Sydney"));
		verify(dbManager, times(2)).getUser("sdubois87@gmail.com");
		verify(dbManager, times(2)).getPokerTable("Sydney");
		verify(dbManager).addUserToPokerTable("sdubois87@gmail.com", "Sydney");
		verify(filledForm).hasErrors();
		verify(filledForm, times(0)).reject("This user doesn't exist");
		verify(filledForm, times(0)).reject("This user is already on the table");
		// User already on table
		reset(dbManager);
		filledForm = spy(Form.form(User.class));
		user = new User("sdubois87@gmail.com");
		when(form.bindFromRequest()).thenReturn(filledForm);
		doReturn(user).when(filledForm).get();
		assertFalse(tableService.addUser("Sydney"));
		verify(dbManager).getUser("sdubois87@gmail.com");
		verify(dbManager).getPokerTable("Sydney");
		verify(dbManager, times(0)).addUserToPokerTable("sdubois87@gmail.com",
				"Sydney");
		verify(filledForm, times(2)).hasErrors();
		verify(filledForm, times(0)).reject("This user doesn't exist");
		verify(filledForm).reject("This user is already on the table");
		// Inexistent user
		reset(dbManager);
		filledForm = spy(Form.form(User.class));
		user = new User("sdubois86@gmail.com");
		when(form.bindFromRequest()).thenReturn(filledForm);
		doReturn(user).when(filledForm).get();
		assertFalse(tableService.addUser("Sydney"));
		verify(dbManager).getUser("sdubois86@gmail.com");
		verify(dbManager, times(0)).getPokerTable("Sydney");
		verify(dbManager, times(0)).addUserToPokerTable("sdubois86@gmail.com",
				"Sydney");
		verify(filledForm, times(2)).hasErrors();
		verify(filledForm).reject("This user doesn't exist");
		verify(filledForm, times(0)).reject("This user is already on the table");
		// Inexistent table
		reset(dbManager);
		filledForm = spy(Form.form(User.class));
		user = new User("sdubois87@gmail.com");
		when(form.bindFromRequest()).thenReturn(filledForm);
		doReturn(user).when(filledForm).get();
		assertFalse(tableService.addUser("Las Vegas"));
		verify(dbManager).getUser("sdubois87@gmail.com");
		verify(dbManager).getPokerTable("Las Vegas");
		verify(dbManager, times(0)).addUserToPokerTable("sdubois87@gmail.com",
				"Las Vegas");
		verify(filledForm).hasErrors();
		verify(filledForm, times(0)).reject("This user doesn't exist");
		verify(filledForm, times(0)).reject("This user is already on the table");
	}

	@Test
	public void tryRemoveUser() {
		User user = new User("sdubois87@gmail.com");
		when(form.bindFromRequest()).thenReturn(filledForm);
		doReturn(user).when(filledForm).get();
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
