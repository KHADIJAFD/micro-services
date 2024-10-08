package ma.enset.microservices.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import ma.enset.microservices.enums.AccountStatus;

import java.util.Date;

@Data @AllArgsConstructor
public class BankAccountDto {
    private Double balance;
    private String currency;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
}
