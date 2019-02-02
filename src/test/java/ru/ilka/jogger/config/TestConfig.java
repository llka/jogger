package ru.ilka.jogger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.ilka.jogger.util.MockEntityFactory;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Configuration
@ComponentScan(basePackages = "ru.ilka.jogger", excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class))
public class TestConfig {
    @Bean("AuthenticationMock")
    public Authentication createMockAuth() {
        Authentication auth = mock(Authentication.class);
        when(auth.getName()).then(invocation -> MockEntityFactory.Users.bob().getLogin());
        when(auth.getPrincipal()).then(invocation -> MockEntityFactory.Users.bob());
        return auth;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
        return bCryptPasswordEncoder;
    }
}
