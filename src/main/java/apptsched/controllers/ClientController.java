package apptsched.controllers;

import apptsched.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

    @RequestMapping(value = "/")
    public String getClientPage(){
        return "client/client";
    }

    @RequestMapping(value = "/list")
    public String getListPage(){
        return "client/list";
    }

    @RequestMapping(value = "/listPrevious")
    public String getPreviousListPage(){
        return "client/listPast";
    }

    @RequestMapping(value = "/new")
    public String getNewPage(){
        return "client/new";
    }

}
