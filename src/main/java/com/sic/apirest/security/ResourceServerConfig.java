package com.sic.apirest.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	
    	http
    	//.csrf()
        //.disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET,"api/pes/**").permitAll()
    
       .antMatchers(HttpMethod.POST, "/usuario").permitAll()
       .antMatchers(HttpMethod.GET, "/usuario").denyAll();
        
    }
    //http://localhost:9000/sic/api/pessoas
    
}
