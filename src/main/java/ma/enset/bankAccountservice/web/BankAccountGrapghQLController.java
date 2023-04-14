package ma.enset.bankAccountservice.web;

import ma.enset.bankAccountservice.Entities.BankAccount;
import ma.enset.bankAccountservice.Entities.Customer;
import ma.enset.bankAccountservice.Repository.AccountRepository;
import ma.enset.bankAccountservice.Repository.CustomerRepository;
import ma.enset.bankAccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankAccountservice.dto.BankAccountResponseDTO;
import ma.enset.bankAccountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGrapghQLController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount> accountList() {
        return accountRepository.findAll();
    }

    @QueryMapping
    public BankAccount accountById( @Argument String id) {

        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
        accountService.deleteAccount(id);
        return true;
    }
    @QueryMapping
    public List<Customer> customers(){

        return customerRepository.findAll();
    }
}
