package app.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        http.csrf().disable().authorizeRequests()
        
//        	Permite el acceso de login a quien sea
            .antMatchers("/login").permitAll()
            
//          Cualquier otra peticion requiere autenticacion
            .anyRequest().authenticated()
            .and()
            
//          Las peticiones de login pasan por el filtro
            .addFilterBefore(new LoginFilter("/login", authenticationManager()),
                    UsernamePasswordAuthenticationFilter.class)

//          Las demas peticiones pasan por este filtro para validar el token
            .addFilterBefore(new JwtFilter(),
                    UsernamePasswordAuthenticationFilter.class);
        
    }

   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   
       auth.inMemoryAuthentication()
               .withUser("root")
               .password("{noop}root")
               .roles("ADMIN");
       
//    Crea una cuenta de usuario por defecto.
       auth.inMemoryAuthentication()
			   .withUser("userDefault")
			   .password("{noop}userDefault")
			   .roles("USER");
       
    }
   
}