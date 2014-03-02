package services;

import db.DatabaseManager;
import dto.Account;
import play.data.Form;

public class DefaultCreateAccountService implements ICreateAccountService {

	private Form<Account> form = Form.form(Account.class);
	private Form<Account> filledForm;

	private DatabaseManager dbManager = new DatabaseManager();

	@Override
	public Form<Account> getForm() {
		return form;
	}

	@Override
	public Form<Account> getFilledForm() {
		return filledForm;
	}

	@Override
	public boolean submitAccount() {
		filledForm = form.bindFromRequest();
		if (!filledForm.hasErrors()
				&& dbManager.createUser(filledForm.get().toDbUser()) == null) {
			filledForm.reject("This email is already registered");
		}
		return !filledForm.hasErrors();
	}

}
