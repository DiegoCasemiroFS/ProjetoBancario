package DiegoCasemiroFS.com.github.ProjetoBancario.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankingUtils {

  @Bean
  public ModelMapper mapper() {
    return new ModelMapper();
  }

}