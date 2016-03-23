package com.sreeni;

/**
 * Created by smadiraju on 2/17/16.
 */
public class ThreadTest  {
    Object lock1 = new Object();
    Object lock2 = new Object();
    public synchronized void syncthis(){
        //synchronized (this)
        {
            //syncmutex();
            try {
                System.out.println("Got 'this' syncthis");
                Thread.sleep(10000);
                System.out.println("Done with 'syncthis'");
            } catch (Exception ignore){}
        }
    }
    public synchronized void syncmutex(){
        //synchronized (lock1)
        {
            try {
                System.out.println("Got into 'syncmutex' ");
                Thread.sleep(100);
                System.out.println("Done with 'syncmutex'");
            } catch (Exception ignore){}
        }
    }

    public static void main(String[] args){
        final ThreadTest ttest = new ThreadTest();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ttest.syncthis();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ttest.syncmutex();
            }
        });
        t1.start();
        t2.start();
    }
}
