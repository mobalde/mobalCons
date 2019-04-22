package mobalDev.General;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Value("${spring.queries.users-query}") // Definit dans application.properties
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}") // Definit dans application.properties
	private String rolesQuery;
	
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource)
			throws Exception {
		auth.
			jdbcAuthentication()
				.dataSource(dataSource)
				.passwordEncoder(bCryptPasswordEncoder)
				.usersByUsernameQuery(usersQuery)
				.authoritiesByUsernameQuery(rolesQuery);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/css/**", "/js/**", "/images/**", "/mobalc/login", "/mobalc/register").permitAll()
			.anyRequest().authenticated()
			.and()
			.csrf().disable()
			.sessionManagement().maximumSessions(1);
	}
	
	// Allow OPTIONS calls to be accessed without authentication
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring()
	        .antMatchers(HttpMethod.OPTIONS);
	}
	
	@Override
	@Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
