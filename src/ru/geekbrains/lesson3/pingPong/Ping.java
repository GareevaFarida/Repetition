package ru.geekbrains.lesson3.pingPong;

/**
 * @Author Farida Gareeva
 * Created 29.04.2020
 */
public class Ping implements Runnable {

    Ball ball;
    Thread t;

    public Ping(Ball ball) {
        this.ball = ball;
        this.t = new Thread(this, "Ping");
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            if(t.isInterrupted()) break;
            ball.ping();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException ex){
                System.out.println("Прерван спящий поток Ping");
                break;
            }
        }
    }
}
