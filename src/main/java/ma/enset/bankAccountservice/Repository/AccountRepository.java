package ma.enset.bankAccountservice.Repository;

import ma.enset.bankAccountservice.Entities.BankAccount;
import ma.enset.bankAccountservice.Enum.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RepositoryRestResource //Spring Data Rest
public interface AccountRepository extends JpaRepository<BankAccount, String>{
    @RestResource(path = "/byType")
    public List<BankAccount> findByType( @Param("t") AccountType accountType);
//    @Query ("SELECT B FROM BankAccount B where B.balance between 0 and 1000")
//    public List<BankAccount> accuracyBetween();

}
