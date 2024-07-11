package DiegoCasemiroFS.com.github.ProjetoBancario.config;

import DiegoCasemiroFS.com.github.ProjetoBancario.service.DatabaseLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private DatabaseLoad dbService;

    @Bean
    public boolean instantiateDatabase() {
        dbService.instantiateDataBaseWithResources();

        return true;
    }

}
