package _1_2._1_2_6;

/**
 * 使用Runnable接口实现多线程的优点：解决Java不支持多继承带来的限制问题
 * @author duyanhan
 *
 */
/**
 * 业务A类
 * @author duyanhan
 *
 */
class AServer{
	public void a_save_method() {
		System.out.println("a中的保存数据方法被执行");
	}
}

/**
 * 原先希望继承AServer和Thread类，奈何Java不支持多继承
 * 解决Java不支持多继承带来的限制问题
 * @author duyanhan
 *
 */
class Bserver extends AServer implements Runnable{

	public void b_save_method() {
		System.out.println("b中的保存数据方法被执行");
	}
	
	@Override
	public void run() {
		a_save_method();
		b_save_method();
	}
	
	
}

public class Test{

	public static void main(String[] args) {
		Thread BThread = new Thread(new Bserver());
		BThread.start();
		System.out.println("运行结束！");
	}

}
