package designpatterns.example.stracture.proxy;

import java.math.BigDecimal;

public interface AccountService {

    void deposit(long accountId, BigDecimal amount);

    void withdraw(long accountId, BigDecimal amount);

    BigDecimal checkBalance(long accountId);
}
