package com.cki.kairos.profile.util;

import java.util.ArrayList;
import java.util.List;

import com.cki.kairos.profile.dto.ProfileDto;
import com.cki.kairos.profile.model.Address;
import com.cki.kairos.profile.model.Contact;
import com.cki.kairos.profile.model.Profile;

public class ProfileConvertor {

	/**
	 * 
	 * @param profileDto
	 * @return
	 */
	public static Profile fromDto(ProfileDto profileDto) {
		
		Profile profile = new Profile.ProfileBuilder().setProfileId(profileDto.getProfileId()).setFirstName(profileDto.getFirstName())
				.setLastName(profileDto.getLastName()).setCellPhone(profileDto.getCellPhone()).setEmail(profileDto.getEmail())
				.setOccupation(profileDto.getOccupation())
				.setAddress(profileDto.getAddress() != null ?
						new Address.AddressBuilder().setAddressId(profileDto.getAddress().getAddressId())
						.setAddress1(profileDto.getAddress().getAddress1())
						.setAddress2(profileDto.getAddress().getAddress2())
						.setCity(profileDto.getAddress().getCity())
						.setState(profileDto.getAddress().getState())
						.setPostalCode(profileDto.getAddress().getPostalCode())
						.setCountry(profileDto.getAddress().getCountry())
						.build() : null
						)
				.build();
		
//		profile.setContacts(getContactsDto(profileDto.getContacts());

		return profile;
	}

	/**
	 * 
	 * @param profile
	 * @return
	 */
	public static ProfileDto toDto(Profile profile) {

		ProfileDto profileDto = new ProfileDto.ProfileDtoBuilder().setProfileId(profile.getProfileId()).setFirstName(profile.getFirstName())
				.setLastName(profile.getLastName()).setCellPhone(profile.getCellPhone()).setEmail(profile.getEmail())
				.setOccupation(profile.getOccupation()).build();

		return profileDto;
	}
	
	public static List<Contact> getContactsDto(List<Contact> contacts) {

		List<Contact> newContacts = new ArrayList<>();
		contacts.stream().forEach((contact) -> {
			Contact newContact = new Contact.ContactBuilder().setContactId(contact.getContactId())
					.setLabel(contact.getLabel()).setContactInfo(contact.getContactInfo()).build();
			newContacts.add(newContact);
		});
		
		System.out.println(newContacts);
		
		return newContacts;
	}
	
}
