package _1_2._1_2_3;

/**
 * �̵߳��õ������
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
		// �������̣߳������߳�ִ��ѭ������
		MyThread myThread = new MyThread();
		myThread.setName("myThread");
		myThread.start();
		
		// ͬʱ��Ҳִ�����߳��е�ѭ��
		for (int i = 0; i < 10000; i++) {
			System.out.println("main=" + Thread.currentThread().getName());
		}
	}

}
