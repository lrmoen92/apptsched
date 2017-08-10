package apptsched.rest;

import apptsched.domain.DTO.UserDto;
import apptsched.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationRest {

    private final UserService userService;

    @Autowired
    public RegistrationRest(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/api/register/", method = RequestMethod.POST)
    public UserDto registerUser(@RequestBody UserDto user){

        return userService.saveUser(user);
    }


}
