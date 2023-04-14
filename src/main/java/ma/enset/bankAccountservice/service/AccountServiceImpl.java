package ma.enset.bankAccountservice.service;

import lombok.AllArgsConstructor;
import ma.enset.bankAccountservice.AccountMappers.AccountMapper;
import ma.enset.bankAccountservice.Entities.BankAccount;
import ma.enset.bankAccountservice.Repository.AccountRepository;
import ma.enset.bankAccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankAccountservice.dto.BankAccountResponseDTO;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
@Component
@AllArgsConstructor

public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequest) {
        BankAccount bankAccount= BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(bankAccountRequest.getType())
                .currency(bankAccountRequest.getCurrency())
                .createdAt(new Date())
                .balance(bankAccountRequest.getBalance())
                .build();
        BankAccount account = accountRepository.save(bankAccount);

        BankAccountResponseDTO accountResponseDTO = accountMapper.from(account);

        return accountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccount) {
        BankAccount bankAccount1= BankAccount.builder()
                .id(id)
                .type(bankAccount.getType())
                .currency(bankAccount.getCurrency())
                .createdAt(new Date())
                .balance(bankAccount.getBalance())
                .build();
        BankAccount account = accountRepository.save(bankAccount1);

        BankAccountResponseDTO accountResponseDTO = accountMapper.from(account);

        return accountResponseDTO;
    }

    @Override
    public Boolean deleteAccount(String id) {
        BankAccount bankAccount1 = accountRepository.findById(id).get();
        accountRepository.delete(bankAccount1);
return true;
    }
}
