package ru.geekbrains.lesson3.count;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Farida Gareeva
 * Created 29.04.2020
 */
public class Main {
    public static void main(String[] args) {
        Count count = new Count();
        ReentrantLock lock = new ReentrantLock();
        Incrementor incrementor1 = new Incrementor(count, lock, "Первый поток");
        Incrementor incrementor2 = new Incrementor(count, lock, "Второй поток");
        try {
        Thread.sleep(2000);
        }catch (InterruptedException ex){
            System.out.println("Исключение прерывания потока "+Thread.currentThread().getName());
        }

        incrementor1.t.interrupt();
        incrementor2.t.interrupt();
        System.out.println("Состояние потока "+incrementor1.t.getName()+" "+incrementor1.t.getState());
        System.out.println("Состояние потока "+incrementor2.t.getName()+" "+incrementor2.t.getState());
    }
}
