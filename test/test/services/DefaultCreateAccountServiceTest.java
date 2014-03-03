package test.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import models.DbUser;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import db.DatabaseManager;
import dto.Account;
import play.data.Form;
import services.DefaultCreateAccountService;
import services.ICreateAccountService;
import test.AbstractTest;

public class DefaultCreateAccountServiceTest extends AbstractTest {

	@Mock
	Form<Account> form;
	@Spy
	Form<Account> filledForm = Form.form(Account.class);
	@Spy
	DatabaseManager dbManager = new DatabaseManager();

	@InjectMocks
	ICreateAccountService createAccountService = new DefaultCreateAccountService();

	@Test
	public void tryGoodSubmitAccount() {
		Account account = new Account("sdubois86@gmail.com",
				"sdubois86@gmail.com", "sdubois86", "sdubois86");
		DbUser user = new DbUser("sdubois86@gmail.com", "sdubois86");
		when(form.bindFromRequest()).thenReturn(filledForm);
		doReturn(account).when(filledForm).get();
		assertTrue(createAccountService.submitAccount());
		verify(dbManager).createUser(user);
		verify(filledForm, times(2)).hasErrors();
		verify(filledForm, times(0)).reject("This email is already registered");
	}

	@Test
	public void tryWrongSubmitAccount() {
		Account account = new Account("sdubois87@gmail.com",
				"sdubois87@gmail.com", "sdubois87", "sdubois87");
		DbUser user = new DbUser("sdubois87@gmail.com", "sdubois87");
		when(form.bindFromRequest()).thenReturn(filledForm);
		doReturn(account).when(filledForm).get();
		assertFalse(createAccountService.submitAccount());
		verify(dbManager).createUser(user);
		verify(filledForm, times(2)).hasErrors();
		verify(filledForm).reject("This email is already registered");
	}

}
