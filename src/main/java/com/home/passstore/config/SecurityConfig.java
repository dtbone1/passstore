//package com.home.passstore.config;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//    UserDetailsService userDetailsService;
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		//@formatter:off
//        http.authorizeRequests()
//            .antMatchers("/resources/**", "/result/**", "/addNewUser.json", "/public/**").permitAll()
//            .anyRequest().authenticated()
//                .and().formLogin().loginPage("/login").permitAll()
//                .and().logout().logoutUrl("/sign-out").logoutSuccessUrl("/").invalidateHttpSession(true);
//        //@formatter:on
//	}
//	
//	@Bean
//    public ProviderManager authenticationManager() {
//        List<AuthenticationProvider> providers = new ArrayList<AuthenticationProvider>();
//        providers.add(daoAuthenticationProvider());
//        ProviderManager manager = new ProviderManager(providers);
//        return manager;
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//        return daoAuthenticationProvider;
//    }
//
//    @Bean
//    public ShaPasswordEncoder passwordEncoder() {
//        ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
//        return passwordEncoder;
//    }
//}
