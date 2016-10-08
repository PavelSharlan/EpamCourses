package test.by.bsu.queue;
import by.bsu.logistics.entity.Purpose;
import by.bsu.logistics.entity.Van;
import by.bsu.logistics.entity.VanQueue;
import org.junit.Test;
import org.junit.Assert;

public class QueueTest {
    @Test
    public void takeVan(){
        VanQueue queue = new VanQueue();
        Van van1 = new Van(false, Purpose.LOAD, 1111);
        Van van2 = new Van(false, Purpose.LOAD, 2222);
        Van van3 = new Van(true, Purpose.LOAD, 3333);
        Van van4 = new Van(false, Purpose.LOAD, 4444);
        queue.addVan(van1);
        queue.addVan(van2);
        queue.addPerishable(van3);
        queue.addVan(van4);
        Van expected = queue.takeVan();
        Van actual = van3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size(){
        Van van1 = new Van(false, Purpose.LOAD, 1111);
        Van van2 = new Van(false, Purpose.LOAD, 2222);
        Van van3 = new Van(false, Purpose.LOAD, 3333);
        Van van4 = new Van(false, Purpose.LOAD, 4444);
        VanQueue queue = new VanQueue();
        queue.addVan(van1);
        queue.addVan(van2);
        queue.addVan(van3);
        queue.addVan(van4);
        int actual = 4;
        int expected = queue.size();
        Assert.assertEquals(expected, actual);
    }
}
