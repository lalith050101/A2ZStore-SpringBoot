package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);      
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/signup").permitAll()
        .antMatchers("/logout","/home", "/getProduct/**").hasAnyAuthority("admin","customer")
        .antMatchers("/allOrders", "/getOrder/", "/addProduct", "/editProduct/**", "/deleteProduct/**" ).hasAnyAuthority("admin")
        .antMatchers("/addToCart/**", "/cart", "/removeCartItem/**", "/updateCart/**", "/proceedOrder", "profile", "updateProfile", "orderDetails", "placeOrder", "orders" ).hasAnyAuthority("customer")
        .and().formLogin().loginPage("/login").usernameParameter("email").passwordParameter("password").defaultSuccessUrl("/home").failureUrl("/login?error").permitAll().and()
        .exceptionHandling().accessDeniedPage("/access-denied");
    }
    

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
    	return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    	
    	provider.setUserDetailsService(userDetailsService());
    	provider.setPasswordEncoder(bCryptPasswordEncoder());
    	
    	return provider;
    }
    


}