package cn.sust.chapter09;

public class MethodAreaTest {
    public static void main(String[] args) {
        Order order = null;
        order.hello();
        System.out.println(order.count);
    }
}

class Order {
    public static int count = 1;  //类加载了就会调用类构造器<clinit> 初始化赋值
    public static final int number = 2;  //编译完就赋值了
    public final int n = 3;  //编译完就赋值了
    public int m = 4;  //等到创建对象 调用了对象构造器<init> 才会初始化赋值


    public static void hello() {
        System.out.println("hello!");
    }
}