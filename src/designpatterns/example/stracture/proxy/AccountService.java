package designpatterns.example.stracture.proxy;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccountService {

    private final Map<Long, BigDecimal> accounts;

    public AccountService() {
        this.accounts = new ConcurrentHashMap<>();
        this.accounts.put(1L, BigDecimal.valueOf(0));
        this.accounts.put(2L, BigDecimal.valueOf(0));
        this.accounts.put(3L, BigDecimal.valueOf(0));
    }

    public void deposit(long accountId, BigDecimal amount) {
        this.accounts.merge(accountId, amount, BigDecimal::add);
    }

    public void withdraw(long accountId, BigDecimal amount) {
            this.accounts.merge(accountId, amount, (oldVal, val)  -> {
                if (oldVal.subtract(val).compareTo(BigDecimal.ZERO) < 0) {
                    throw new RuntimeException("Insufficient Balance");
                } else {
                    return oldVal.subtract(val);
                }
            });
    }

    public BigDecimal checkBalance(long accountId) {
        return this.accounts.get(accountId);
    }

}
