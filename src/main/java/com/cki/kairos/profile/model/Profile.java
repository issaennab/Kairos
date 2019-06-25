package com.cki.kairos.profile.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Profile")
public class Profile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "profile_Id")
	private int profileId;

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
	
	@Column(name = "alias_Id")
	private int aliasId;
	
	@Column(name = "profile_picture")
	private String profilePicture;
	
	@ManyToOne
    @JoinColumn(name="user_Id")
	@JsonBackReference
	private User user;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "address_Id", nullable = true)
	private Address address;	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "profile_Id", referencedColumnName = "profile_Id")
	private List<Contact> contacts;

	
	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public int getAliasId() {
		return aliasId;
	}

	public void setAliasId(int aliasId) {
		this.aliasId = aliasId;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
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

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", cellPhone=" + cellPhone + ", occupation=" + occupation + ", aliasId=" + aliasId
				+ ", profilePicture=" + profilePicture + ", user=" + user + ", address=" + address + ", contacts="
				+ contacts + "]";
	}

	public static class ProfileBuilder {

		private int profileId;
		private String firstName;
		private String lastName;
		private String email;
		private String cellPhone;
		private String occupation;
		private int aliasId;
		private String profilePicture;
		private Address address;
		private List<Contact> contacts;

		public ProfileBuilder setProfileId(int profileId) {
			this.profileId = profileId;
			return this;
		}

		public ProfileBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public ProfileBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public ProfileBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public ProfileBuilder setCellPhone(String cellPhone) {
			this.cellPhone = cellPhone;
			return this;
		}

		public ProfileBuilder setOccupation(String occupation) {
			this.occupation = occupation;
			return this;
		}
		
		public ProfileBuilder setAliasId(int aliasId) {
			this.aliasId = aliasId;
			return this;
		}
		
		public ProfileBuilder setProfilePicture(String profilePicture) {
			this.profilePicture = profilePicture;
			return this;
		}
		
		public ProfileBuilder setAddress(Address address) {
			this.address = address;
			return this;
		}

		public ProfileBuilder setContacts(List<Contact> contacts) {
			this.contacts = contacts;
			return this;
		}
		
		
		public Profile build() {

			Profile profile = new Profile();

			profile.setProfileId(profileId);
			profile.setFirstName(firstName);
			profile.setLastName(lastName);
			profile.setEmail(email);
			profile.setCellPhone(cellPhone);
			profile.setOccupation(occupation);
			profile.setAliasId(aliasId);
			profile.setProfilePicture(profilePicture);
			profile.setAddress(address);
			profile.setContacts(contacts);

			return profile;
		}
	}

}
