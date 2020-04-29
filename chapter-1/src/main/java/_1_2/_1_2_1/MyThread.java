package _1_2._1_2_1;
/**
 * 继承Thread类
 * @author duyanhan
 *
 */
public class MyThread extends Thread {

	@Override
	public void run() {
		super.run();
		System.out.println("MyThread");
	}

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();// 这个耗时大
		System.out.println("运行结束！");// 耗时小
		
//		运行结果：
//		运行结束！
//		MyThread

	}
}