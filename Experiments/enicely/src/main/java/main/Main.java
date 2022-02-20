package main;

import main.userManagement.userData;
import main.userManagement.userRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main
{

    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner initUser(userRepository userRepository) {
        return args -> {

            userData user = new userData();
            user.setUsername("josh");
            user.setAuthenticationMethod("plaintext");
            user.setAuthenticationData("george");
            userRepository.save(user);

        };
    }

}
