package com.cki.kairos.profile.dto;

public class AddressDto {

	private String street;
	private String city;
	private String state;
	private String postalCode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "AddressDto [street=" + street + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode
				+ "]";
	}

	public static class AddressDtoBuilder {

		private String street;
		private String city;
		private String state;
		private String postalCode;

		public AddressDtoBuilder setStreet(String street) {
			this.street = street;
			return this;
		}

		public AddressDtoBuilder setCity(String city) {
			this.city = city;
			return this;
		}

		public AddressDtoBuilder setState(String state) {
			this.state = state;
			return this;
		}

		public AddressDtoBuilder setPostalcode(String postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		public AddressDto build() {

			AddressDto addressDto = new AddressDto();

			addressDto.setStreet(street);
			addressDto.setCity(city);
			addressDto.setState(state);
			addressDto.setPostalCode(postalCode);

			return addressDto;
		}
	}

}
