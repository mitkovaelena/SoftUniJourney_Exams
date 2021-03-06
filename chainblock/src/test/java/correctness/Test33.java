package correctness;

import chainblock.Chainblock;
import chainblock.IChainblock;
import chainblock.Transaction;
import chainblock.TransactionStatus;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test33 {
    @Test
    public void GetAllInAmountRange_ShouldReturn_EmptyCollectionOnNonExistingRange()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(6, TransactionStatus.Successfull, "joro", "pesho", 2);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx4 = new Transaction(12, TransactionStatus.Successfull, "joro", "pesho", 15.6);
        Transaction tx5 = new Transaction(15, TransactionStatus.Successfull, "joro", "pesho", 7.8);
        Transaction[] expected = new Transaction[0];
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getAllInAmountRange(7.7, 7.75);
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = (Transaction[])list.toArray();
        //Assert
        Assert.assertArrayEquals(expected, actual);
        cb.removeTransactionById(12);
        cb.removeTransactionById(15);
        list = new ArrayList<Transaction>();
        res = cb.getAllInAmountRange(7.8, 16);
        for(Transaction tx : res){
            list.add(tx);
        }
        actual = (Transaction[])list.toArray();
        Assert.assertArrayEquals(expected, actual);
    }

}
