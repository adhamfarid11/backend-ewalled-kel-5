package com.odp.walled.config;

import com.odp.walled.model.User;
import com.odp.walled.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        List<User> users = Arrays.asList(
                User.builder()
                        .email("john.doe1@mail.com")
                        .username("johndoe1")
                        .fullname("John Doe")
                        .password("password123")
                        .phoneNumber("284184218421")
                        .avatarUrl(null)
                        .build(),

                User.builder()
                        .email("jane.smith2@mail.com")
                        .username("janesmith2")
                        .fullname("Jane Smith")
                        .password("password123")
                        .phoneNumber("284184218422")
                        .avatarUrl(null)
                        .build(),

                User.builder()
                        .email("michael.brown3@mail.com")
                        .username("michaelbrown3")
                        .fullname("Michael Brown")
                        .password("password123")
                        .phoneNumber("284184218423")
                        .avatarUrl(null)
                        .build(),

                User.builder()
                        .email("emily.davis4@mail.com")
                        .username("emilydavis4")
                        .fullname("Emily Davis")
                        .password("password123")
                        .phoneNumber("284184218424")
                        .avatarUrl(null)
                        .build(),

                User.builder()
                        .email("david.johnson5@mail.com")
                        .username("davidjohnson5")
                        .fullname("David Johnson")
                        .password("password123")
                        .phoneNumber("284184218425")
                        .avatarUrl(null)
                        .build());

        userRepository.saveAll(users);
    }
}
