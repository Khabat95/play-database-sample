package services;

import db.DatabaseManager;
import dto.Login;
import play.data.Form;

public class DefaultLoginService implements ILoginService {

	private Form<Login> form = Form.form(Login.class);
	private Form<Login> filledForm;

	private DatabaseManager dbManager = new DatabaseManager();

	@Override
	public Form<Login> getForm() {
		return form;
	}

	@Override
	public Form<Login> getFilledForm() {
		return filledForm;
	}

	@Override
	public boolean authenticate() {
		filledForm = form.bindFromRequest();
		if (!filledForm.hasErrors()
				&& dbManager.authenticate(filledForm.get().toDBUser()) == null) {
			System.out.println("3");
			filledForm.reject("Invalid user or password");;
		}
		return !filledForm.hasErrors();
	}

}
