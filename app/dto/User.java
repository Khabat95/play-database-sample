package dto;

import java.util.List;

import models.DbUser;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

public class User {

	private String email;

	public User() {
	}

	public User(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String validate() {
		if (email.isEmpty()) {
			return "All fields are required";
		}
		return null;
	}

	public DbUser toDbUser() {
		return UserToDbUser.INSTANCE.apply(this);
	}

	public static User fromDbUser(DbUser dbUser) {
		return DbUserToUser.INSTANCE.apply(dbUser);
	}

	public static List<User> fromDbUserList(List<DbUser> list) {
		return FluentIterable.from(list).transform(DbUserToUser.INSTANCE)
				.toList();
	}

	public static List<DbUser> toDbUserList(List<User> list) {
		return FluentIterable.from(list).transform(UserToDbUser.INSTANCE)
				.toList();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [email=" + email + "]";
	}

	private static class DbUserToUser implements Function<DbUser, User> {

		public static final DbUserToUser INSTANCE = new DbUserToUser();

		private DbUserToUser() {
			super();
		}

		@Override
		public User apply(final DbUser dbUser) {
			final User user = new User(dbUser.getEmail());
			return user;
		}

	}

	private static class UserToDbUser implements Function<User, DbUser> {

		public static final UserToDbUser INSTANCE = new UserToDbUser();

		private UserToDbUser() {
			super();
		}

		@Override
		public DbUser apply(final User user) {
			final DbUser dbUser = new DbUser(user.getEmail(), "");
			return dbUser;
		}

	}

}
