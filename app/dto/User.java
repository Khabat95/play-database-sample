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
		return new DbUser(email, "");
	}

	public static User fromDbUser(DbUser dbUser) {
		return new User(dbUser.getEmail());
	}

	private static Function<DbUser, User> dbToDtoTransformFunction = new Function<DbUser, User>() {
		@Override
		public User apply(DbUser dbUser) {
			return fromDbUser(dbUser);
		}
	};

	private static Function<User, DbUser> dtoToDbTransformFunction = new Function<User, DbUser>() {
		@Override
		public DbUser apply(User user) {
			return user.toDbUser();
		}
	};

	public static List<User> fromDbUserList(List<DbUser> list) {
		return FluentIterable.from(list).transform(dbToDtoTransformFunction)
				.toList();
	}

	public static List<DbUser> toDbUserList(List<User> list) {
		return FluentIterable.from(list).transform(dtoToDbTransformFunction)
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

}
