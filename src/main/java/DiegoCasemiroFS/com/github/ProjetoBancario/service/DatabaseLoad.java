package DiegoCasemiroFS.com.github.ProjetoBancario.service;

import DiegoCasemiroFS.com.github.ProjetoBancario.domain.Agency;
import DiegoCasemiroFS.com.github.ProjetoBancario.domain.BankingCheckbook;
import DiegoCasemiroFS.com.github.ProjetoBancario.domain.CurrentAccount;
import DiegoCasemiroFS.com.github.ProjetoBancario.domain.Persona;
import DiegoCasemiroFS.com.github.ProjetoBancario.domain.enums.TypeKey;
import DiegoCasemiroFS.com.github.ProjetoBancario.repository.AgencyRepository;
import DiegoCasemiroFS.com.github.ProjetoBancario.repository.BankingCheckbookRepository;
import DiegoCasemiroFS.com.github.ProjetoBancario.repository.CurrentAccountRepository;
import DiegoCasemiroFS.com.github.ProjetoBancario.repository.PersonaRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseLoad {

  @Autowired
  private AgencyRepository agencyRepository;

  @Autowired
  private PersonaRepository personaRepository;

  @Autowired
  private CurrentAccountRepository currentAccountRepository;

  @Autowired
  private BankingCheckbookRepository bankingCheckbookRepository;

  public void instantiateDataBaseWithResources() {
    Agency agency = new Agency("Santo Amaro", "0001", "Rua das Flores");

    Persona pessoa = new Persona("Leo", "email@gmail.com", "123456", "17633564776");
    pessoa.setTypeKey(TypeKey.CPF);

    BankingCheckbook checkbook = BankingCheckbook.builder().value(BigDecimal.TEN).whenCreated(
            LocalDateTime.now()).number(154547).numberOfPages(5).build();

    CurrentAccount account = new CurrentAccount();
    account.setAgency(agency);
    account.setPersona(pessoa);
    account.setNumber("12");
    account.setBalance(BigDecimal.ZERO);

    Agency savedAgency = agencyRepository.save(agency);
    personaRepository.save(pessoa);
    bankingCheckbookRepository.save(checkbook);
    currentAccountRepository.save(account);

    savedAgency.setCurrentAccounts(Set.of(account));
    agencyRepository.save(savedAgency);
  }

}