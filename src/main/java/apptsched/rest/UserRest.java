package apptsched.rest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/users")
public class UserRest {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUser(Authentication authentication){

        return authentication.getName();
    }
}
