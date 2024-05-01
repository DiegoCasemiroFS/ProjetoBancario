package DiegoCasemiroFS.com.github.ProjetoBancario.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonaRequestDto {

  @Email
  @NotNull
  private String email;

  @NotNull
  private String password;
}
