package ma.enset.microservices.repositories;

import ma.enset.microservices.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String > {
}
