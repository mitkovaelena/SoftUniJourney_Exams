package correctness;

import chainblock.Chainblock;
import chainblock.IChainblock;
import chainblock.Transaction;
import chainblock.TransactionStatus;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test21 {
    @Test
    public void GetByTransactionStatusAndMaximumAmount_ShouldReturnEmptyCollection()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(2, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx2 = new Transaction(1, TransactionStatus.Successfull, "valq", "pesho", 14.8);
        Transaction tx3 = new Transaction(4, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx4 = new Transaction(3, TransactionStatus.Successfull, "valq", "pesho", 15.6);
        Transaction tx5 = new Transaction(8, TransactionStatus.Failed, "valq", "pesho", 17.8);
        //Act
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        //Assert
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Iterable<Transaction> res = cb.getByTransactionStatusAndMaximumAmount(TransactionStatus.Unauthorized,5);
        for(Transaction tx : res){
            list.add(tx);
        }
        Transaction[] actual = (Transaction[])list.toArray();
        Assert.assertArrayEquals(new Transaction[0], actual);
        cb = new Chainblock();
        list = new ArrayList<Transaction>();
        res = cb.getByTransactionStatusAndMaximumAmount(TransactionStatus.Unauthorized,1);
        for(Transaction tx : res){
            list.add(tx);
        }
        actual = (Transaction[])list.toArray();
        Assert.assertArrayEquals(new Transaction[0], actual);
    }
}
