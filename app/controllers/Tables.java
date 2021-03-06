package controllers;

import com.google.inject.Inject;

import dto.PokerTable;
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
		return ok(tables.render(tablesService.getTableList(),
				tablesService.getForm()));
	}

	public Result openTable(String name) {
		PokerTable pokerTable = tableService.getTable(name);
		if (pokerTable != null)
			return ok(table.render(pokerTable, tableService.getForm()));
		else
			return notFound("<h1>Table " + name + " not found</h1>").as(
					"text/html");
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

	public Result addUser(String tableName) {
		if (tableService.addUser(tableName)) {
			return redirect(routes.Tables.openTable(tableName));
		} else {
			PokerTable pokerTable = tableService.getTable(tableName);
			if (pokerTable != null)
				return badRequest(table.render(pokerTable,
						tableService.getFilledForm()));
			else
				return notFound("<h1>Table " + tableName + " not found</h1>")
						.as("text/html");
		}
	}

	public Result removeUser(String tableName, String email) {
		tableService.removeUser(tableName, email);
		return redirect(routes.Tables.openTable(tableName));
	}
}
