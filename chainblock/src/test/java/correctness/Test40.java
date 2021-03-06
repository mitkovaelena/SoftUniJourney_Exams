package correctness;

import chainblock.Chainblock;
import chainblock.IChainblock;
import chainblock.Transaction;
import chainblock.TransactionStatus;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test40 {
    //GetByReceiverAndAmountRange
    @Test
    public void GetByReceiverAndAmountRange_ShouldWorkCorrectly_On_CorrectRange()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx4 = new Transaction(12, TransactionStatus.Successfull, "joro", "pesho", 15.6);
        Transaction tx5 = new Transaction(15, TransactionStatus.Failed, "joro", "resho", 7.8);
        Transaction[] expected = new Transaction[]
                {
                        tx4, tx2, tx3, tx1
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        //Assert
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getByReceiverAndAmountRange("pesho", 0, 20);
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = (Transaction[])list.toArray();
        Assert.assertArrayEquals(expected, actual);

    }
}
