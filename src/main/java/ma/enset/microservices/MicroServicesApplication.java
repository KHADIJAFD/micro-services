package ma.enset.microservices;

import ma.enset.microservices.entities.BankAccount;
import ma.enset.microservices.entities.Customer;
import ma.enset.microservices.enums.AccountStatus;
import ma.enset.microservices.repositories.BankAccountRepository;
import ma.enset.microservices.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class MicroServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServicesApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
        return args -> {

            Stream.of("khadija","hamza","zineb","imane").forEach(c->{
                Customer customer = Customer.builder()
                        .name(c)
                        .build();
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer ->{
                for (int i=0;i<5;i++) {
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .balance(2000+Math.random())
                            .createdAt(new Date())
                            .currency("MAD")
                            .accountStatus(Math.random() > 0.5 ? AccountStatus.CurrentAccount : AccountStatus.SavingAccount)
                            .build();
                    bankAccountRepository.save(bankAccount);
                }
            });

        };
    }
}
