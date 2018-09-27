//package com.spring.demo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
////import org.springframework.security.annotation.*;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    private static String REALM="MY_TEST_REALM";
//
////    @Override
////    public void configure(WebSecurity web) throws Exception {
////        web.ignoring().antMatchers("/js/**");
////    }
//
//    @Autowired
//    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and()
//////                authorizeRequests()
//////                .anyRequest().permitAll();
//                .headers()
//                .frameOptions().disable().and()
//                .authorizeRequests()
//                .antMatchers("/", "/login", "/users", "/favicon/ico").permitAll()
//                .antMatchers("/private**").authenticated()
////                .antMatchers("/users").authenticated()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .csrf().disable();
//
////        http.csrf().disable()
////                .authorizeRequests()
////                .antMatchers("/", "/login", "/users", "/favicon/ico").hasRole("ADMIN")
//////                .and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
////                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//We don't need sessions to be created.
//
//
//    }
//
////    @Bean
////    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
////        return new CustomBasicAuthenticationEntryPoint();
////    }
//
//    /* To allow Pre-flight [OPTIONS] request from browser */
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
//    }
//
//    @Bean
//    public BCryptPasswordEncoder getBCryptPasswordEncoder () {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
//        return bCryptPasswordEncoder;
//    }
//
////    @Bean
////    @Override
////    public AuthenticationManager authenticationManagerBean() throws Exception {
////        return super.authenticationManagerBean();
////    }
//}
