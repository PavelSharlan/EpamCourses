package by.bsu.logistics.entity;


import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Created by 7 on 02.06.2016.
 */
public class VanQueue {
    private final static Logger LOGGER = LogManager.getLogger(VanQueue.class);

    private ArrayList<Van> arrayList = new ArrayList<Van>();
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int indexPerishable;
    private final int MAX_CAPACITY = 40;

   public void addPerishable(Van van){
       lock.lock();
       try{
           arrayList.add(indexPerishable, van);
           condition.signal();
           indexPerishable ++;
       } finally{
           lock.unlock();
       }
   }

    public void addVan(Van van){
        lock.lock();
        try{
            arrayList.add(van);
            condition.signal();
        } finally{
            lock.unlock();
        }
    }

    public Van takeVan(){
        lock.lock();
        Van van;
        try {
            if (arrayList.isEmpty()){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    LOGGER.error("InterruptedException", e);
                }
            }
            van = arrayList.get(0);
            arrayList.remove(0);
        } finally {
            lock.unlock();
        }
        return van;
    }

    public void deleteVan(Van van){
        lock.lock();
        try{
            arrayList.remove(van);
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public boolean isEmpty(){
        lock.lock();
        try{
            return arrayList.isEmpty();
        } finally {
            lock.unlock();
        }
    }

    public int size(){
        lock.lock();
        try {
            return arrayList.size();
        } finally {
            lock.unlock();
        }
    }
}
