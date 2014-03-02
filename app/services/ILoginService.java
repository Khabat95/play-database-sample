package services;

import dto.Login;
import play.data.Form;

public interface ILoginService {
	Form<Login> getForm();

	Form<Login> getFilledForm();

	boolean authenticate();
}
