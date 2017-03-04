package br.com.atleticaAlanTuring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ComercialUserDetailsService ssUserDetailsService;
	
	
/*	  @Override
	  public void configure(AuthenticationManagerBuilder builder) throws Exception {
	    builder
	        .inMemoryAuthentication()
	        .withUser("garrincha").password("123")
	            .roles("USER")
	        .and()
	        .withUser("zico").password("123")
	            .roles("USER");
	  }*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/*", "/quemsoueu", "/meustimes", "/diretoria", "/produtos", "/agenda" , "/sejasocio", "/falacomigo", "/login" ).permitAll().antMatchers( "/membrosAdm",
				"/carrosselAdm" ,"/equipesAdm", "/editarDiretoria", "/institucionalAdm", "/painelAdm",
				"/produtoAdm", "/agendaAdm" , "/contatoAdm" ).
		hasRole("DIRETOR").anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/").permitAll().and().rememberMe();
		


	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.userDetailsService(ssUserDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
		
	}

	
}
