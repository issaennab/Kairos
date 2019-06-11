package com.cki.Kairos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Address")
public class Address {

	@Id
	@Column(name = "address_Id")
	private int addressId;

	@NotEmpty
	@Column(name = "street")
	private String street;

	@NotEmpty
	@Column(name = "city")
	private String city;

	@NotEmpty
	@Column(name = "state")
	private String state;

	@NotEmpty
	@Column(name = "postal_code")
	private String postalCode;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

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

	public static class AddressBuilder {

		private int addressId;
		private String street;
		private String city;
		private String state;
		private String postalCode;

		public AddressBuilder setAddressId(int addressId) {
			this.addressId = addressId;
			return this;
		}

		public AddressBuilder setStreet(String street) {
			this.street = street;
			return this;
		}

		public AddressBuilder setCity(String city) {
			this.city = city;
			return this;
		}

		public AddressBuilder setState(String state) {
			this.state = state;
			return this;
		}

		public AddressBuilder setPostalCode(String postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		public Address build() {

			Address address = new Address();
			address.setAddressId(addressId);
			address.setStreet(street);
			address.setCity(city);
			address.setState(state);
			address.setPostalCode(postalCode);

			return address;
		}

	}

}
