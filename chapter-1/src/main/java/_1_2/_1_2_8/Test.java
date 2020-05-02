package _1_2._1_2_8;

/**
 * 让多个线程之间的实例变量共享：以线程中的count实例变量为例【两种情况，一种是线程安全的，一种是线程不安全的】
 */
class MyThread2 extends Thread {
    private int count = 5;

    @Override
    public void run() {
        super.run();
        // 相比示例_1_2._1_2_8.MyThread，这里不使用while语句，否则会造成其他线程得不到运行机会的情况
        count--;
        System.out.println("由 " + this.currentThread().getName() + " 计算，count= " + count);
    }
}

class MyThread3 extends Thread {
    private int count = 5;

    /**
     * synchronized 可以对任意对象及方法加锁，加锁的这段代码称为互斥区或临界区
     */
    @Override
    synchronized public void run() {
        super.run();
        // 相比示例_1_2._1_2_8.MyThread，这里不使用while语句，否则会造成其他线程得不到运行机会的情况
        count--;
        System.out.println("由 " + this.currentThread().getName() + " 计算，count= " + count);
    }
}

public class Test {
    private static void test(Thread thread) {
        Thread a = new Thread(thread, "A");
        Thread b = new Thread(thread, "B");
        Thread c = new Thread(thread, "C");
        Thread d = new Thread(thread, "D");
        Thread e = new Thread(thread, "E");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

    public static void main(String[] args) {
        // 这种是线程不安全的
        test(new MyThread2());
        // 这种是线程安全的
        test(new MyThread3());
    }
}

