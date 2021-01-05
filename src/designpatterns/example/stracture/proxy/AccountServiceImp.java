package designpatterns.example.stracture.proxy;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccountServiceImp implements AccountService {

    static {
        AccountServiceImp.accounts = new ConcurrentHashMap<>();
        AccountServiceImp.accounts.put(1L, BigDecimal.valueOf(0));
        AccountServiceImp.accounts.put(2L, BigDecimal.valueOf(0));
        AccountServiceImp.accounts.put(3L, BigDecimal.valueOf(0));
    }

    private static Map<Long, BigDecimal> accounts;

    public AccountServiceImp() {

    }

    public void deposit(long accountId, BigDecimal amount) {
        accounts.merge(accountId, amount, BigDecimal::add);
    }

    public void withdraw(long accountId, BigDecimal amount) {
        accounts.merge(accountId, amount, (oldVal, val) -> {
            if (oldVal.subtract(val).compareTo(BigDecimal.ZERO) < 0) {
                throw new RuntimeException("Insufficient Balance");
            } else {
                return oldVal.subtract(val);
            }
        });
    }

    public BigDecimal checkBalance(long accountId) {
        return accounts.get(accountId);
    }

}
