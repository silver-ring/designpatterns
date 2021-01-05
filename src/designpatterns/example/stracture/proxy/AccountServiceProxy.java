package designpatterns.example.stracture.proxy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Work as interceptor to add cross cut functionality ex. logging, security
 */

public class AccountServiceProxy {

    private final AccountService accountService;
    private final Map<Long, List<Long>> access;

    public AccountServiceProxy() {
        this.accountService = new AccountService();
        this.access = new ConcurrentHashMap<>();
        this.access.put(10L, List.of(1L));
        this.access.put(20L, List.of(2L, 3L));
        this.access.put(30L, List.of(1L, 2L, 3L));
    }

    public void deposit(long userId, long accountId, BigDecimal amount) {
        if (access.get(userId).contains(accountId)) {
            this.accountService.deposit(accountId, amount);
        } else {
            throw new RuntimeException("Access Denied");
        }

    }

    public void withdraw(long userId, long accountId, BigDecimal amount) {
        if (access.get(userId).contains(accountId)) {
            this.accountService.withdraw(accountId, amount);
        } else {
            throw new RuntimeException("Access Denied");
        }
    }

    public BigDecimal checkBalance(long userId, long accountId) {
        if (access.get(userId).contains(accountId)) {
            return this.accountService.checkBalance(accountId);
        } else {
            throw new RuntimeException("Access Denied");
        }
    }

}
