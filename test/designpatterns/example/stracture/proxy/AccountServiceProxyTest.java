package designpatterns.example.stracture.proxy;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountServiceProxyTest {


    @Test
    public void successfulTransactions() {

        BigDecimal initialDeposit = BigDecimal.valueOf(100);

        long adminUserId = 30L;
        long customerServiceUserId = 20L;
        long accountHolderUserId = 10L;

        long accountId1 = 1;
        long accountId2 = 2;
        long accountId3 = 3;

        AccountServiceProxy accountServiceProxy = new AccountServiceProxy();
        accountServiceProxy.deposit(adminUserId, accountId1, initialDeposit);
        accountServiceProxy.deposit(adminUserId, accountId2, initialDeposit);
        accountServiceProxy.deposit(adminUserId, accountId3, initialDeposit);

        BigDecimal balance = accountServiceProxy.checkBalance(adminUserId, accountId3);

        BigDecimal expectedBalanceAfterInitialDeposit = BigDecimal.valueOf(100);

        assertEquals(expectedBalanceAfterInitialDeposit, balance);

        accountServiceProxy.withdraw(adminUserId, accountId3, initialDeposit);

        BigDecimal balanceAfterWithdraw = accountServiceProxy.checkBalance(adminUserId, accountId3);

        BigDecimal expectedBalanceAfterWithdrawInitialDeposit = BigDecimal.ZERO;

        assertEquals(expectedBalanceAfterWithdrawInitialDeposit, balanceAfterWithdraw);

        BigDecimal amountExceedBalance = BigDecimal.valueOf(100);

        Exception balanceNotSufficientException = assertThrows(RuntimeException.class, () -> {
            accountServiceProxy.withdraw(accountHolderUserId, accountId1, amountExceedBalance);
            accountServiceProxy.withdraw(accountHolderUserId, accountId1, amountExceedBalance);
        });
        assertEquals("Insufficient Balance", balanceNotSufficientException.getMessage());

        Exception accessDeniedException = assertThrows(RuntimeException.class, () -> {
            accountServiceProxy.checkBalance(customerServiceUserId, accountId1);
        });
        assertEquals("Access Denied", accessDeniedException.getMessage());

    }

}
