package com.sic.apirest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sic.apirest.dto.UsuarioCustomDTO;
import com.sic.apirest.models.Usuario;
import com.sic.apirest.repository.UsuarioRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * Classe do gerenciador authenticationManager.
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {

	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManagerBean();
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UsuarioRepository usuarioRepository)
			throws Exception {

		if (usuarioRepository.count() == 0) {
			Usuario usuario = new Usuario();
			usuario.setLogin("admin");
			usuario.setSenha(passwordEncoder().encode("admin"));
			usuarioRepository.save(usuario);
		}

		builder.userDetailsService(login -> new UsuarioCustomDTO(usuarioRepository.findByLogin(login)))
				.passwordEncoder(passwordEncoder());
	}

	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}