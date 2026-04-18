package com.codejourney.threading;

/**
 * Problem: Use two threads (t1 and t2) to print numbers 1 to 10 in strict
 *          sequential order — t2 prints odd numbers, t1 prints even numbers —
 *          coordinated so the output is exactly: 1 2 3 4 5 6 7 8 9 10.
 *
 * Approach (synchronized + wait/notify):
 *   Both threads share a common lock object.
 *   Each thread holds the lock for its full run.
 *   When a thread encounters a number it is NOT responsible for, it calls
 *   lock.wait() to release the lock and pause.
 *   After printing its number, it calls lock.notify() to wake the other thread.
 *   This ping-pong between wait and notify ensures strict ordering.
 *
 * Important Methods:
 *   synchronized(lock) { ... }
 *   lock.wait()                // releases lock and suspends current thread
 *   lock.notify()              // wakes up ONE waiting thread on the same lock
 *   thread.start()
 *
 * Note: t2 (odd printer) is started after t1 so t2 acquires the lock first
 *       and prints 1, then notifies t1 to print 2, and so on.
 */
public class EvenOddPrintThreads {

    public static void main(String[] args) {
        Object lock = new Object();

        // t1 handles even numbers (2, 4, 6, 8, 10)
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    lock.notify();
                }
            }
        }, "EvenThread");

        // t2 handles odd numbers (1, 3, 5, 7, 9)
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    if (i % 2 != 0) {
                        System.out.println(i);
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    lock.notify();
                }
            }
        }, "OddThread");

        t1.start();
        t2.start();
    }
}
