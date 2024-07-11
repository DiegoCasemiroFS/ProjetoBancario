package DiegoCasemiroFS.com.github.ProjetoBancario.service.imp;

import DiegoCasemiroFS.com.github.ProjetoBancario.domain.Agency;
import DiegoCasemiroFS.com.github.ProjetoBancario.domain.BankingCheckbook;
import DiegoCasemiroFS.com.github.ProjetoBancario.domain.CurrentAccount;
import DiegoCasemiroFS.com.github.ProjetoBancario.domain.dto.AgencyRequestDto;
import DiegoCasemiroFS.com.github.ProjetoBancario.domain.dto.AgencyResponseDto;
import DiegoCasemiroFS.com.github.ProjetoBancario.domain.dto.AgencyUpdateRequestDto;
import DiegoCasemiroFS.com.github.ProjetoBancario.domain.dto.BankingCheckbookDto;
import DiegoCasemiroFS.com.github.ProjetoBancario.exception.ObjectNotFoundException;
import DiegoCasemiroFS.com.github.ProjetoBancario.repository.AgencyRepository;
import DiegoCasemiroFS.com.github.ProjetoBancario.repository.BankingCheckbookRepository;
import DiegoCasemiroFS.com.github.ProjetoBancario.repository.CurrentAccountRepository;
import DiegoCasemiroFS.com.github.ProjetoBancario.service.AgencyServiceInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AgencyService implements AgencyServiceInterface {

  private final AgencyRepository agencyRepository;
  private final BankingCheckbookRepository checkbookRepository;
  private final CurrentAccountRepository accountRepository;
  private final ObjectMapper mapper;

  @Autowired
  public AgencyService(AgencyRepository agencyRepository,
                       BankingCheckbookRepository checkbookRepository, CurrentAccountRepository accountRepository,
                       ObjectMapper mapper) {
    this.agencyRepository = agencyRepository;
    this.checkbookRepository = checkbookRepository;
    this.accountRepository = accountRepository;
    this.mapper = mapper;
  }

  @Transactional
  public Agency createAgency(AgencyRequestDto agencyDto) {
    Agency agency = mapper.convertValue(agencyDto, Agency.class);

    return agencyRepository.save(agency);
  }

  public AgencyResponseDto readAgencyById(Long id) {
    Optional<Agency> optionalAgency = agencyRepository.findById(id);

    if (optionalAgency.isEmpty()) {
      throw new ObjectNotFoundException("Agency not found with id: " + id);
    }

    ObjectMapper objectMapper = new ObjectMapper();
    AgencyResponseDto result = objectMapper.convertValue(optionalAgency.get(),
            AgencyResponseDto.class);

    return result;
  }

  public AgencyResponseDto updateAgency(Long id, AgencyUpdateRequestDto dto) {
    Optional<Agency> optionalAgency = agencyRepository.findById(id);

    if (optionalAgency.isEmpty()) {
      throw new ObjectNotFoundException("Agency not found with id: " + id);
    }

    Agency agency = optionalAgency.get();
    agency.setNumber(dto.getNumber());
    agency.setAddress(dto.getAddress());

    Agency savedAgency = agencyRepository.save(agency);

    return mapper.convertValue(savedAgency, AgencyResponseDto.class);
  }

  public void deleteAgency(Long id) {
    readAgencyById(id);
    agencyRepository.deleteById(id);
  }

  @Transactional
  public BankingCheckbook createCheckbook(BankingCheckbookDto checkbookDto) {
    BankingCheckbook checkbook = new BankingCheckbook();
    checkbook.setValue(new BigDecimal(checkbookDto.getValue()));

    Optional<CurrentAccount> receivedAccount = accountRepository.findById(
            checkbookDto.getCurrentAccount());

    if (receivedAccount.isPresent()) {
      checkbook.setCurrentAccount(receivedAccount.get());
    }

    checkbook.generatedNumber();
    checkbook.setNumberOfPages(50);
    checkbook.setWhenCreated(LocalDateTime.now());

    return checkbookRepository.save(checkbook);
  }

}