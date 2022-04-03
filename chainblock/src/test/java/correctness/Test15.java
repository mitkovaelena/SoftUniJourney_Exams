package correctness;

import chainblock.Chainblock;
import chainblock.IChainblock;
import chainblock.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test15 {
    @Test
    public void GetAllOrderedByAmountDescendingThenById_ShouldReturnEmpty_OnEmptyCB()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        //Act
        Transaction[] actual = iterableToArray(cb.getAllOrderedByAmountDescendingThenById());
        //Assert
        Assert.assertArrayEquals(new Transaction[0], actual);
    }
    private Transaction[] iterableToArray(Iterable<Transaction> iterable){
        List<Transaction> list = new ArrayList<Transaction>();
        for(Transaction tx : iterable){
            list.add(tx);
        }
        Object[] arr = list.toArray();
        Transaction[] transactionsArr = new Transaction[arr.length];
        for (int i = 0; i < transactionsArr.length; i++) {
            transactionsArr[i] = (Transaction) arr[i];

        }
        return transactionsArr;
    }
}
