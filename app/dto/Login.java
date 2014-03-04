package dto;

import com.google.common.base.Function;

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
		return LoginToDbUser.INSTANCE.apply(this);
	}

	public static Login fromDbUser(DbUser dbUser) {
		return DbUserToLogin.INSTANCE.apply(dbUser);
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

	private static class DbUserToLogin implements Function<DbUser, Login> {

		public static final DbUserToLogin INSTANCE = new DbUserToLogin();

		private DbUserToLogin() {
			super();
		}

		@Override
		public Login apply(final DbUser dbUser) {
			final Login login = new Login(dbUser.getEmail(),
					dbUser.getPassword());
			return login;
		}

	}

	private static class LoginToDbUser implements Function<Login, DbUser> {

		public static final LoginToDbUser INSTANCE = new LoginToDbUser();

		private LoginToDbUser() {
			super();
		}

		@Override
		public DbUser apply(final Login login) {
			final DbUser dbUser = new DbUser(login.getEmail(),
					login.getPassword());
			return dbUser;
		}

	}

}
