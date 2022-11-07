package peaksoft.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter{

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
            auth.inMemoryAuthentication()
                    .withUser(userBuilder.username("elnura").password("elnura").roles("Instructor"))
                    .withUser(userBuilder.username("esen").password("esen").roles("Director"))
                    .withUser(userBuilder.username("talant").password("talant").roles("Student"));
//                    .withUser(userBuilder.username("dinara").password("dinara").roles("Manager"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasAnyRole("Director", "Instructor", "Student")
                .antMatchers("/director_info").hasRole("Director")
                .antMatchers("/instructor_info").hasAnyRole("Instructor", "Director")
                .and().formLogin().permitAll();
        super.configure(http);
    }
}
