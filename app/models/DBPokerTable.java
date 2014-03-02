package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

//TODO create a list of users

@Entity
public class DBPokerTable extends Model {

	private static final long serialVersionUID = -4573530942569841844L;

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

	public DBPokerTable() {
	}
	
	public DBPokerTable(String name, TableType tableType, TableLimit tableLimit,
			Integer seatNumber) {
		this.name = name;
		this.tableType = tableType;
		this.tableLimit = tableLimit;
		this.seatNumber = seatNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TableType getTableType() {
		return tableType;
	}

	public void setTableType(TableType tableType) {
		this.tableType = tableType;
	}

	public TableLimit getTableLimit() {
		return tableLimit;
	}

	public void setTableLimit(TableLimit tableLimit) {
		this.tableLimit = tableLimit;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}
	
	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		if (getClass() != obj.getClass())
			return false;
		DBPokerTable other = (DBPokerTable) obj;
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
		return "DBPokerTable [name=" + name + ", tableType=" + tableType
				+ ", tableLimit=" + tableLimit + ", seatNumber=" + seatNumber
				+ "]";
	}
	
}
