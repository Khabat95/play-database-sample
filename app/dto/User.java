package dto;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

import models.DBUser;

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

	public DBUser toDBUser() {
		return new DBUser(email, "");
	}
	
	public static User fromDBUser(DBUser dbUser) {
		return new User(dbUser.getEmail());
	}
	
	private static Function<DBUser, User> dbToDTOTransformFunction = new Function<DBUser, User>() {
		@Override
		public User apply(DBUser dbUser) {
			return fromDBUser(dbUser);
		}
	};
	
	private static Function<User, DBUser> dtoToDBTransformFunction = new Function<User, DBUser>() {
		@Override
		public DBUser apply(User user) {
			return user.toDBUser();
		}
	};
	
	public static List<User> fromDBUserList(List<DBUser> list) {
		return FluentIterable.from(list).transform(dbToDTOTransformFunction).toList();
	}

	public static List<DBUser> toDBUserList(List<User> list) {
		return FluentIterable.from(list).transform(dtoToDBTransformFunction).toList();
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
