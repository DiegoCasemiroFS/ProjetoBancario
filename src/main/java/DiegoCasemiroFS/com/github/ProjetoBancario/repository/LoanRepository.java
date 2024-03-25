package DiegoCasemiroFS.com.github.ProjetoBancario.repository;

import DiegoCasemiroFS.com.github.ProjetoBancario.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
