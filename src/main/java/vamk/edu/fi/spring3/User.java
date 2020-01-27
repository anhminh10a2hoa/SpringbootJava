package vamk.edu.fi.spring3;

import java.io.Serializable;
import javax.persistence.*;

/*
 * The persistent class for the User database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT p FROM User p")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String phone;
	@ManyToOne 
	@JoinColumn(name = "profile_id", nullable = false) // thông qua khóa ngoại address_id
	private Profile profile;
	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Profile getProfileId() {
		return this.profile;
	}

	public void setProfileId(Profile profile) {
		this.profile = profile;
	}
}