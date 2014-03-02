package test.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import models.DBUser;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import play.data.Form;
import services.DefaultLoginService;
import services.ILoginService;
import test.AbstractTest;
import db.DatabaseManager;
import dto.Login;

public class DefaultLoginServiceTest extends AbstractTest {

	@Mock
	Form<Login> form;
	@Mock
	Form<Login> filledForm;
	@Spy
	DatabaseManager dbManager = new DatabaseManager();

	@InjectMocks
	ILoginService loginService = new DefaultLoginService();

	@Test
	public void tryEmptyAuthenticate() {
		Login login = new Login();
		DBUser user = new DBUser();
		when(form.bindFromRequest()).thenReturn(Form.form(Login.class).fill(login));
		assertFalse(loginService.authenticate());
		verify(dbManager).authenticate(user);
		verify(dbManager, times(1)).authenticate(user);
	}
	
	@Test
	public void tryGoodAuthenticate() {
		Login login = new Login("sdubois87@gmail.com", "sdubois87");
		DBUser user = new DBUser("sdubois87@gmail.com", "sdubois87");
		when(form.bindFromRequest()).thenReturn(Form.form(Login.class).fill(login));
		assertTrue(loginService.authenticate());
		verify(dbManager).authenticate(user);
		verify(dbManager, times(1)).authenticate(user);
	}

	@Test
	public void tryWrongAuthenticate() {
		Login login = new Login("sdubois87@gmail.com", "sdubois");
		DBUser user = new DBUser("sdubois87@gmail.com", "sdubois");
		when(form.bindFromRequest()).thenReturn(Form.form(Login.class).fill(login));
		assertFalse(loginService.authenticate());
		verify(dbManager).authenticate(user);
		verify(dbManager, times(1)).authenticate(user);
	}

}
