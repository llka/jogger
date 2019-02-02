package ru.ilka.jogger.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.ilka.jogger.entity.Role;
import ru.ilka.jogger.util.UrlSchema;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@ComponentScan(value = "ru.ilka.jogger")
@PropertySource("classpath:application.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static Logger logger = LogManager.getLogger(SecurityConfig.class);

    @Value("${spring.queries.users-query}")
    private String usersQuery;
    @Value("${spring.queries.roles-query}")
    private String rolesQuery;
    @Value("${password-encoder.strength}")
    private int passwordStrength;

    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(passwordStrength);
        return bCryptPasswordEncoder;
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(UrlSchema.AUTH, UrlSchema.AUTH + "/**",
                        "/swagger-ui.html", "/swagger-ui", "/v2/api-docs").permitAll()
                .antMatchers(UrlSchema.APP, UrlSchema.APP + "/**").hasAuthority(Role.USER.getName())
                .anyRequest().authenticated()
                .and()
                .csrf()
                .disable()
                .httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**");
    }

}
