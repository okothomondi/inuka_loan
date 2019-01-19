///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com._4g_capital.inuka.configurations;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
//
///**
// *
// * @author okoth.omondi
// */
//@Configuration
////@EnableGlobalMethodSecurity(securedEnabled = true)
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@ComponentScan(basePackages = {"com.pycs.bulksmsportal.configurations"})
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    public static final String REMEMBER_ME_KEY = "rememberme_key";
//
//    @Autowired
//    @Qualifier("customUserDetailsService")
//    UserDetailsService userDetailsService;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        System.out.println("CONFIGURE GLOBAL ENTRY");
//        auth.userDetailsService(userDetailsService);
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//    public SecurityConfiguration() {
//        super();
//    }
//
//    @Autowired
//    private RestUnauthorizedEntryPoint restAuthenticationEntryPoint;
//
//    @Autowired
//    private AccessDeniedHandler restAccessDeniedHandler;
//
//    @Autowired
//    private AuthenticationSuccessHandler restAuthenticationSuccessHandler;
//
//    @Autowired
//    private AuthenticationFailureHandler restAuthenticationFailureHandler;
//
//    @Autowired
//    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("prsp").password("{noop}superuser").roles("USER");
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors()
//                .and()
//                .csrf().disable()
//                .authorizeRequests()//"/**",
//                //                .antMatchers("").permitAll()
//                .antMatchers("/post/list").permitAll()
//                .antMatchers("/**").hasRole("ADMIN")
//                .antMatchers("/**").hasRole("USER")
//                .anyRequest().authenticated()
//                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint(restAuthenticationEntryPoint)
//                .accessDeniedHandler(restAccessDeniedHandler)
//                .and()
//                .formLogin().loginPage("/").permitAll()
//                .loginProcessingUrl("/authenticate")
//                .successHandler(restAuthenticationSuccessHandler)
//                .failureHandler(restAuthenticationFailureHandler)
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .permitAll()
//                .and()
//                .logout()//.logoutSuccessUrl("/login?logout").permitAll();
//                .logoutUrl("/logout")
//                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
//                .deleteCookies("JSESSIONID")
//                .permitAll()
//                .and()
//                .rememberMe()
//                //.rememberMeServices(rememberMeServices)
//                .key(REMEMBER_ME_KEY)
//                .and();
//    }
//}
