package ma.enset.microservices.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.enset.microservices.dtos.BankAccountDto;
import ma.enset.microservices.entities.BankAccount;
import ma.enset.microservices.repositories.BankAccountRepository;
import ma.enset.microservices.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BankAccountRestController {
    BankAccountService bankAccountService;
    BankAccountRepository bankAccountRepository;
    @GetMapping("/bankAccounts")
    public List<BankAccount> allBankAccount(){
        return bankAccountService.allAccounts();
    }
    @GetMapping("/bankAccountById")
    public BankAccount bankAccountById(String id){
        return bankAccountService.findAccountById(id);
    }
    @PostMapping("/saveAccount")
    public BankAccount saveBankAccount(@RequestBody BankAccountDto bankAccount){
        return bankAccountService.saveBankAccount(bankAccount);
    }

}
