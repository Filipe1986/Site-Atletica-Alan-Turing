package br.com.atleticaAlanTuring.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/* lista dos endereços que não são acessiveis sem autenticação */
		http.authorizeRequests().antMatchers("//admHome", "/carrosselAdm", "/equipesAdm", "/editarDiretoria",
				"/editarProdutos" , "/institucionalAdm", "/painelAdm", "/produtoAdm", "/agendaAdm", "/contatoAdm").hasRole("USER").and()
				.formLogin().loginPage("/login").permitAll()
				.defaultSuccessUrl("/admHome")
		        .failureUrl("/login?error=true");
		
					
			    
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		try {
			auth.inMemoryAuthentication().withUser("filipe").password("123").roles("USER");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
