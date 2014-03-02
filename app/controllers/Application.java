package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import services.ICreateAccountService;
import services.ILoginService;

import com.google.inject.Inject;

import views.html.login;
import views.html.createAccount;

// TODO create a com.khabat... package
// TODO try @import in scala.html

public class Application extends Controller {

	@Inject
	private ILoginService loginService;

	@Inject
	private ICreateAccountService createAccountService;
	
	@Security.Authenticated(Secured.class)
	public static Result index() {
		return redirect(routes.Tables.index());
	}

	public Result login() {
		return ok(login.render(loginService.getForm()));
	}

	public Result createAccount() {
		return ok(createAccount.render(createAccountService.getForm()));
	}

	public Result authenticate() {
		if(loginService.authenticate()) {
			session().clear();
			session("email", loginService.getFilledForm().get().getEmail());
			return redirect(routes.Application.index());
		} else {
			return badRequest(login.render(loginService.getFilledForm()));
		}
	}

	public Result submitAccount() {
		if (createAccountService.submitAccount()) {
			session().clear();
			session("email", createAccountService.getFilledForm().get().getEmail());
			return redirect(routes.Application.index());
		} else {
			return badRequest(createAccount.render(createAccountService.getFilledForm()));
		}
	}


}
