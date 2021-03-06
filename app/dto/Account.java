package dto;

import com.google.common.base.Function;

import models.DbUser;

public class Account {

	private String email;
	private String confirmEmail;
	private String password;
	private String confirmPassword;

	public Account() {
	}

	public Account(String email, String confirmEmail, String password,
			String confirmPassword) {
		this.email = email;
		this.confirmEmail = confirmEmail;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String validate() {
		if (email.isEmpty() || confirmEmail.isEmpty() || password.isEmpty()
				|| confirmPassword.isEmpty()) {
			return "All fields are required";
		} else if (!email.equals(confirmEmail)) {
			return "Emails don't match";
		} else if (!password.equals(confirmPassword)) {
			return "Passwords don't match";
		}
		return null;
	}

	public DbUser toDbUser() {
		return AccountToDbUser.INSTANCE.apply(this);
	}

	public static Account fromDbUser(DbUser dbUser) {
		return DbUserToAccount.INSTANCE.apply(dbUser);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((confirmEmail == null) ? 0 : confirmEmail.hashCode());
		result = prime * result
				+ ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
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
		Account other = (Account) obj;
		if (confirmEmail == null) {
			if (other.confirmEmail != null)
				return false;
		} else if (!confirmEmail.equals(other.confirmEmail))
			return false;
		if (confirmPassword == null) {
			if (other.confirmPassword != null)
				return false;
		} else if (!confirmPassword.equals(other.confirmPassword))
			return false;
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
		return "Account [email=" + email + ", confirmEmail=" + confirmEmail
				+ ", password=" + password + ", confirmPassword="
				+ confirmPassword + "]";
	}

	private static class DbUserToAccount implements Function<DbUser, Account> {

		public static final DbUserToAccount INSTANCE = new DbUserToAccount();

		private DbUserToAccount() {
			super();
		}

		@Override
		public Account apply(final DbUser dbUser) {
			final Account account = new Account(dbUser.getEmail(),
					dbUser.getEmail(), dbUser.getPassword(),
					dbUser.getPassword());
			return account;
		}

	}

	private static class AccountToDbUser implements Function<Account, DbUser> {

		public static final AccountToDbUser INSTANCE = new AccountToDbUser();

		private AccountToDbUser() {
			super();
		}

		@Override
		public DbUser apply(final Account account) {
			final DbUser dbUser = new DbUser(account.getEmail(),
					account.getPassword());
			return dbUser;
		}

	}

}
