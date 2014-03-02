package dto;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

import models.DBPokerTable;
import models.DBPokerTable.TableLimit;
import models.DBPokerTable.TableType;

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

	public DBPokerTable toDBPokerTable() {
		return new DBPokerTable(name, tableType, tableLimit, seatNumber, User.toDBUserList(users));
	}
	
	public static PokerTable fromDBPokerTable(DBPokerTable dbPokerTable) {
		return new PokerTable(dbPokerTable.getName(), dbPokerTable.getTableType(), dbPokerTable.getTableLimit(), dbPokerTable.getSeatNumber(), User.fromDBUserList(dbPokerTable.getUsers()));
	}
	
	private static Function<DBPokerTable, PokerTable> dbToDTOTransformFunction = new Function<DBPokerTable, PokerTable>() {
		@Override
		public PokerTable apply(DBPokerTable dbPokerTable) {
			return fromDBPokerTable(dbPokerTable);
		}
	};
	
	private static Function<PokerTable, DBPokerTable> dtoToDBTransformFunction = new Function<PokerTable, DBPokerTable>() {
		@Override
		public DBPokerTable apply(PokerTable pokerTable) {
			return pokerTable.toDBPokerTable();
		}
	};
	
	public static List<PokerTable> fromDBPokerTableList(List<DBPokerTable> list) {
		return FluentIterable.from(list).transform(dbToDTOTransformFunction).toList();
	}

	public static List<DBPokerTable> toDBPokerTableList(List<PokerTable> list) {
		return FluentIterable.from(list).transform(dtoToDBTransformFunction).toList();
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
	
}
