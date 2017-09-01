package apptsched.services.impl;

import apptsched.common.StringHelper;
import apptsched.domain.Client;
import apptsched.domain.DTO.UserDto;
import apptsched.domain.Employee;
import apptsched.services.ClientService;
import apptsched.services.EmployeeService;
import apptsched.services.UserService;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final DataSource dataSource;
    private final ClientService clientService;
    private final EmployeeService employeeService;

    @Autowired
    public UserServiceImpl(DataSource dataSource, ClientService clientService, EmployeeService employeeService){
        this.dataSource = dataSource;
        this.clientService = clientService;
        this.employeeService = employeeService;
    }

    @Override
    public UserDto saveUser(UserDto user) {

        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
        userDetailsService.setDataSource(dataSource);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (StringHelper.emailSuffixParser(user.getUsername()).equals("@astontech.com")) {
            authorities.add(new SimpleGrantedAuthority("EMPLOYEEUSER"));
            employeeService.save(new Employee(user.getFirstName(), user.getLastName(), "", user.getUsername(), "", null, ""));
        } else {
            authorities.add(new SimpleGrantedAuthority("CLIENTUSER"));
            clientService.save(new Client(user.getFirstName(), user.getLastName(), "", user.getUsername(), "", new Date()));
        }

        User userDetails = new User(user.getUsername(), encoder.encode(user.getPassword()), authorities);
        try{
            userDetailsService.createUser(userDetails);
        }catch(Exception ex){
            System.out.println(ex.toString());
            return null;
        }

        return user;
    }
}
