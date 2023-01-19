package th.co.priorsolution.training.newhttp.controller.rest;


import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import th.co.priorsolution.training.newhttp.model.AddressModel;
import th.co.priorsolution.training.newhttp.model.PersonModel;
import th.co.priorsolution.training.newhttp.model.ResponseModel;
import th.co.priorsolution.training.newhttp.service.AppService;

@RestController
@RequestMapping("/api")
public class AppRestController {

    public AppRestController(AppService appService) {
        this.appService = appService;
    }
    private AppService appService;

    @GetMapping("/person")
    public ResponseModel<PersonModel> getPersonData(){
        return this.appService.getPersonDataAndResponse();
    }

    @GetMapping("/address")
    public ResponseModel<AddressModel> getAddressData(){
        return this.appService.getAddressDataAndResponse();
    }


//    HttpServletRequest requestScope = httpServletRequest;
//        requestScope.setAttribute();
//        requestScope.getAttribute();
//
//    HttpSession sessionScope = requestScope.getSession();
//        sessionScope.setAttribute();
//        sessionScope.getAttribute();
//    ServletContext appScope = sessionScope.getServletContext();

    @GetMapping("/set/to/session-scope")
    public void setParamToSessionScope(@RequestParam("param")String param, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        httpServletRequest.getSession().setAttribute("param", param);

    }
    @GetMapping("/get/from/session-scope")
    public String  getParamFromSessionScope(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        return (String) httpServletRequest.getSession().getAttribute("param");
    }
    @GetMapping("/set/to/app-scope")
    public void setParamToAppScope(@RequestParam("param")String param, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        httpServletRequest.getServletContext().setAttribute("param", param);

    }

    @GetMapping("/get/from/app-scope")
    public String  getParamFromAppScope(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        return (String) httpServletRequest.getServletContext().getAttribute("param");

    }
}
