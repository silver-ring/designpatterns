package designpatterns.example.stracture.proxy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Work as interceptor to add cross cut functionality ex. logging, security
 */

public class AccountServiceProxy implements AccountService {

    static {
        AccountServiceProxy.access = new ConcurrentHashMap<>();
        AccountServiceProxy.access.put(10L, List.of(1L));
        AccountServiceProxy.access.put(20L, List.of(2L, 3L));
        AccountServiceProxy.access.put(30L, List.of(1L, 2L, 3L));
    }

    private final AccountServiceImp accountServiceImp;
    private static Map<Long, List<Long>> access;

    private final long userId;

    public AccountServiceProxy(long userId) {
        this.accountServiceImp = new AccountServiceImp();
        this.userId = userId;
    }

    public void deposit(long accountId, BigDecimal amount) {
        if (access.get(this.userId).contains(accountId)) {
            this.accountServiceImp.deposit(accountId, amount);
        } else {
            throw new RuntimeException("Access Denied");
        }

    }

    public void withdraw(long accountId, BigDecimal amount) {
        if (access.get(this.userId).contains(accountId)) {
            this.accountServiceImp.withdraw(accountId, amount);
        } else {
            throw new RuntimeException("Access Denied");
        }
    }

    public BigDecimal checkBalance(long accountId) {
        if (access.get(this.userId).contains(accountId)) {
            return this.accountServiceImp.checkBalance(accountId);
        } else {
            throw new RuntimeException("Access Denied");
        }
    }

}
