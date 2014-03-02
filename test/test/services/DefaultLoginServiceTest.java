package test.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import models.DbUser;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import db.DatabaseManager;
import dto.Login;
import play.data.Form;
import services.DefaultLoginService;
import services.ILoginService;
import test.AbstractTest;

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
	public void tryGoodAuthenticate() {
		Login login = new Login("sdubois87@gmail.com", "sdubois87");
		DbUser user = new DbUser("sdubois87@gmail.com", "sdubois87");
		when(form.bindFromRequest()).thenReturn(Form.form(Login.class).fill(login));
		assertTrue(loginService.authenticate());
		// TODO tests on filledForm
		verify(dbManager).authenticate(user);
		verify(dbManager, times(1)).authenticate(user);
	}

	@Test
	public void tryWrongAuthenticate() {
		Login login = new Login("sdubois87@gmail.com", "sdubois");
		DbUser user = new DbUser("sdubois87@gmail.com", "sdubois");
		when(form.bindFromRequest()).thenReturn(Form.form(Login.class).fill(login));
		assertFalse(loginService.authenticate());
		// TODO tests on filledForm
		verify(dbManager).authenticate(user);
		verify(dbManager, times(1)).authenticate(user);
	}

}
