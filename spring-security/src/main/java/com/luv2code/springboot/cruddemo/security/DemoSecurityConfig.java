//package com.luv2code.springboot.cruddemo.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DemoSecurityConfig {
//
//    //add support for jdbc and no more hardCoded users
////    @Bean
////    public UserDetailsManager userDetailsManager(DataSource dataSource){
////        return new JdbcUserDetailsManager(dataSource);
////        //Upon changing a user password, or maybe adding anything in DB, we don't need to restart the application
////        // 401 unauthorized - credentials are wrong.
////        //403 Forbidden - credentials are correct, but the user doesn't have the role required to access this API.
////        //When we hash password using bcrypt algo, the encrypted password length is always = 60
////        //While bcrypt password comparison, we always encrypt the password that user entered, rather than decrypting the password present in DB
////        //This is why bcrypt is a one way hashing algorithm.
////        default passwords in table are fun123(bcrypt hashed)
////    }
//
//
//    //For custom tables(not following the rules for names of columns defined by spring security)
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        //define a query to retrieve a user by userName
//        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id = ?");
//        //define a query to retrieve authorities by userName
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id = ?");
//        return jdbcUserDetailsManager;
//    }
//
//    //To provide access to endpoints based on roles
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests(configurer ->
//                configurer
//                    .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
//                    .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
//                    .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
//                    .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
//                    .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
//        );
//
//        //to allow a particular endPoint with a particular HttpMethod, we can also use function hasAnyRole
//        //This accepts a ',' separated list of Strings in which we can specify the roles that can access this endPoint
//        //Use HTTP basic authentication
//        httpSecurity.httpBasic(Customizer.withDefaults());
//        //disable Cross Site Request Forgery(CSRF)
//        //Used only in API's that are directly exposed on a web browser
//        //Not required for stateless REST API's
//        httpSecurity.csrf(csrf -> csrf.disable());
//
//        return httpSecurity.build();
//    }
//
//    //    @Bean
////    public InMemoryUserDetailsManager userDetailsManager() {
////        UserDetails john = User.builder()
////                .username("john")
////                .password("{noop}test@123")//This means that the password will be stored as plain text(without being hashed) inside application memory
////                .roles("EMPLOYEE")
////                .build();
////
////        UserDetails mary = User.builder()
////                .username("mary")
////                .password("{noop}test@123")//This means that the password will be stored as plain text(without being hashed) inside application memory
////                .roles("EMPLOYEE", "MANAGER")
////                .build();
////
////        UserDetails susan = User.builder()
////                .username("susan")
////                .password("{noop}test@123")//noop means that the password will be stored as plain text(without being hashed) inside application memory
////                .roles("EMPLOYEE", "MANAGER", "ADMIN")
////                .build();
////
////        /**
////         * Since we defined InMemoryUserDetails here, the username and password defined inside application.properties is useless now.
////         */
////
////        return new InMemoryUserDetailsManager(john, mary, susan);
////    }
//}
