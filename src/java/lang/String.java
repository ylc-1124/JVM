package java.lang;

/**
 * 自定义一个和核心库包名一样的String类 但是由于双亲委派机制，这个类不会被加载
 */
public class String {
    static {
        System.out.println("静态代码块执行");
    }

    public static void main(String[] args) {
        System.out.println("hello,String");
    }
//    错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
//    public static void main(String[] args)
//    否则 JavaFX 应用程序类必须扩展javafx.application.Application
}
