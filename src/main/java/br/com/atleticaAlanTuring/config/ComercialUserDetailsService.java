package br.com.atleticaAlanTuring.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.atleticaAlanTurign.seguranca.UsuarioSistema;
import br.com.atleticaAlanTuring.model.Diretor;
import br.com.atleticaAlanTuring.model.Grupo;
import br.com.atleticaAlanTuring.model.Permissao;
import br.com.atleticaAlanTuring.repository.DiretorRepository;
import br.com.atleticaAlanTuring.repository.IGrupos;
import br.com.atleticaAlanTuring.repository.IPermissoes;


@Component
public class ComercialUserDetailsService implements UserDetailsService {
	

	@Autowired
	private DiretorRepository diretorRepository;

	@Autowired
	private IGrupos igrupos;
	
	@Autowired
	private IPermissoes ipermissoes;

	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Diretor diretor = diretorRepository.findByLogin(username);
		
		if (diretor == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		
		return new UsuarioSistema(diretor.getNome(), diretor.getLogin(), diretor.getSenha(), authorities(diretor));
	}
	
	public Collection<? extends GrantedAuthority> authorities(Diretor diretor) {
		return authorities(igrupos.findByDiretoresIn(diretor));
	}
	
	public Collection<? extends GrantedAuthority> authorities(List<Grupo> grupos) {
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		
		for (Grupo grupo: grupos) {
			List<Permissao> lista = ipermissoes.findByGruposIn(grupo);
			
			for (Permissao permissao: lista) {
				auths.add(new SimpleGrantedAuthority("ROLE_" + permissao.getNome()));
			}
		}
		
		return auths;
	}
}
