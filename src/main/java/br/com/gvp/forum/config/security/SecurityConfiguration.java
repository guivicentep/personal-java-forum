package br.com.gvp.forum.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

//
//	    @Autowired
//	    private TokenService tokenService;
//
//	    @Autowired
//	    private UsuarioRepository usuarioRepository;

	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }
	    
	    @Bean
	    public PasswordEncoder encoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	        .antMatchers(HttpMethod.GET, "/topicos").permitAll()
	        .antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
	        .antMatchers(HttpMethod.POST, "/auth").permitAll()
//	        .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
	        .anyRequest().authenticated()
	        .and().csrf().disable()
	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	        .and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
//
	        return http.build();
	    }
//
//	    @Bean
//	    public WebSecurityCustomizer webSecurityCustomizer() {
//	        return (web) -> web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
//	    }

}
