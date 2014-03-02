package test.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import models.DBUser;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

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
	@Mock
	DatabaseManager dbManager;

	@InjectMocks
	ILoginService loginService = new DefaultLoginService();

	@Test
	public void authenticate() {
		when(form.bindFromRequest()).thenReturn(Form.form(Login.class).fill(new Login()));
		assertFalse(loginService.authenticate());
		verify(dbManager).authenticate(new DBUser());
		verify(dbManager, times(1)).authenticate(new DBUser());
	}

}
