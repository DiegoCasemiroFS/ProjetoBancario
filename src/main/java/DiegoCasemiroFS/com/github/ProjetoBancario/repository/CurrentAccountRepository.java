package DiegoCasemiroFS.com.github.ProjetoBancario.repository;

import DiegoCasemiroFS.com.github.ProjetoBancario.domain.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long> {

}
