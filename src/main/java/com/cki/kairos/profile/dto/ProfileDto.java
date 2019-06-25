package com.cki.kairos.profile.dto;

import java.util.List;

import com.cki.kairos.profile.model.Address;
import com.cki.kairos.profile.model.Contact;

public class ProfileDto {

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
	
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "ProfileDto [profileId=" + profileId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", cellPhone=" + cellPhone + ", occupation=" + occupation + ", aliasId=" + aliasId
				+ ", profilePicture=" + profilePicture + ", address=" + address + ", contacts=" + contacts + "]";
	}

	public static class ProfileDtoBuilder {

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

		public ProfileDtoBuilder setProfileId(int profileId) {
			this.profileId = profileId;
			return this;
		}
		
		public ProfileDtoBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public ProfileDtoBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public ProfileDtoBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public ProfileDtoBuilder setCellPhone(String cellPhone) {
			this.cellPhone = cellPhone;
			return this;
		}

		public ProfileDtoBuilder setOccupation(String occupation) {
			this.occupation = occupation;
			return this;
		}
		
		public ProfileDtoBuilder setAliasId(int aliasId) {
			this.aliasId = aliasId;
			return this;
		}
		
		public ProfileDtoBuilder setProfilePicture(String profilePicture) {
			this.profilePicture = profilePicture;
			return this;
		}
		
		public ProfileDtoBuilder setAddress(Address address) {
			this.address = address;
			return this;
		}
		
		public ProfileDtoBuilder setContacts(List<Contact> contacts) {
			this.contacts = contacts;
			return this;
		}

		public ProfileDto build() {

			ProfileDto profileDto = new ProfileDto();

			profileDto.setProfileId(profileId);
			profileDto.setFirstName(firstName);
			profileDto.setLastName(lastName);
			profileDto.setEmail(email);
			profileDto.setCellPhone(cellPhone);
			profileDto.setOccupation(occupation);
			profileDto.setAliasId(aliasId);
			profileDto.setProfilePicture(profilePicture);
			profileDto.setAddress(address);
			profileDto.setContacts(contacts);

			return profileDto;
		}
	}

}
