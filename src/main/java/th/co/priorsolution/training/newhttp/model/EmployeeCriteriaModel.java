package th.co.priorsolution.training.newhttp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeCriteriaModel {
    private int empNo;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate1;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate2;
    private String firstName;
    private String lastName;
    private String gender;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate hireDate1;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate hireDate2;
}
