public enum StateDefineForTrafficLight {
    RED("停止", 30),
    YELLOW("准备", 3),
    GREEN("通行", 25);

    private final String action;
    private final int duration; // 秒

    StateDefineForTrafficLight(String action, int duration) {
        this.action = action;
        this.duration = duration;
    }

    public String getAction() { return action; }
    public int getDuration() { return duration; }
}

// 使用例
class TrafficTest {
    public static void main(String[] args) {
        // 直接使用枚举常量
        StateDefineForTrafficLight currentLight = StateDefineForTrafficLight.RED;

        // 调用枚举的方法获取属性
        System.out.println("当前灯：" + currentLight);
        System.out.println("动作：" + currentLight.getAction());
        System.out.println("持续：" + currentLight.getDuration() + "秒");
    }
}