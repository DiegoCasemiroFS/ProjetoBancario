package DiegoCasemiroFS.com.github.ProjetoBancario.service;

import DiegoCasemiroFS.com.github.ProjetoBancario.domain.Agency;
import DiegoCasemiroFS.com.github.ProjetoBancario.domain.dto.AgencyRequestDto;
import DiegoCasemiroFS.com.github.ProjetoBancario.domain.dto.AgencyResponseDto;
import DiegoCasemiroFS.com.github.ProjetoBancario.domain.dto.AgencyUpdateRequestDto;

public interface AgencyServiceInterface {

    Agency createAgency(AgencyRequestDto agencyDto);

    AgencyResponseDto readAgencyById(Long id);

    AgencyResponseDto updateAgency(Long id, AgencyUpdateRequestDto dto);

    void deleteAgency(Long id);

}