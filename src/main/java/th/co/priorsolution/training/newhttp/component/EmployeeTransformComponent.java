package th.co.priorsolution.training.newhttp.component;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import th.co.priorsolution.training.newhttp.entity.jpa.EmployeesEntity;
import th.co.priorsolution.training.newhttp.model.EmployeeModel;
import th.co.priorsolution.training.newhttp.model.PersonModel;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeTransformComponent {


    public List<EmployeeModel> transfromEntityListToModelList(List<EmployeesEntity> employeesEntity){
        List<EmployeeModel> employeeModelList = new ArrayList<>();
        for (EmployeesEntity x : employeesEntity) {
            EmployeeModel y = this.transfromEntityToModel(x);
            employeeModelList.add(y);
        }

        return employeeModelList;
    }

    public EmployeeModel transfromEntityToModel(EmployeesEntity employeesEntity){
//        serialize
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setGender(employeesEntity.getGender());
        employeeModel.setFirstName(employeesEntity.getFirstName());
        employeeModel.setEmpNo(employeesEntity.getEmpNo());
        employeeModel.setHireDate(employeesEntity.getHireDate());
        employeeModel.setLastName(employeesEntity.getLastName());

        return employeeModel;
    }

    public EmployeesEntity transfromModelToEntity(EmployeeModel employeeModel){
        EmployeesEntity employeesEntity = new EmployeesEntity();
        employeesEntity.setGender(employeeModel.getGender());
        employeesEntity.setBirthDate(employeeModel.getBirthDate());
        employeesEntity.setFirstName(employeeModel.getFirstName());
        employeesEntity.setEmpNo(employeeModel.getEmpNo());
        employeesEntity.setHireDate(employeeModel.getHireDate());
        employeesEntity.setLastName(employeeModel.getLastName());
        return employeesEntity;
    }

    public void transfromModelToEntityForUpdate(EmployeesEntity employeesEntity,EmployeeModel employeeModel){
        employeesEntity.setGender(employeeModel.getGender());
        employeesEntity.setBirthDate(employeeModel.getBirthDate());
        employeesEntity.setFirstName(employeeModel.getFirstName());
        employeesEntity.setEmpNo(employeeModel.getEmpNo());
        employeesEntity.setHireDate(employeeModel.getHireDate());
        employeesEntity.setLastName(employeeModel.getLastName());
    }

}
