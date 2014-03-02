package controllers;

import com.google.inject.Inject;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import services.ITableService;
import services.ITablesService;
import views.html.tables;
import views.html.table;

@Security.Authenticated(Secured.class)
public class Tables extends Controller {

	@Inject
	private ITablesService tablesService;

	@Inject
	private ITableService tableService;
	
	public Result index() {
		return ok(tables.render(tablesService.getTableList(), tablesService.getForm()));
	}

	public Result openTable(String name) {
		return ok(table.render(tableService.getTable(name)));
	}

	public Result newTable() {
		if (tablesService.newTable()) {
			return redirect(routes.Tables.index());
		} else {
			return badRequest(tables.render(tablesService.getTableList(),
					tablesService.getFilledForm()));
		}
	}

	public Result deleteTable(String name) {
		tablesService.deleteTable(name);
		return redirect(routes.Tables.index());
	}

}
