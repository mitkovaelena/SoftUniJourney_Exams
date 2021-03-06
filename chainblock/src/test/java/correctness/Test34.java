package correctness;

import chainblock.Chainblock;
import chainblock.IChainblock;
import chainblock.Transaction;
import chainblock.TransactionStatus;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test34 {

    //GetBySenderWithTransactionStatus
    @Test
    public void GetAllSendersWithTransactionStatus_ShouldWorkCorrectly()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        Transaction tx1 = new Transaction(5, TransactionStatus.Successfull, "joro", "pesho", 1);
        Transaction tx2 = new Transaction(6, TransactionStatus.Aborted, "joro", "pesho", 5.5);
        Transaction tx3 = new Transaction(7, TransactionStatus.Successfull, "joro", "pesho", 5.5);
        Transaction tx4 = new Transaction(12, TransactionStatus.Unauthorized, "boro", "pesho", 15.6);
        Transaction tx5 = new Transaction(15, TransactionStatus.Unauthorized, "moro", "pesho", 7.8);
        String[] expected = new String[]
                {
                        "boro", "moro"
                };
        //Act
        cb.add(tx1);
        cb.add(tx3);
        cb.add(tx2);
        cb.add(tx4);
        cb.add(tx5);
        ArrayList<String> list = new ArrayList<String>();
        Iterable<String> res = cb.getAllSendersWithTransactionStatus(TransactionStatus.Unauthorized);
        for(String tx : res){
            list.add(tx);
        }
        String[] actual = (String[])list.toArray();
        //Assert
        Assert.assertArrayEquals(expected, actual);
    }
}
