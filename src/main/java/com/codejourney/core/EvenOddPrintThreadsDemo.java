package com.codejourney.core;

/*Write a Java program using two threads (t1 and t2) such that:
t1 prints even numbers from 1 to 10
t2 prints odd numbers from 1 to 10
The output should be strictly in order: 1 2 3 4 5 6 7 8 9 10*/
/*
Important methods:
  synchronized(lock)
  lock.wait()
  lock.notify()
*/
public class EvenOddPrintThreadsDemo {
  public static void main(String[] args) {
    Object lock = new Object();

    Thread t1 = new Thread() {
      @Override
      public void run() {
        synchronized (lock) {
          for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
              System.out.println(i);
            } else {
              try {
                lock.wait();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
            lock.notify();
          }
        }
      }
    };

    Thread t2 = new Thread() {
      @Override
      public void run() {
        synchronized (lock) {
          for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
              System.out.println(i);
            } else {
              try {
                lock.wait();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
            lock.notify();
          }
        }
      }
    };
    t1.start();
    t2.start();

  }

}