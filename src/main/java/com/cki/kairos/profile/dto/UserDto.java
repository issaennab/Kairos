package com.cki.kairos.profile.dto;

import com.cki.kairos.profile.model.Address;

public class UserDto {

	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String cellPhone;
	private String occupation;
	private Address address;

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", cellPhone=" + cellPhone + ", occupation=" + occupation + ", address=" + address + "]";
	}


	public static class UserDtoBuilder {

		private int userId;
		private String firstName;
		private String lastName;
		private String email;
		private String cellPhone;
		private String occupation;
		private Address address;

		public UserDtoBuilder setUserId(int userId) {
			this.userId = userId;
			return this;
		}
		
		public UserDtoBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public UserDtoBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserDtoBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public UserDtoBuilder setCellPhone(String cellPhone) {
			this.cellPhone = cellPhone;
			return this;
		}

		public UserDtoBuilder setOccupation(String occupation) {
			this.occupation = occupation;
			return this;
		}

		public UserDtoBuilder setAddress(Address address) {
			this.address = address;
			return this;
		}

		public UserDto build() {

			UserDto userDto = new UserDto();

			userDto.setUserId(userId);
			userDto.setFirstName(firstName);
			userDto.setLastName(lastName);
			userDto.setEmail(email);
			userDto.setCellPhone(cellPhone);
			userDto.setOccupation(occupation);
			userDto.setAddress(address);

			return userDto;
		}
	}

}
