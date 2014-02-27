package models;

import java.util.List;

import javax.persistence.*;

import play.db.ebean.*;

@Entity
public class PokerTable extends Model {

	public enum TableType {
		HOLDEM, OMAHA
	}

	public enum TableLimit {
		LIMIT, POT_LIMIT, NO_LIMIT
	}

	@Id
	private String name;
	private TableType tableType;
	private TableLimit tableLimit;
	private Integer seatNumber;

	public PokerTable(String name, TableType tableType, TableLimit tableLimit,
			Integer seatNumber) {
		this.name = name;
		this.tableType = tableType;
		this.tableLimit = tableLimit;
		this.seatNumber = seatNumber;
	}

	public String getName() {
		return name;
	}

	public TableType getTableType() {
		return tableType;
	}

	public TableLimit getTableLimit() {
		return tableLimit;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public static Finder<String, PokerTable> find = new Finder<String, PokerTable>(
			String.class, PokerTable.class);

	public static List<PokerTable> all() {
		return find.all();
	}

	public static PokerTable create(String name, TableType tableType,
			TableLimit tableLimit, Integer seatNumber) {
		if (find.where().eq("name", name).findUnique() == null) {
			PokerTable table = new PokerTable(name, tableType, tableLimit,
					seatNumber);
			table.save();
			return table;
		}
		return null;
	}

	public static void remove(String name) {
		find.ref(name).delete();
	}

	public static PokerTable get(String name) {
		return find.byId(name);
	}

}
