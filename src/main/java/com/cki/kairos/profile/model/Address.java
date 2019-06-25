package com.cki.kairos.profile.model;

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
	@Column(name = "address1")
	private String address1;

	@Column(name = "address2")
	private String address2;

	@NotEmpty
	@Column(name = "city")
	private String city;

	@NotEmpty
	@Column(name = "state")
	private String state;

	@NotEmpty
	@Column(name = "postal_code")
	private String postalCode;
	
	@NotEmpty
	@Column(name = "country")
	private String country;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
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
	
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", region=" + state + ", postalCode=" + postalCode + "]";
	}
	
	
	public static class AddressBuilder {

		private int addressId;
		private String address1;
		private String address2;
		private String city;
		private String state;
		private String postalCode;
		private String country;

		public AddressBuilder setAddressId(int addressId) {
			this.addressId = addressId;
			return this;
		}

		public AddressBuilder setAddress1(String address1) {
			this.address1 = address1;
			return this;
		}
		
		public AddressBuilder setAddress2(String address2) {
			this.address2 = address2;
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
		
		public AddressBuilder setCountry(String country) {
			this.country = country;
			return this;
		}

		public Address build() {

			Address address = new Address();
			
			address.setAddressId(addressId);
			address.setAddress1(address1);
			address.setAddress2(address2);
			address.setCity(city);
			address.setState(state);
			address.setPostalCode(postalCode);
			address.setCountry(country);

			return address;
		}

	}

}
