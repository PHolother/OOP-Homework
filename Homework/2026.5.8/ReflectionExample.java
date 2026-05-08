import java.lang.reflect.Method;

// 被反射操作的类
class Dog {
    public void bark(String sound) {
        System.out.println("狗叫：" + sound);
    }
}

class Cat {
    public void meow(String sound) {
        System.out.println("猫叫：" + sound);
    }
}

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        // 假设这串类名来自配置文件、数据库或注解，运行时才确定
        String className = "Dog";              // 可以改成 "Cat"
        String methodName = "bark";            // 对Cat来说应该是 "meow"
        String arg = "汪汪";

        // 可保证输出和库解耦，不关心得到的数据是什么，只负责输出。
        // 如果换成 Cat，就改成 className = "Cat"; methodName = "meow"; arg = "喵喵"

        // 1. 动态加载类
        Class<?> clazz = Class.forName(className);

        // 2. 动态创建实例（调用无参构造器）
        Object instance = clazz.getDeclaredConstructor().newInstance();

        // 3. 动态获取方法并调用
        Method method = clazz.getMethod(methodName, String.class);
        method.invoke(instance, arg);
    }
}