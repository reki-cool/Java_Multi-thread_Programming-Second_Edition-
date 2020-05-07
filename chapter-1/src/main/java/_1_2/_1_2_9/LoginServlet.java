package _1_2._1_2_9;

/**
 * 模拟一个 Servlet 组件
 */
public class LoginServlet {

    private static String usernameRef;
    private static String passwordRef;

    public static void doPost(String username, String password) {
        try{
            usernameRef = username;
            if (username.equals("a")) {
                // 这里故意停滞5秒
                Thread.sleep(5000);
            }
            passwordRef = password;

            System.out.println("username=" + usernameRef + " password=" + passwordRef);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 模拟一个线程 A
 */
class ALogin extends Thread{
    @Override
    public void run() {
        super.run();
        LoginServlet.doPost("a", "aa");
    }
}
/**
 * 模拟一个线程 B
 */
class BLogin extends Thread{
    @Override
    public void run() {
        super.run();
        LoginServlet.doPost("b", "bb");
    }
}

class Run {
    public static void main(String[] args) {
        ALogin a = new ALogin();
        a.start();
        BLogin b = new BLogin();
        b.start();

        /**
         * 这里极大概率是a先执行，因为 a.start()后面  才创建了b并再在之后才启动b
         * 这里针对a线程特意阻塞5秒
         * 会导致b线程先执行完，可以得出一个结果
         * username=b password=bb   a   执行了一半   b   开始执行
         * username=b password=aa
         *
         * 如果写成如下形式
         * ALogin a = new ALogin();
         * BLogin b = new BLogin();
         * a.start();
         * b.start();
         * b先执行的概率就大大提升了，如果真的b线程先执行，那么就可能得到如下结果
         * username=b password=bb   b   完全结束之后      a 开始执行
         * username=a password=aa
         * 或者
         * username=a password=bb   b   没完全执行结束     a   线程开始了执行
         * username=a password=aa
         *
         *
         */
    }
    /**
     * 两个线程向同一个对象的public static void doPost(String username, String password)方法传递参数时，
     * 方法的参数值不会被覆盖，方法的参数值是绑定到当前执行线程上的
     */
}