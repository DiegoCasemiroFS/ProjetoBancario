package DiegoCasemiroFS.com.github.ProjetoBancario.domain.enums;

import java.util.EnumSet;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FunctionEmployee {

  INTERN(0, "INTERN"),
  RECEPTIONIST(1, "RECEPTIONIST"),
  BANKER(2, "BANKER"),
  SECURITY(3, "SECURITY"),
  ANALYST(4, "ANALYST");

  private int cod;
  private String descricao;

  public static FunctionEmployee toEnum(Integer cod) {
    return EnumSet.allOf(FunctionEmployee.class).stream()
        .filter(e -> e.getCod() == (cod))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + cod));
  }
}
