package _1_2._1_2_8;

/**
 * 让多个线程之间的实例变量不共享：以线程中的count实例变量为例
 */
public class MyThread extends Thread {
    private int count = 5;

    public MyThread(String name) {
        super(name);
        // 设置线程名称
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count --;
            System.out.println("由 " + this.currentThread().getName() + " 计算，count= " + count);
        }
    }

    public static void main(String[] args) {
        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.start();
        b.start();
        c.start();
        // 实际运行中，abc三个线程内部的count数据不是共享的
    }
}
