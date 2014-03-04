package dto;

import java.util.ArrayList;
import java.util.List;

import models.DbPokerTable;
import models.DbPokerTable.TableLimit;
import models.DbPokerTable.TableType;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

public class PokerTable {

	private String name;
	private TableType tableType;
	private TableLimit tableLimit;
	private Integer seatNumber;
	private List<User> users = new ArrayList<User>();

	public PokerTable() {
	}

	public PokerTable(String name, TableType tableType, TableLimit tableLimit,
			Integer seatNumber, List<User> users) {
		this.name = name;
		this.tableType = tableType;
		this.tableLimit = tableLimit;
		this.seatNumber = seatNumber;
		this.users = users;
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

	public List<User> getUsers() {
		return users;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTableType(TableType tableType) {
		this.tableType = tableType;
	}

	public void setTableLimit(TableLimit tableLimit) {
		this.tableLimit = tableLimit;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String validate() {
		if (name.isEmpty() || tableType == null || tableLimit == null
				|| seatNumber == null) {
			return "All fields are required";
		}
		return null;
	}

	public DbPokerTable toDbPokerTable() {
		return PokerTableToDbPokerTable.INSTANCE.apply(this);
	}

	public static PokerTable fromDbPokerTableWithUsers(DbPokerTable dbPokerTable) {
		return DbPokerTableToPokerTableWithUsers.INSTANCE.apply(dbPokerTable);
	}

	public static PokerTable fromDbPokerTableWithoutUsers(
			DbPokerTable dbPokerTable) {
		return DbPokerTableToPokerTableWithoutUsers.INSTANCE
				.apply(dbPokerTable);
	}

	public static List<PokerTable> fromDbPokerTableListWithUsers(
			List<DbPokerTable> list) {
		return FluentIterable.from(list)
				.transform(DbPokerTableToPokerTableWithUsers.INSTANCE).toList();
	}

	public static List<PokerTable> fromDbPokerTableListWithoutUsers(
			List<DbPokerTable> list) {
		return FluentIterable.from(list)
				.transform(DbPokerTableToPokerTableWithoutUsers.INSTANCE)
				.toList();
	}

	public static List<DbPokerTable> toDbPokerTableList(List<PokerTable> list) {
		return FluentIterable.from(list)
				.transform(PokerTableToDbPokerTable.INSTANCE).toList();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((seatNumber == null) ? 0 : seatNumber.hashCode());
		result = prime * result
				+ ((tableLimit == null) ? 0 : tableLimit.hashCode());
		result = prime * result
				+ ((tableType == null) ? 0 : tableType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PokerTable other = (PokerTable) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (seatNumber == null) {
			if (other.seatNumber != null)
				return false;
		} else if (!seatNumber.equals(other.seatNumber))
			return false;
		if (tableLimit != other.tableLimit)
			return false;
		if (tableType != other.tableType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PokerTable [name=" + name + ", tableType=" + tableType
				+ ", tableLimit=" + tableLimit + ", seatNumber=" + seatNumber
				+ "]";
	}

	private static class DbPokerTableToPokerTableWithUsers implements
			Function<DbPokerTable, PokerTable> {

		public static final DbPokerTableToPokerTableWithUsers INSTANCE = new DbPokerTableToPokerTableWithUsers();

		private DbPokerTableToPokerTableWithUsers() {
			super();
		}

		@Override
		public PokerTable apply(final DbPokerTable dbPokerTable) {
			final PokerTable pokerTable = new PokerTable(
					dbPokerTable.getName(), dbPokerTable.getTableType(),
					dbPokerTable.getTableLimit(), dbPokerTable.getSeatNumber(),
					User.fromDbUserList(dbPokerTable.getUsers()));
			return pokerTable;
		}

	}

	private static class DbPokerTableToPokerTableWithoutUsers implements
			Function<DbPokerTable, PokerTable> {

		public static final DbPokerTableToPokerTableWithoutUsers INSTANCE = new DbPokerTableToPokerTableWithoutUsers();

		private DbPokerTableToPokerTableWithoutUsers() {
			super();
		}

		@Override
		public PokerTable apply(final DbPokerTable dbPokerTable) {
			final PokerTable pokerTable = new PokerTable(
					dbPokerTable.getName(), dbPokerTable.getTableType(),
					dbPokerTable.getTableLimit(), dbPokerTable.getSeatNumber(),
					null);
			return pokerTable;
		}

	}

	private static class PokerTableToDbPokerTable implements
			Function<PokerTable, DbPokerTable> {

		public static final PokerTableToDbPokerTable INSTANCE = new PokerTableToDbPokerTable();

		private PokerTableToDbPokerTable() {
			super();
		}

		@Override
		public DbPokerTable apply(final PokerTable pokerTable) {
			final DbPokerTable dbPokerTable = new DbPokerTable(
					pokerTable.getName(), pokerTable.getTableType(),
					pokerTable.getTableLimit(), pokerTable.getSeatNumber());
			if (pokerTable.getUsers() != null)
				dbPokerTable.setUsers(User.toDbUserList(pokerTable.getUsers()));
			return dbPokerTable;
		}

	}

}
