package ma.enset.microservices.repositories;

import ma.enset.microservices.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
