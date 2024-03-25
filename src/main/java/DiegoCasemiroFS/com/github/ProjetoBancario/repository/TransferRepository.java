package DiegoCasemiroFS.com.github.ProjetoBancario.repository;

import DiegoCasemiroFS.com.github.ProjetoBancario.domain.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {

}
