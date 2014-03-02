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
	@Mock
	Form<Account> filledForm;
	@Spy
	DatabaseManager dbManager = new DatabaseManager();

	@InjectMocks
	ICreateAccountService createAccountService = new DefaultCreateAccountService();
	
	@Test
	public void tryGoodSubmitAccount() {
		Account account = new Account("sdubois86@gmail.com", "sdubois86@gmail.com", "sdubois86", "sdubois86");
		DbUser user = new DbUser("sdubois86@gmail.com", "sdubois86");
		when(form.bindFromRequest()).thenReturn(Form.form(Account.class).fill(account));
		assertTrue(createAccountService.submitAccount());
		// TODO tests on filledForm
		verify(dbManager).createUser(user);
		verify(dbManager, times(1)).createUser(user);
	}

	@Test
	public void tryWrongSubmitAccount() {
		Account account = new Account("sdubois87@gmail.com", "sdubois87@gmail.com", "sdubois87", "sdubois87");
		DbUser user = new DbUser("sdubois87@gmail.com", "sdubois87");
		when(form.bindFromRequest()).thenReturn(Form.form(Account.class).fill(account));
		assertFalse(createAccountService.submitAccount());
		// TODO tests on filledForm
		verify(dbManager).createUser(user);
		verify(dbManager, times(1)).createUser(user);
	}

}
