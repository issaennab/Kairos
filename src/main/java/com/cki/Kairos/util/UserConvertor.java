package com.cki.Kairos.util;

import com.cki.Kairos.dto.UserDto;
import com.cki.Kairos.model.Address;
import com.cki.Kairos.model.User;

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
				.setAddress(
						new Address.AddressBuilder().setAddressId(userDto.getAddress().getAddressId())
						.setStreet(userDto.getAddress().getStreet())
						.setCity(userDto.getAddress().getCity())
						.setState(userDto.getAddress().getState())
						.setPostalCode(userDto.getAddress().getPostalCode())
						.build()
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
