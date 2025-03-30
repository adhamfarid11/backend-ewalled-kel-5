package com.odp.walled.config;

import com.odp.walled.dto.UserRequest;
import com.odp.walled.service.UserService;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DataLoader implements ApplicationRunner {

	private final UserService userService;

	@Autowired
	public DataLoader(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void run(ApplicationArguments args) {
		List<UserRequest> userRequests = Arrays.asList(
				UserRequest.builder()
						.email("john.doe1@mail.com")
						.username("johndoe1")
						.fullname("John Doe")
						.password("$2a$10$6r85sYVFYX1eBlQPYRl3oe5IBfqjDbS3HXHHE7Xp7cPe29//pV35W")
						.phoneNumber("284184218421")
						.build(),
				UserRequest.builder()
						.email("jane.smith2@mail.com")
						.username("janesmith2")
						.fullname("Jane Smith")
						.password("$2a$10$6r85sYVFYX1eBlQPYRl3oe5IBfqjDbS3HXHHE7Xp7cPe29//pV35W")
						.phoneNumber("284184218422")
						.build(),
				UserRequest.builder()
						.email("michael.brown3@mail.com")
						.username("michaelbrown3")
						.fullname("Michael Brown")
						.password("$2a$10$6r85sYVFYX1eBlQPYRl3oe5IBfqjDbS3HXHHE7Xp7cPe29//pV35W")
						.phoneNumber("284184218423")
						.build(),
				UserRequest.builder()
						.email("emily.davis4@mail.com")
						.username("emilydavis4")
						.fullname("Emily Davis")
						.password("$2a$10$6r85sYVFYX1eBlQPYRl3oe5IBfqjDbS3HXHHE7Xp7cPe29//pV35W")
						.phoneNumber("284184218424")
						.build(),
				UserRequest.builder()
						.email("david.johnson5@mail.com")
						.username("davidjohnson5")
						.fullname("David Johnson")
						.password("$2a$10$6r85sYVFYX1eBlQPYRl3oe5IBfqjDbS3HXHHE7Xp7cPe29//pV35W")
						.phoneNumber("284184218425")
						.build(),
				UserRequest.builder()
						.email("sarah.wilson6@mail.com")
						.username("sarahwilson6")
						.fullname("Sarah Wilson")
						.password("$2a$10$6r85sYVFYX1eBlQPYRl3oe5IBfqjDbS3HXHHE7Xp7cPe29//pV35W")
						.phoneNumber("284184218426")
						.build(),
				UserRequest.builder()
						.email("chris.lee7@mail.com")
						.username("chrislee7")
						.fullname("Chris Lee")
						.password("$2a$10$6r85sYVFYX1eBlQPYRl3oe5IBfqjDbS3HXHHE7Xp7cPe29//pV35W")
						.phoneNumber("284184218427")
						.build(),
				UserRequest.builder()
						.email("olivia.moore8@mail.com")
						.username("oliviamoore8")
						.fullname("Olivia Moore")
						.password("$2a$10$6r85sYVFYX1eBlQPYRl3oe5IBfqjDbS3HXHHE7Xp7cPe29//pV35W")
						.phoneNumber("284184218428")
						.build(),
				UserRequest.builder()
						.email("daniel.thomas9@mail.com")
						.username("danielthomas9")
						.fullname("Daniel Thomas")
						.password("$2a$10$6r85sYVFYX1eBlQPYRl3oe5IBfqjDbS3HXHHE7Xp7cPe29//pV35W")
						.phoneNumber("284184218429")
						.build(),
				UserRequest.builder()
						.email("emma.white10@mail.com")
						.username("emmawhite10")
						.fullname("Emma White")
						.password("$2a$10$6r85sYVFYX1eBlQPYRl3oe5IBfqjDbS3HXHHE7Xp7cPe29//pV35W")
						.phoneNumber("284184218430")
						.build());

		userRequests.forEach(userService::createUser);
	}
}
