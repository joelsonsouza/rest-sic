package com.sic.apirest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * @Configuration indica que a classe possui Beans de configuração que serão utilizadas em toda a aplicação
 * @EnableAuthorizationServer a classe é utilizada para marcar um mecanismo de gerenciamento de autenticação.
 * extends AuthorizationServerConfigurerAdapter a classe extende a classe que possuí os métodos que configuram o servidor de autenticação.
 * */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter  {

    private static final Integer ACCESS_TOKEN_VALIDITY_IN_SECONDS = 60 * 60 * 24;
    private static final Integer REFRESH_TOKEN_VALIDITY_IN_SECONDS = 60 * 60 * 24;
    private static final String CLIENT = "client-id";
    private static final String SECRET = "secret-id";

    @Autowired
    private AuthenticationManager authenticationManager;

   
	/**
	 * Libera o acesso à requisições /oauth/check_token e /oauth/token_key.
	 * Testar via Postman
	 * @GET http://localhost:9000/oauth/token?grant_type=password&username=admin&password=admin
	 * @Basic Auth
	 * Username: client-id Password: secret-id
	 */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    /**
	 * Define que os tokens ficarão armazenados na memória e estarão disponíveis através do client client-id e do secret secret-id.
	 * Da ao usuário acesso através de password, authorization_code, refresh_token e implicit, com os escopos de leitura e/ou escrita.
	 * Definidos os tempos que o token de acesso e o refresh token levarão para expirar, em segundos.
	 * O refresh token é utilizado para atualizar o token de segurança de um usuário, gerando um novo token e um novo tempo de expiração.
	 * */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(CLIENT)
                .secret(new BCryptPasswordEncoder().encode(SECRET))
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
                .scopes("read", "write", "trust")
                .resourceIds("oauth2-resource")
                .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_IN_SECONDS)
                .refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY_IN_SECONDS);
    }

    /**
	  * Definindo que os tokens poderão ser gerados através de requisições GET e POST
	  * utilizando o gerenciador authenticationManager.
	  * **/
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }
}
