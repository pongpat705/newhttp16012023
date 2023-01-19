package th.co.priorsolution.training.newhttp.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import th.co.priorsolution.training.newhttp.entity.jpa.EmployeesEntity;

import java.util.List;

@Repository
public interface EmployeesRepository
        extends JpaRepository<EmployeesEntity, Integer>
        , PagingAndSortingRepository<EmployeesEntity, Integer>
{

    List<EmployeesEntity> findByLastName(String lastName);

}
