package DiegoCasemiroFS.com.github.ProjetoBancario.controller;

import DiegoCasemiroFS.com.github.ProjetoBancario.domain.Agency;
import DiegoCasemiroFS.com.github.ProjetoBancario.domain.dto.AgencyRequestDto;
import DiegoCasemiroFS.com.github.ProjetoBancario.service.AgencyService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(value = "/agencies")
public class AgencyController {

  @Autowired
  private AgencyService agencyService;

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> createAgency(@RequestBody AgencyRequestDto agencyDto) {
    Agency savedAgency = null;

    try {
      savedAgency = agencyService.createAgency(agencyDto);
    } catch (DataIntegrityViolationException e) {
      return ResponseEntity.badRequest().build();
    }

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(savedAgency.getId()).toUri();

    return ResponseEntity.created(uri).build();
  }

}