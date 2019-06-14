package com.cki.kairos.profile.util;

import com.cki.kairos.profile.dto.UserDto;
import com.cki.kairos.profile.model.Address;
import com.cki.kairos.profile.model.User;

public class UserConvertor {

	/**
	 * 
	 * @param userDto
	 * @return
	 */
	public static User fromDto(UserDto userDto) {
		
		User user = new User.UserBuilder().setUserId(userDto.getUserId()).setFirstName(userDto.getFirstName())
				.setLastName(userDto.getLastName()).setCellPhone(userDto.getCellPhone()).setEmail(userDto.getEmail())
				.setOccupation(userDto.getOccupation())
				.setAddress(userDto.getAddress() != null ?
						new Address.AddressBuilder().setAddressId(userDto.getAddress().getAddressId())
						.setStreet(userDto.getAddress().getStreet())
						.setCity(userDto.getAddress().getCity())
						.setState(userDto.getAddress().getState())
						.setPostalCode(userDto.getAddress().getPostalCode())
						.build() : null
						)
				.build();

		return user;
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	public static UserDto toDto(User user) {

		UserDto userDto = new UserDto.UserDtoBuilder().setUserId(user.getUserId()).setFirstName(user.getFirstName())
				.setLastName(user.getLastName()).setCellPhone(user.getCellPhone()).setEmail(user.getEmail())
				.setOccupation(user.getOccupation()).build();

		return userDto;
	}
}
