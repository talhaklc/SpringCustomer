package webdemo.config;

import org.apache.catalina.User;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import webdemo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by exastax-03 on 7/7/2017.
 */
@Configuration
public class Securityconfig extends WebSecurityConfigurerAdapter{

    @Autowired
    UserService userService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html");
        web.ignoring().antMatchers("/login-false.html");
        web.ignoring().antMatchers("/login-true.html");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**")
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .formLogin()
                .loginPage("/index.html")
                .loginProcessingUrl("exastax")
                .usernameParameter("username")
                .passwordParameter("password")
                .successForwardUrl("/login-true")
                .failureUrl("/login-false");
    }
}
