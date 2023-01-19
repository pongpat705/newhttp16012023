package th.co.priorsolution.training.newhttp.repositroy;

import th.co.priorsolution.training.newhttp.model.EmployeeModel;

import java.util.List;

public interface EmployeeNativeRepository {

    public List<EmployeeModel> findEmployeeByEmployee(EmployeeModel employeeModel);

}
