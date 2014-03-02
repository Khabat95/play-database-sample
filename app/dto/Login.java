package dto;

import models.DbUser;

public class Login {

	private String email;
	private String password;
	
	public Login() {
	}
	
	public Login(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String validate() {
		if (email.isEmpty() || password.isEmpty()) {
			return "All fields are required";
		}
		return null;
	}

	public DbUser toDbUser() {
		return new DbUser(email, password);
	}
	
	public static Login fromDbUser(DbUser dbUser) {
		return new Login(dbUser.getEmail(), dbUser.getPassword());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
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
		Login other = (Login) obj;
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
		return "Login [email=" + email + ", password=" + password + "]";
	}
	
}
