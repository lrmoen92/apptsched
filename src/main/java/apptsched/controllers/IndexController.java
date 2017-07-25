package apptsched.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Logan.Moen on 7/24/2017.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }
}
