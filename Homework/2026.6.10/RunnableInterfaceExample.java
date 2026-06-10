package Blog610;

/**
 * 使用Runnable接口创建线程的示例
 * 
 * 特点：
 * 1. 实现Runnable接口，实现run()方法
 * 2. 需要将Runnable实例传递给Thread构造函数
 * 3. 更灵活，可以继承其他类，符合组合优于继承原则
 * 4. 适合多个线程共享同一个任务对象
 */
public class RunnableInterfaceExample implements Runnable {
    
    private String threadName;
    private int count;
    
    public RunnableInterfaceExample(String threadName, int count) {
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
        System.out.println("===== 使用Runnable接口创建线程 =====");
        
        // 方式1：为每个线程创建独立的Runnable实例
        RunnableInterfaceExample task1 = new RunnableInterfaceExample("线程C", 5);
        RunnableInterfaceExample task2 = new RunnableInterfaceExample("线程D", 5);
        
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        
        // 启动线程
        thread1.start();
        thread2.start();
        
        // 方式2：多个线程共享同一个Runnable实例（演示资源共享）
        System.out.println("\n===== 多个线程共享同一个Runnable实例 =====");
        SharedTask sharedTask = new SharedTask("共享任务", 10);
        Thread thread3 = new Thread(sharedTask, "线程E");
        Thread thread4 = new Thread(sharedTask, "线程F");
        
        thread3.start();
        thread4.start();
        
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

/**
 * 共享任务示例 - 演示Runnable的优势
 * 多个线程可以访问同一个对象的成员变量
 */
class SharedTask implements Runnable {
    
    private String taskName;
    private int totalCount;
    private int currentCount = 0;
    
    public SharedTask(String taskName, int totalCount) {
        this.taskName = taskName;
        this.totalCount = totalCount;
    }
    
    @Override
    public void run() {
        while (currentCount < totalCount) {
            // 使用synchronized确保线程安全
            synchronized (this) {
                if (currentCount < totalCount) {
                    currentCount++;
                    System.out.println(Thread.currentThread().getName() + 
                                     " - " + taskName + " 进度: " + currentCount + "/" + totalCount);
                }
            }
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 被中断");
                return;
            }
        }
        System.out.println(Thread.currentThread().getName() + " - " + taskName + " 执行完毕");
    }
}
