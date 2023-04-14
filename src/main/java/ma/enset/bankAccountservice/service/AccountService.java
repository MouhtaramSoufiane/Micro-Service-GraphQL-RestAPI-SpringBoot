package ma.enset.bankAccountservice.service;

import ma.enset.bankAccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankAccountservice.dto.BankAccountResponseDTO;


public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequest);
    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccount);
    Boolean deleteAccount(String id);
}
