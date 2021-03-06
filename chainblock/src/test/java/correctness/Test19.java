package correctness;

import chainblock.Chainblock;
import chainblock.IChainblock;
import chainblock.Transaction;
import chainblock.TransactionStatus;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class Test19 {
    //Enumerator
    @Test
    public void CB_ShouldBeEnumeratedIn_InsertionOrder()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5);
        Transaction[] expected = new Transaction[]
                {
                        tx1,tx3,tx2
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        for(Transaction tx : cb){
            list.add(tx);
        }
        Transaction[] actual = (Transaction[])list.toArray();
        //Assert
        Assert.assertArrayEquals(expected, actual);
    }

}
