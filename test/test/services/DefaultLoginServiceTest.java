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
	@Spy
	Form<Login> filledForm = Form.form(Login.class);
	@Spy
	DatabaseManager dbManager = new DatabaseManager();

	@InjectMocks
	ILoginService loginService = new DefaultLoginService();

	@Test
	public void tryGoodAuthenticate() {
		Login login = new Login("sdubois87@gmail.com", "sdubois87");
		DbUser user = new DbUser("sdubois87@gmail.com", "sdubois87");
		when(form.bindFromRequest()).thenReturn(filledForm);
		doReturn(login).when(filledForm).get();
		assertTrue(loginService.authenticate());
		verify(dbManager).authenticate(user);
		verify(filledForm, times(2)).hasErrors();
		verify(filledForm, times(0)).reject("Invalid user or password");;
	}

	@Test
	public void tryWrongAuthenticate() {
		Login login = new Login("sdubois87@gmail.com", "sdubois");
		DbUser user = new DbUser("sdubois87@gmail.com", "sdubois");
		when(form.bindFromRequest()).thenReturn(filledForm);
		doReturn(login).when(filledForm).get();
		assertFalse(loginService.authenticate());
		verify(dbManager).authenticate(user);
		verify(filledForm, times(2)).hasErrors();
		verify(filledForm).reject("Invalid user or password");;
	}

}
