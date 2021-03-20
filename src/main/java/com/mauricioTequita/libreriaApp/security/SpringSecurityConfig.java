package com.mauricioTequita.libreriaApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mauricioTequita.libreriaApp.config.CustomAccessDeniedHandler;
import com.mauricioTequita.libreriaApp.security.service.UserDetailsServiceImpl;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	
	@Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        		.antMatchers("/", "/index", "/forbidden", "/icon/*", "/css/*")
        		.permitAll()
                .antMatchers("/usuario/login", "/usuario/registro" ,"/usuario/registrar")
                .permitAll()
                .antMatchers("/libro/detalle", "/libro/listarLibros")
                .permitAll()
                .antMatchers("/carro/agregarAlCarro", "/carro/eliminarLibroCarro", "/carro/verCarro")
                .hasRole("USER")
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/signin")
                .loginPage("/usuario/login").permitAll()
                .defaultSuccessUrl("/usuario/default", true)
                .usernameParameter("correoUsuario")
                .passwordParameter("password")
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/usuario/login?logout").permitAll()
                .deleteCookies("JSESSIONID")
                .and()
                .rememberMe().tokenValiditySeconds(3600000).key("secret").rememberMeParameter("checkRememberMe");
    }
}
