package ru.geekbrains.lesson3.count;

/**
 * @Author Farida Gareeva
 * Created 29.04.2020
 * класс, содержащий счетчик
 */
public class Count {
    private int sum = 0;
    public void increment(){
        sum++;
    }

    public int getSum() {
        return sum;
    }
}
