package dto;

import models.DBPokerTable;
import models.DBPokerTable.TableLimit;
import models.DBPokerTable.TableType;

public class PokerTable {

	private String name;
	private TableType tableType;
	private TableLimit tableLimit;
	private Integer seatNumber;

	
	
	public PokerTable() {
	}

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

	public String validate() {
		if (name.isEmpty() || tableType == null || tableLimit == null
				|| seatNumber == null) {
			return "All fields are required";
		}
		return null;
	}

	public DBPokerTable toDBPokerTable() {
		return new DBPokerTable(name, tableType, tableLimit, seatNumber);
	}
	
	public static PokerTable fromDBPokerTable(DBPokerTable dbPokerTable) {
		return new PokerTable(dbPokerTable.getName(), dbPokerTable.getTableType(), dbPokerTable.getTableLimit(), dbPokerTable.getSeatNumber());
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
