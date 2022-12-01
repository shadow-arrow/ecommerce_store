package hopkq.store;

import hopkq.store.utils.DataTransferObject;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StoreApplication {

    @Bean //  Initialize Class DTO by inject
    public DataTransferObject dto() {
        return new DataTransferObject();
    }

    @Bean
    public BCrypt bCrypt() {
        return new BCrypt();
    }

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

}
