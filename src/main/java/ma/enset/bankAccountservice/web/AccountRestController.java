package ma.enset.bankAccountservice.web;

import lombok.AllArgsConstructor;
import ma.enset.bankAccountservice.Entities.BankAccount;
import ma.enset.bankAccountservice.Repository.AccountRepository;

import ma.enset.bankAccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankAccountservice.dto.BankAccountResponseDTO;
import ma.enset.bankAccountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AccountRestController {


    private AccountRepository accountRepository;

    private AccountService accountService;

    @GetMapping("/BankAccounts")

    public List<BankAccount> getBankAccounts(){
        return accountRepository.findAll();

    }
    @GetMapping("/BankAccounts/{id}")
    public BankAccount getBankAccount(@PathVariable String id){
      return accountRepository.findById(id).get();
    }

    @PostMapping("/BankAccount")
    public BankAccountResponseDTO saveAccount(@RequestBody BankAccountRequestDTO bankAccount){
        BankAccountResponseDTO responseDTO = accountService.addAccount(bankAccount);
        return responseDTO;
    }
    @PostMapping("/BankAccounts")
    public void saveAccounts(@RequestBody List<BankAccount> bankAccounts){
        accountRepository.saveAll(bankAccounts);
    }
    @PutMapping("/BankAccounts/{id}")
    public void update(@PathVariable String id,@RequestBody BankAccount Account){
        BankAccount bankAccount=accountRepository.findById(id).get();

        if(bankAccount.getCurrency()!=null)bankAccount.setCurrency(Account.getCurrency());
        if(bankAccount.getType()!=null)bankAccount.setType(Account.getType());
        if(bankAccount.getCreatedAt()!=null) bankAccount.setCreatedAt(new Date());
        if(bankAccount.getBalance()!=null) bankAccount.setBalance(Account.getBalance());
         accountRepository.save(bankAccount);

    }
    @DeleteMapping("/BankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        accountRepository.deleteById(id);

    }

}
