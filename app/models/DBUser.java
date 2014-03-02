package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class DBUser extends Model {

	private static final long serialVersionUID = -3426136236097410494L;

	@Id
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@ManyToOne
	private DBPokerTable pokerTable;

	public DBUser() {
	}
	
	public DBUser(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public DBPokerTable getPokerTable() {
		return pokerTable;
	}
	
	public void setPokerTable(DBPokerTable pokerTable) {
		this.pokerTable = pokerTable;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		DBUser other = (DBUser) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DBUser [email=" + email + ", password=" + password + "]";
	}
	
}
