package th.co.priorsolution.training.newhttp.repositroy.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import th.co.priorsolution.training.newhttp.model.EmployeeCriteriaModel;
import th.co.priorsolution.training.newhttp.model.EmployeeModel;
import th.co.priorsolution.training.newhttp.repositroy.EmployeeNativeRepository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeNativeRepositoryImpl implements EmployeeNativeRepository {
    private JdbcTemplate jdbcTemplate;

    public EmployeeNativeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<EmployeeModel> findEmployeeByEmployee(EmployeeCriteriaModel employeeModel) {

        List<Object> paramList = new ArrayList<>();

        String sql = " select emp_no, birth_date, first_name, last_name, gender, hire_date ";
        sql += " from employees ";
        sql +=" where 1=1 ";
        if(StringUtils.isNotEmpty(employeeModel.getFirstName())){
            sql +=" and first_name = ?  ";
            paramList.add(employeeModel.getFirstName());
        }
        if(StringUtils.isNotEmpty(employeeModel.getLastName())){
            sql +=" and last_name = ?  ";
            paramList.add(employeeModel.getLastName());
        }
        if(StringUtils.isNotEmpty(employeeModel.getGender())){
            sql +=" and gender = ?  ";
            paramList.add(employeeModel.getGender());
        }
        if(null != employeeModel.getBirthDate1() && null == employeeModel.getBirthDate2()){
            sql +=" and birth_date = ?  ";
            paramList.add(employeeModel.getBirthDate1());
        }
        if(null != employeeModel.getBirthDate1() && null != employeeModel.getBirthDate2()){
            sql +=" and birth_date between ? and ? ";
            paramList.add(employeeModel.getBirthDate1());
            paramList.add(employeeModel.getBirthDate2());
        }

        List<EmployeeModel> result = this.jdbcTemplate.query(sql, new RowMapper<EmployeeModel>() {
            @Override
            public EmployeeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                EmployeeModel x = new EmployeeModel();
                int col = 1;
                x.setEmpNo(rs.getInt(col++));
                x.setBirthDate(rs.getDate(col++).toLocalDate());
                x.setFirstName(rs.getString(col++));
                x.setLastName(rs.getString(col++));
                x.setGender(rs.getString(col++));
                x.setHireDate(rs.getDate(col++).toLocalDate());
                return x;
            }
        }, paramList.toArray());

        return result;
    }
}
