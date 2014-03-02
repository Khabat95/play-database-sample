package services;

import dto.Account;
import play.data.Form;

public interface ICreateAccountService {
	Form<Account> getForm();

	Form<Account> getFilledForm();

	boolean submitAccount();
}
