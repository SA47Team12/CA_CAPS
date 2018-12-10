package sa47.team12.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the administrator database table.
 * 
 */
@Entity
public class Administrator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="admin_id")
	private int adminId;

	private String address;

	private String email;

	private String firstname;

	private String lastname;

	private String password;

	private String phone;

	public Administrator() {
	}

	public int getAdminId() {
		return this.adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}