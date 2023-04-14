package ma.enset.bankAccountservice;

import ma.enset.bankAccountservice.Entities.BankAccount;
import ma.enset.bankAccountservice.Entities.Customer;
import ma.enset.bankAccountservice.Enum.AccountType;
import ma.enset.bankAccountservice.Repository.AccountRepository;
import ma.enset.bankAccountservice.Repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner Start(AccountRepository accountRepository, CustomerRepository customerRepository){
		return args -> {
			Stream.of("Soufiane","Yassine","Abdelghani","Asmae","Khalid").forEach(name -> {
				Customer customer= Customer.builder()
						.name(name)
						.build();
				customerRepository.save(customer);
			});
			customerRepository.findAll().forEach(customer -> {
				for(int i=0;i<5;i++){
					BankAccount bankAccount= BankAccount.builder()
							.id(UUID.randomUUID().toString())
							.balance(Math.random()*1000)
							.createdAt(new Date())
							.currency("MAD")
							.type(Math.random()>0.4 ? AccountType.SAVING_ACCOUNT : AccountType.CURRENT_ACCOUNT)
							.customer(customer)
							.build();
					accountRepository.save(bankAccount);
				}
			});
		};
	}
}
