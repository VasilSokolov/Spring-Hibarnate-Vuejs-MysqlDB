//package com.spring.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.
//                authorizeRequests()
//                .anyRequest().permitAll();
//
////                .antMatchers("/", "/login", "/users").permitAll()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .csrf().disable();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder getBCryptPasswordEncoder () {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
//        return bCryptPasswordEncoder;
//    }
//}
