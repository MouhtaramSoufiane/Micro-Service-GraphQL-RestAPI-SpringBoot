package ma.enset.bankAccountservice.AccountMappers;

import ma.enset.bankAccountservice.Entities.BankAccount;
import ma.enset.bankAccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankAccountservice.dto.BankAccountResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AccountMapper {
    public BankAccountResponseDTO from(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO   = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }

    public BankAccount from(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = new BankAccount();

        BeanUtils.copyProperties(bankAccount, bankAccountRequestDTO);
        return bankAccount;
    }
}
