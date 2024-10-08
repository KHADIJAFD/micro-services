package ma.enset.microservices.mappers;

import lombok.AllArgsConstructor;
import ma.enset.microservices.dtos.BankAccountDto;
import ma.enset.microservices.entities.BankAccount;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {
    private ModelMapper modelMapper=new ModelMapper();

    public BankAccount from (BankAccountDto bankAccountDto){
        return modelMapper.map(bankAccountDto,BankAccount.class);
    }
}
