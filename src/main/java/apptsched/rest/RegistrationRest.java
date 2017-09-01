package apptsched.rest;

import apptsched.domain.DTO.UserDto;
import apptsched.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/register")
public class RegistrationRest {

    private final UserService userService;

    @Autowired
    public RegistrationRest(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public UserDto registerUser(@RequestBody UserDto userDto){

        return userService.saveUser(userDto);
    }


}
