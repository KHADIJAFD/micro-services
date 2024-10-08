package ma.enset.microservices.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.microservices.enums.AccountStatus;

import java.util.Date;
@Entity
@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class BankAccount {
    @Id
    private String id;
    private Double balance;
    private String currency;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    @ManyToOne
    private Customer customer;
}
