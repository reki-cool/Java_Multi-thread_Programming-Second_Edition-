package _1_2._1_2_1;
/**
 * �̳�Thread��
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
		myThread.start();// �����ʱ��
		System.out.println("���н�����");// ��ʱС
		
//		���н����
//		���н�����
//		MyThread

	}
}
