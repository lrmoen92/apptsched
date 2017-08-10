package apptsched.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class EmployeeController {

    @RequestMapping(value = "/employee")
    public String getEmployeePage(Authentication authentication, Model model){
        model.addAttribute("activeUser", authentication.getName());
        return "employee";
    }
}
