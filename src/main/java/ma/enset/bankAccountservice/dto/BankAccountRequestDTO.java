package ma.enset.bankAccountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.bankAccountservice.Enum.AccountType;

@Data @AllArgsConstructor @NoArgsConstructor  @Builder
public class BankAccountRequestDTO {
    private Double balance;
    private String currency;
    private AccountType type;
}
