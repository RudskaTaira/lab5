import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class findAccountTest {

    private Bank bank;

    @BeforeEach
    public void setUp() throws NegativeAmountException {
    bank = new Bank();
    bank.createAccount("Keya",new BigDecimal("1314.132"));
    bank.createAccount("Kaveh", new BigDecimal("2132.134"));
    bank.createAccount("Lisa",new BigDecimal("213.131"));
    bank.createAccount("Barbara",new BigDecimal("32.41"));
    }

    @Test
    void testFindAccountSuccessful() throws AccountNotFoundException{
        BankAccount bankTest = new BankAccount("Kaveh", new BigDecimal("2132.134"));
        assertEquals(bank.findAccount(2).getAccountSummary(),"Kaveh 2 2132.134");
    }
    @Test
    void testFindAccountThrowsException()throws AccountNotFoundException{
        assertThrows(AccountNotFoundException.class, () -> {
            bank.findAccount(5);
        },"Account not found");
    }
}