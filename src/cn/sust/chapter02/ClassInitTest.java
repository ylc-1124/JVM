package cn.sust.chapter02;

public class ClassInitTest {
    private static int num = 1;

    static {
        num = 2;
        number = 20;
        System.out.println(num);
     //   System.out.println(number); //报错，非法前向引用
    }
    private static int number = 10;  //prepare: number=0  init: number=20 => number=10

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);  //2
        System.out.println(ClassInitTest.number); //10
    }
}
