package com.algamoney.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.algamoney.api.config.token.CustomTokenEnhancer;
import com.algamoney.api.security.AppUserDetailsService;

//@Profile("oauth-security")
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	/* @ngul@r0 */
	private static final String CLIENT_PASSWORD="$2a$10$vE4CZwKD0LFaKl/m/oB.e.WUxeCqb5zfvHL8EHyYRX0GcdyFrj38u";
	
	/* m0b1l30 */
	private static final String CLIENT_MOBILE="$2a$10$GP9tfdPDL3YtNT2U0J4ipOMZ4UM1BaJk2ooo9ekZK/hLP9QKz9OAK";
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AppUserDetailsService appUserDetailsService;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("angular")
				.secret(CLIENT_PASSWORD)
				.scopes("read","write")
				.authorizedGrantTypes("password","refresh_token")
				.accessTokenValiditySeconds(1800) /*1800 segundos - 30 minutos ativo*/
				.refreshTokenValiditySeconds(3600 * 24) /*Irá durar um dia inteiro*/
			.and()
				.withClient("mobile")
				.secret(CLIENT_MOBILE)
				.scopes("read")
				.authorizedGrantTypes("password","refresh_token")
				.accessTokenValiditySeconds(1800) /*1800 segundos - 30 minutos ativo*/
				.refreshTokenValiditySeconds(3600 * 24); /*Irá durar um dia inteiro*/
			
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), accessTokenConverter()));
		
		
		endpoints
			.tokenStore(tokenStore())
			.tokenEnhancer(tokenEnhancerChain)
			.reuseRefreshTokens(false) /*Não reutilizar o refresh_token quando o mesmo solicitar a geração de um novo access Token*/
			.authenticationManager(authenticationManager).userDetailsService(appUserDetailsService);
	}
	

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey("algaworks"); /*Palavra chave que valida o token*/
		return accessTokenConverter;
	}

	@Bean
	public TokenStore tokenStore() {
		/*Cria token em memória para testes.*/
		return new JwtTokenStore(accessTokenConverter());
	}
	
	@Bean
	public TokenEnhancer tokenEnhancer() {
		return new CustomTokenEnhancer();
	}
	
	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("m0b1l30"));
	}
}
