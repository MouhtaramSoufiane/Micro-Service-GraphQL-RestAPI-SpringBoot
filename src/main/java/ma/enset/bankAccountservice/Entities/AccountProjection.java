package ma.enset.bankAccountservice.Entities;

import ma.enset.bankAccountservice.Enum.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class,name = "projection")
public interface AccountProjection {
    public Double getBalance();
    public AccountType getType();
}
