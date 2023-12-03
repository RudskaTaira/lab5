
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class withdrawTest {
    BankAccount bankAccount ;

    @BeforeEach
    public void setUp() {
        bankAccount = new BankAccount("Sofia",new BigDecimal("12312.122"));
    }

    @Test
    void testWithdrawIsCorrect() throws NegativeAmountException {
        bankAccount.withdraw(new BigDecimal("123.92"));

        assertEquals(bankAccount.getBalance(), new BigDecimal("12188.202"));
    }
    @Test
    void testWithdrawThrowException()throws NegativeAmountException
    {


        Throwable exception = assertThrows(NegativeAmountException.class, () -> {
            bankAccount.withdraw(new BigDecimal("23244.30"));
        },"You have insufficient funds on the card");

    }

}