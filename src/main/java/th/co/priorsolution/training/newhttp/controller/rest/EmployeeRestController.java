package th.co.priorsolution.training.newhttp.controller.rest;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import th.co.priorsolution.training.newhttp.model.EmployeeModel;
import th.co.priorsolution.training.newhttp.model.ResponseModel;
import th.co.priorsolution.training.newhttp.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private EmployeeService employeeService;




    @GetMapping("/employee")
    public ResponseModel<List<EmployeeModel>> getEmployeeByLastName(
            @RequestParam(name = "lastName") String lastName
    ){
        return this.employeeService.getEmployeeByLastnameThenResponse(lastName);
    }

    @GetMapping("/employee/{lastName}")
    public ResponseModel<List<EmployeeModel>> getEmployeeByLastName2(@PathVariable(name = "lastName") String lastName){
        return this.employeeService.getEmployeeByLastnameThenResponse(lastName);
    }

    @PostMapping("/employee")
    public ResponseModel<Void> insertEmployee(
            @RequestBody EmployeeModel employeeModel
    ){
        return this.employeeService.insertAndUpdateEmployee(employeeModel);
    }

    @DeleteMapping("/employee")
    public ResponseModel<Void> deleteEmployee(
            @RequestBody EmployeeModel employeeModel
    ){
        return this.employeeService.deleteEmployee(employeeModel);
    }
}
