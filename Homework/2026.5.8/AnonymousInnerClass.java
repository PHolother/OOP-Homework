import java.util.*;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() { return salary; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Employee{" + name + ", " + salary + "}";
    }
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("张三", 8000));
        list.add(new Employee("李四", 12000));
        list.add(new Employee("王五", 6000));

        // 匿名内部类实现 Comparator，按薪资升序
        list.sort(Comparator.comparingDouble(Employee::getSalary));

        System.out.println(list);
    }
}
