package apptsched.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Logan.Moen on 7/24/2017.
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    private final DataSource dataSource;

    @Autowired
    public SecurityConfiguration(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
        userDetailsService.setDataSource(dataSource);
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
        auth.jdbcAuthentication().dataSource(dataSource);

        if(!userDetailsService.userExists("admin")){
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("CLIENTUSER"));
            authorities.add(new SimpleGrantedAuthority("EMPLOYEEUSER"));
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
            User userDetails = new User("admin", encoder.encode("123"), authorities);

            userDetailsService.createUser(userDetails);
        }
        if(!userDetailsService.userExists("dba")){
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("CLIENTUSER"));
            authorities.add(new SimpleGrantedAuthority("EMPLOYEEUSER"));
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
            authorities.add(new SimpleGrantedAuthority("DBADMIN"));
            User userDetails = new User("dba", encoder.encode("123"), authorities);

            userDetailsService.createUser(userDetails);
        }
    }



    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeRequests().antMatchers("/").permitAll()
                .and()
                .authorizeRequests().antMatchers("/console/**").permitAll();
//        httpSecurity
//                .authorizeRequests().antMatchers("/webjars/bootstrap/**").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/webjars/jquery/**").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/static/**").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/login/**").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/register/**").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/api/register/").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/api/user/").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/console/**").hasAuthority("DBADMIN")
//                .and()
//                .authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN")
//                .and()
//                .authorizeRequests().antMatchers("/client/**").hasAuthority("CLIENTUSER")
//                .and()
//                .authorizeRequests().antMatchers("/employee/**").hasAuthority("EMPLOYEEUSER")
//                .and()
//                .authorizeRequests().antMatchers("/profile").hasAnyAuthority("CLIENTUSER", "EMPLOYEEUSER", "ADMIN", "DBADMIN")
//                .anyRequest().authenticated();

        httpSecurity
                .formLogin().loginPage("/login").loginProcessingUrl("/login.do")
                .defaultSuccessUrl("/", true)
                .failureUrl("/login?err=1")
                .usernameParameter("username")
                .passwordParameter("password");

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }
}
