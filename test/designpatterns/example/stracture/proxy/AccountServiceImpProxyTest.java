package designpatterns.example.stracture.proxy;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountServiceImpProxyTest {


    @Test
    public void successfulTransactions() {

        BigDecimal initialDeposit = BigDecimal.valueOf(100);

        long adminUserId = 30L;
        long customerServiceUserId = 20L;
        long accountHolderUserId = 10L;

        long accountId1 = 1;
        long accountId2 = 2;
        long accountId3 = 3;

        AccountService adminAccessAccountService = new AccountServiceProxy(adminUserId);
        adminAccessAccountService.deposit(accountId1, initialDeposit);

        AccountService customerServiceAccessAccountService = new AccountServiceProxy(customerServiceUserId);
        customerServiceAccessAccountService.deposit(accountId2, initialDeposit);

        AccountService accountHolderAccessAccountService = new AccountServiceProxy(accountHolderUserId);
        accountHolderAccessAccountService.deposit(accountId1, initialDeposit);

        adminAccessAccountService.deposit(accountId2, initialDeposit);
        customerServiceAccessAccountService.deposit(accountId3, initialDeposit);

        BigDecimal balance = accountHolderAccessAccountService.checkBalance(accountId1);

        BigDecimal expectedBalanceAfterInitialDeposit = BigDecimal.valueOf(200);

        assertEquals(expectedBalanceAfterInitialDeposit, balance);

        accountHolderAccessAccountService.withdraw(accountId1, initialDeposit);

        BigDecimal balanceAfterWithdraw = accountHolderAccessAccountService.checkBalance(accountId1);

        BigDecimal expectedBalanceAfterWithdrawInitialDeposit = BigDecimal.valueOf(100);

        assertEquals(expectedBalanceAfterWithdrawInitialDeposit, balanceAfterWithdraw);

        BigDecimal amountExceedBalance = BigDecimal.valueOf(200);

        Exception balanceNotSufficientException = assertThrows(RuntimeException.class, () -> {
            accountHolderAccessAccountService.withdraw(accountId1, amountExceedBalance);
        });
        assertEquals("Insufficient Balance", balanceNotSufficientException.getMessage());

        Exception accessDeniedException = assertThrows(RuntimeException.class, () -> {
            customerServiceAccessAccountService.checkBalance(accountId1);
        });
        assertEquals("Access Denied", accessDeniedException.getMessage());

    }

}
