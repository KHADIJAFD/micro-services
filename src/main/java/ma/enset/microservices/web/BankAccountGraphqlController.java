package ma.enset.microservices.web;

import lombok.AllArgsConstructor;
import ma.enset.microservices.dtos.BankAccountDto;
import ma.enset.microservices.entities.BankAccount;
import ma.enset.microservices.entities.Customer;
import ma.enset.microservices.repositories.CustomerRepository;
import ma.enset.microservices.service.BankAccountService;
import org.hibernate.usertype.CompositeUserType;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class BankAccountGraphqlController {
    BankAccountService bankAccountService;
    CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount> allAccounts(){
        return bankAccountService.allAccounts();
    }

    @QueryMapping
    public BankAccount accountsById(@Argument String id){
        return bankAccountService.findAccountById(id);
    }
    @MutationMapping
    public BankAccount saveBankAccount(@Argument BankAccountDto bankAccountDto){
        return bankAccountService.saveBankAccount(bankAccountDto);
    }
    @MutationMapping
    public BankAccount updateAccount(@Argument String id,@Argument BankAccountDto bankAccountDto){
        return bankAccountService.updateAccount(id,bankAccountDto);
    }
    @MutationMapping
    public Boolean deleteById(@Argument String id){
        return bankAccountService.deleteById(id);
    }
    @QueryMapping
    public List<Customer> allCustomers(){
        return customerRepository.findAll();
    }

}
