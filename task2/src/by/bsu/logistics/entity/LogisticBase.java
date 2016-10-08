package by.bsu.logistics.entity;

import by.bsu.logistics.generator.RandomGenerator;
import by.bsu.logistics.runner.VanRunner;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 7 on 02.06.2016.
 */
public class LogisticBase {
    private static LogisticBase instance;
    private static Lock lock = new ReentrantLock();
    private VanQueue vanQueue;
    private ArrayList<Terminal> terminals;
    private final int TERMINALS_COUNT = 4;

    private LogisticBase(){
        this.vanQueue = new VanQueue();
        this.terminals = new ArrayList<Terminal>();
        for (int i = 0; i < TERMINALS_COUNT; i++){
            terminals.add(new Terminal(RandomGenerator.getRandomMessageManager()));
        }
    }

    public VanQueue getVanQueue() {
        return vanQueue;
    }

    public void setTerminals(ArrayList<Terminal> terminals) {
        this.terminals = terminals;
    }

    public static LogisticBase getInstance(){
        lock.lock();
        try{
            if(instance == null){
                instance = new LogisticBase();
            }
            return instance;
        } finally {
            lock.unlock();
        }
    }

    public void acceptVan(Van van){
        lock.lock();
        try {
            if (van.isPerishable()){
                vanQueue.addPerishable(van);
            } else {
                vanQueue.addVan(van);
            }
        } finally {
            lock.unlock();
        }
    }

    public void serve(){
        VanRunner.vansRun();
        for (int i = 0; i < terminals.size(); i++){
            new Thread(terminals.get(i)).start();
        }
    }
}
