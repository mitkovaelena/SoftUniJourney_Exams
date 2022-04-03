package correctness;

import chainblock.Chainblock;
import chainblock.IChainblock;
import org.junit.Assert;
import org.junit.Test;

public class Test46 {
    @Test
    public void GetByReceiver_ShouldThrow_On_EmptyCB()
    {
        //Arrange
        IChainblock cb = new Chainblock();
        //Act
        //Assert
        boolean threw = false;
        try{
            cb.getByReceiverOrderedByAmountThenById("pesho").iterator().next();
        }catch(IllegalArgumentException ex){
            threw = true;
        }
        Assert.assertTrue(threw);
    }

    //GetBySenderAndMinimumAmountDescending
}
