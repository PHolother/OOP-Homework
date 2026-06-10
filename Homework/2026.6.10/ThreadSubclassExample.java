package Blog610;

/**
 * 使用Thread子类创建线程的示例
 * 
 * 特点：
 * 1. 继承Thread类，重写run()方法
 * 2. 直接通过start()方法启动线程
 * 3. 简单直观，但受限于Java单继承机制
 */
public class ThreadSubclassExample extends Thread {
    
    private String threadName;
    private int count;
    
    public ThreadSubclassExample(String threadName, int count) {
        this.threadName = threadName;
        this.count = count;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.println(threadName + " - 计数: " + i);
            try {
                Thread.sleep(100); // 休眠100毫秒，模拟任务执行
            } catch (InterruptedException e) {
                System.out.println(threadName + " 被中断");
                return;
            }
        }
        System.out.println(threadName + " 执行完毕");
    }
    
    public static void main(String[] args) {
        System.out.println("===== 使用Thread子类创建线程 =====");
        
        // 创建线程实例
        ThreadSubclassExample thread1 = new ThreadSubclassExample("线程A", 5);
        ThreadSubclassExample thread2 = new ThreadSubclassExample("线程B", 5);
        
        // 启动线程
        thread1.start();
        thread2.start();
        
        // 主线程也执行一些任务
        for (int i = 1; i <= 3; i++) {
            System.out.println("主线程 - 计数: " + i);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("主线程执行完毕");
    }
}
