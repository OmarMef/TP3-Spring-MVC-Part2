package omar.tp3mvchopital;

import omar.tp3mvchopital.entities.Patient;
import omar.tp3mvchopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class Tp3MvcHopitalApplication{

    public static void main(String[] args) {
        SpringApplication.run(Tp3MvcHopitalApplication.class, args);
    }

    //@Bean
    CommandLineRunner commandLineRunner (PatientRepository patientRepository) {
        return args -> {

            patientRepository.save(new Patient(null,"Othmane",new Date(),false,120));
            patientRepository.save(new Patient(null,"Omar",new Date(),false,116));
            patientRepository.save(new Patient(null,"Badr",new Date(),false,110));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getName());
            });
        };
    }
}
