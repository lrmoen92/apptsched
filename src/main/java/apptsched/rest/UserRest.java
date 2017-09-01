package apptsched.rest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
public class UserRest {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUser(Authentication authentication){
        return authentication.getName();
    }
}