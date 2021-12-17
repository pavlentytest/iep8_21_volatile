package ru.samsung.itschool.mdev;

public class Main {

    // волатильность - изменяемость
    public volatile static boolean flag;

    public static void main(String[] args) {
	    new Main().doStart();
    }

    void doStart() {
        new Thread(gui).start();
        System.out.println("Старт интерфейса!");
        new Thread(logic).start();
        System.out.println("Старт логики!");
    }

    Runnable gui = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Стоп интерфейса!");
            flag = true;
        }
    };

    Runnable logic = new Runnable() {
        @Override
        public void run() {
            while(!flag) {
                // бесконечный цикл
            }
            System.out.println("Стоп логика!");
        }
    };
}
