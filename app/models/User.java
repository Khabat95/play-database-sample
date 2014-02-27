package models;

import javax.persistence.*;

import play.db.ebean.*;

@Entity
public class User extends Model {

	@Id
	private String email;
	private String password;

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public static Finder<String, User> find = new Finder<String, User>(
			String.class, User.class);

	public static User authenticate(String email, String password) {
		return find.where().eq("email", email).eq("password", password)
				.findUnique();
	}

	public static User create(String email, String password) {
		if (find.where().eq("email", email).findUnique() == null) {
			User user = new User(email, password);
			user.save();
			return user;
		}
		return null;
	}
}
