package controllers;

import models.User;
import play.data.*;
import play.mvc.*;

public class Application extends Controller {

	private static Form<Login> loginForm = Form.form(Login.class);
	private static Form<Account> accountForm = Form.form(Account.class);

	@Security.Authenticated(Secured.class)
	public static Result index() {
		return redirect(routes.Tables.index());
	}

	public static Result login() {
		return ok(views.html.login.render(loginForm));
	}

	public static Result createAccount() {
		return ok(views.html.createAccount.render(accountForm));
	}

	public static Result authenticate() {
		Form<Login> filledForm = loginForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.login.render(filledForm));
		} else {
			session().clear();
			session("email", filledForm.get().email);
			return redirect(routes.Application.index());
		}
	}

	public static Result submitAccount() {
		Form<Account> filledForm = accountForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.createAccount.render(filledForm));
		} else {
			session().clear();
			session("email", filledForm.get().email);
			return redirect(routes.Application.index());
		}
	}

	public static class Login {

		public String email;
		public String password;

		public String validate() {
			if (User.authenticate(email, password) == null) {
				return "Invalid user or password";
			}
			return null;
		}
	}

	public static class Account {

		public String email;
		public String confirmEmail;
		public String password;
		public String confirmPassword;

		public String validate() {
			if (email.isEmpty() || confirmEmail.isEmpty() || password.isEmpty()
					|| confirmPassword.isEmpty()) {
				return "All fields are required";
			} else if (!email.equals(confirmEmail)) {
				return "Emails doesn't match";
			} else if (!password.equals(confirmPassword)) {
				return "Passwords doesn't match";
			} else if (User.create(email, password) == null) {
				return "This email is already registered";
			}
			return null;
		}
	}

}
