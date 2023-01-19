package th.co.priorsolution.training.newhttp.service;

import org.springframework.stereotype.Service;
import th.co.priorsolution.training.newhttp.component.EmployeeTransformComponent;
import th.co.priorsolution.training.newhttp.entity.jpa.EmployeesEntity;
import th.co.priorsolution.training.newhttp.model.EmployeeModel;
import th.co.priorsolution.training.newhttp.model.ResponseModel;
import th.co.priorsolution.training.newhttp.repositroy.EmployeesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    public EmployeeService(EmployeesRepository employeesRepository
            , EmployeeTransformComponent employeeTransformComponent) {
        this.employeesRepository = employeesRepository;
        this.employeeTransformComponent = employeeTransformComponent;
    }

    private EmployeesRepository employeesRepository;
    private EmployeeTransformComponent employeeTransformComponent;

    public ResponseModel<List<EmployeeModel>> getEmployeeByLastnameThenResponse(String lastname){
        ResponseModel<List<EmployeeModel>> result = new ResponseModel<>();

        result.setStatus(200);
        result.setDescription("ok");
        try {
            // do some business
            List<EmployeesEntity> data = this.getEmployeeByLastName(lastname);
            List<EmployeeModel> transformedData = this.employeeTransformComponent.transfromEntityListToModelList(data);
            result.setData(transformedData);
        } catch (Exception e){
            result.setStatus(500);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    private List<EmployeesEntity> getEmployeeByLastName(String lastName) {
        return this.employeesRepository.findByLastName(lastName);
    }


    public ResponseModel<Void> insertAndUpdateEmployee(EmployeeModel employeeModel){
        ResponseModel<Void> result = new ResponseModel<>();

        result.setStatus(201);
        result.setDescription("ok");
        try {
            // do some business
            EmployeesEntity employeesEntity = this.employeeTransformComponent.transfromModelToEntity(employeeModel);
            this.employeesRepository.save(employeesEntity);
        } catch (Exception e){
            result.setStatus(500);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    public ResponseModel<Void> updateEmployee(EmployeeModel employeeModel){
        ResponseModel<Void> result = new ResponseModel<>();

        result.setStatus(201);
        result.setDescription("ok");
        try {
            // do some business
            Optional<EmployeesEntity> employeesEntityOptional = this.employeesRepository.findById(employeeModel.getEmpNo());
            if(employeesEntityOptional.isPresent()){
                EmployeesEntity employeesEntity = employeesEntityOptional.get();
                this.employeeTransformComponent.transfromModelToEntityForUpdate(employeesEntity, employeeModel);
                this.employeesRepository.save(employeesEntity);
            } else {
                result.setStatus(404);
                result.setDescription("data to update notfound");
            }

        } catch (Exception e){
            result.setStatus(500);
            result.setDescription(e.getMessage());
        }
        return result;
    }
}