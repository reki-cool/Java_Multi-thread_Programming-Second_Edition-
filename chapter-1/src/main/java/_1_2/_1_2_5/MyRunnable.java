package _1_2._1_2_5;

/**
 * 实现Runnable接口
 * @author duyanhan
 *
 */
public class MyRunnable implements Runnable {


	public void run() {
		System.out.println("运行中！");
	}


	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable);
		thread.start();
		System.out.println("运行结束！");
	}

	// 与_1_2_1相比 ，只有使用线程的方式不同，一个通过继承Thread，一个通过实现Runnable接口

}
