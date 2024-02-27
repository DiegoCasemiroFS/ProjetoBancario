package DiegoCasemiroFS.com.github.ProjetoBancario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data //cria todos os getter, setter, toString e HashCode
@Builder //da pra criar o objeto de maneira mais pratica
@Entity //define uma classe do banco de dados
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

  @Id //define a primarykey do banco de dados
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  //define o tipo de gerador / cada numero é unico e não pode ser repetido
  private Long id;

  @Column(name = "name", nullable = false, length = 40) //define o padrão para a coluna
  private String name;

  @Email
  private String email;

  private String password;

  @CPF
  private String cpf;

  private LocalDate birthDay;

  private Character gendar;

  private LocalDate whenCreated;

  private LocalDate lastLogin;

}
