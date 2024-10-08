package ma.enset.microservices.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.enset.microservices.dtos.BankAccountDto;
import ma.enset.microservices.entities.BankAccount;
import ma.enset.microservices.mappers.BankAccountMapper;
import ma.enset.microservices.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
@AllArgsConstructor
public class BankAccountService {
    BankAccountRepository bankAccountRepository;
    BankAccountMapper bankAccountMapper;

    public List<BankAccount> allAccounts(){
        return bankAccountRepository.findAll();
    }
    public BankAccount findAccountById(String id){
        return bankAccountRepository.findById(id).get();
    }
    public BankAccount saveBankAccount(BankAccountDto bankAccountDto){
        BankAccount bankAccount=bankAccountMapper.from(bankAccountDto);
        return  bankAccountRepository.save(bankAccount);
    }
    public BankAccount updateAccount(String id,BankAccountDto bankAccountDto){
        BankAccount bankAccount=bankAccountRepository.findById(id).get();
        bankAccount.setBalance(bankAccountDto.getBalance());
        bankAccount.setCurrency(bankAccountDto.getCurrency());
        bankAccount.setCreatedAt(bankAccountDto.getCreatedAt());
        bankAccount.setAccountStatus(bankAccountDto.getAccountStatus());
        return bankAccountRepository.save(bankAccount);
    };
    public Boolean deleteById(String id){
        bankAccountRepository.deleteById(id);
        return true;
    }
}
