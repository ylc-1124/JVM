package cn.sust.chapter02;

public class ClinitTest {
    static class Father {
        public static int a = 1;
        static {
            a = 2;
        }
    }

    static class Son extends Father {
        public static int b = a;
    }

    public static void main(String[] args) {
        System.out.println(Son.b);
    }
}
