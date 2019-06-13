package com.cki.Kairos.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "User")
public class User {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_Id")
	private int userId;

	@NotEmpty
	@Column(name = "first_name")
	private String firstName;

	@NotEmpty
	@Column(name = "last_name")
	private String lastName;

	@NotEmpty
	@Column(name = "email")
	private String email;

	@Column(name = "cell")
	private String cellPhone;

	@Column(name = "occupation")
	private String occupation;

	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "address_Id")
	private Address address;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", cellPhone=" + cellPhone + ", occupation=" + occupation + ", address=" + address + "]";
	}

	public static class UserBuilder {

		private int userId;
		private String firstName;
		private String lastName;
		private String email;
		private String cellPhone;
		private String occupation;
		private Address address;

		public UserBuilder setUserId(int userId) {
			this.userId = userId;
			return this;
		}

		public UserBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public UserBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public UserBuilder setCellPhone(String cellPhone) {
			this.cellPhone = cellPhone;
			return this;
		}

		public UserBuilder setOccupation(String occupation) {
			this.occupation = occupation;
			return this;
		}

		public UserBuilder setAddress(Address address) {
			this.address = address;
			return this;
		}

		public User build() {

			User user = new User();

			user.setUserId(userId);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setCellPhone(cellPhone);
			user.setOccupation(occupation);
			user.setAddress(address);

			return user;
		}
	}

}
