package th.co.priorsolution.training.newhttp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeModel {
    private int empNo;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate hireDate;
}
