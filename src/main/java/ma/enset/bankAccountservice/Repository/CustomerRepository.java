package ma.enset.bankAccountservice.Repository;

import ma.enset.bankAccountservice.Entities.BankAccount;
import ma.enset.bankAccountservice.Entities.Customer;
import ma.enset.bankAccountservice.Enum.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, String>{

}
