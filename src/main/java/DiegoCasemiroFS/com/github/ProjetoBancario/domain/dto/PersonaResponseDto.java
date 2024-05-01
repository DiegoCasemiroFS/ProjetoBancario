package DiegoCasemiroFS.com.github.ProjetoBancario.domain.dto;

import DiegoCasemiroFS.com.github.ProjetoBancario.domain.enums.TypeKey;
import lombok.Data;

@Data
public class PersonaResponseDto {

  private Long id;
  private String name;
  private String cpf;
  private String email;
  private Integer typeKey;
  private Character gender;

  public TypeKey getTypeKey(){
    return TypeKey.toEnum(this.typeKey);
  }

  public void setTypeKey(TypeKey typeKey){
    this.typeKey = typeKey.getCod();
  }

}
