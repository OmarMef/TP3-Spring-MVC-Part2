package omar.tp3mvchopital;

import omar.tp3mvchopital.entities.Patient;
import omar.tp3mvchopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class Tp3MvcHopitalApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp3MvcHopitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        patientRepository.save(new Patient(null,"Othmane",new Date(),false,20));
        patientRepository.save(new Patient(null,"Omar",new Date(),false,16));
        patientRepository.save(new Patient(null,"Badr",new Date(),false,10));

    }
}
