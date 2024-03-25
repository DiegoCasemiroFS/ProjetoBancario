package DiegoCasemiroFS.com.github.ProjetoBancario.repository;

import DiegoCasemiroFS.com.github.ProjetoBancario.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
