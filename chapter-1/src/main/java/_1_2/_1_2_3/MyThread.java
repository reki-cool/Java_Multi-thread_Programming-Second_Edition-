package _1_2._1_2_3;

/**
 * 线程调用的随机性
 * @author duyanhan
 *
 */
public class MyThread extends Thread {

	
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10000; i++) {
			System.out.println("run=" + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		// 启动子线程，让子线程执行循环操作
		MyThread myThread = new MyThread();
		myThread.setName("myThread");
		myThread.start();
		
		// 同时，也执行主线程中的循环
		for (int i = 0; i < 10000; i++) {
			System.out.println("main=" + Thread.currentThread().getName());
		}
	}

}
