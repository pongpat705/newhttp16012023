package th.co.priorsolution.training.newhttp.repositroy;

import th.co.priorsolution.training.newhttp.model.EmployeeCriteriaModel;
import th.co.priorsolution.training.newhttp.model.EmployeeModel;

import java.util.List;

public interface EmployeeNativeRepository {

    public List<EmployeeModel> findEmployeeByEmployee(EmployeeCriteriaModel employeeModel);

    public int insertEmployee(List<EmployeeModel> employeeModels);

    public int updateEmployee(EmployeeModel employeeModel);

}
