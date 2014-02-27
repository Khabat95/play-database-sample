package controllers;

import models.*;
import models.PokerTable.*;
import play.data.*;
import play.mvc.*;

@Security.Authenticated(Secured.class)
public class Tables extends Controller {

	private static Form<Table> tableForm = Form.form(Table.class);

	public static Result index() {
		return ok(views.html.tables.render(PokerTable.all(), tableForm));
	}

	public static Result openTable(String name) {
		return ok(views.html.table.render(PokerTable.get(name)));
	}

	public static Result newTable() {
		Form<Table> filledForm = tableForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.tables.render(PokerTable.all(),
					filledForm));
		} else {
			return redirect(routes.Tables.index());
		}
	}

	public static Result deleteTable(String name) {
		PokerTable.remove(name);
		return redirect(routes.Tables.index());
	}

	public static class Table {

		public String name;
		public TableType tableType;
		public TableLimit tableLimit;
		public Integer seatNumber;

		public String validate() {
			if (name.isEmpty() || tableType == null || tableLimit == null
					|| seatNumber == null) {
				return "All fields are required";
			} else if (PokerTable.create(name, tableType, tableLimit,
					seatNumber) == null) {
				return "This table name already exists";
			}
			return null;
		}

	}

}
