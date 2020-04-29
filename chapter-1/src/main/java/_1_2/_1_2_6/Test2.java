package _1_2._1_2_6;

/**
 * 将一个Thread对象中的run()方法交由其他线程进行调用：因为Thread本身也实现了Runnable接口
 * @author duyanhan
 *
 */
/**
 * 业务A2类
 * @author duyanhan
 *
 */
class AServer2 extends Thread{
	public void a2_save_method() {
		System.out.println("a2中的保存数据方法被执行");
	}
	@Override
	public void run() {
		super.run();
		a2_save_method();
	}
}


public class Test2{

	public static void main(String[] args) {
		// 因为Thread类本身也实现了Runnable接口，所以构造函数Thread(Runnable target)不仅可以传入Runnable接口的对象，也可以传入一个Thread类的对象
		Thread BThread = new Thread(new AServer2());
		BThread.start();
		System.out.println("运行结束！");
	}

}
