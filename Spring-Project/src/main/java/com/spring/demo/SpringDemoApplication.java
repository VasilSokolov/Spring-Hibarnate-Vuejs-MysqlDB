package com.spring.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:app.properties", "classpath:local.properties"})
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

//    @Autowired
//    public void authenticationManager(AuthenticationManagerBuilder builder, UserServiceImpl repository, UserService userService) throws Exception {
//        if (repository.findAll().equals(0))
//            userService.save(new User("admin", "admin", "ADMIN"));
//        builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
//    }
//
//    /**
//     * We return an istance of our CustomUserDetails.
//     * @param userService
//     * @return
//     */
//    private UserDetailsService userDetailsService(final UserServiceImpl userService) {
//        return username -> new CustomUserDetails(userService.findByUsername(username));
//    }
}
