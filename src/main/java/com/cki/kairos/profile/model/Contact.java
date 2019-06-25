package com.cki.kairos.profile.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Contact")
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_Id")
	private long contactId;

	@Column(name = "label")
	private String label;

	@Column(name = "contact_info")
	private String contactInfo;

	@ManyToOne
    @JoinColumn(name="profile_Id")
	@JsonBackReference
	private Profile profile;
	
	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", label=" + label + ", contactInfo=" + contactInfo + ", profile="
				+ profile + "]";
	}
	
	public static class ContactBuilder {
		
		private long contactId;
		private String label;
		private String contactInfo;
		private Profile profile;
		
		public ContactBuilder setContactId(long contactId) {
			this.contactId = contactId;
			return this;
		}

		public ContactBuilder setLabel(String label) {
			this.label = label;
			return this;
		}

		public ContactBuilder setContactInfo(String contactInfo) {
			this.contactInfo = contactInfo;
			return this;
		}
		
		public ContactBuilder setProfile(Profile profile) {
			this.profile = profile;
			return this;
		}
		
		public Contact build() {

			Contact contact = new Contact();
			
			contact.setContactId(contactId);
			contact.setLabel(label);
			contact.setContactInfo(contactInfo);
			contact.setProfile(profile);
			
			return contact;
		}
		
	}
	
}
