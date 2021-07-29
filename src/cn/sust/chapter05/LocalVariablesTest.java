package cn.sust.chapter05;

import java.util.Date;

/**
 * 局部变量表演示
 */
public class LocalVariablesTest {
    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        int num = 10;
        test.test2();
      //  System.out.println(num);
        test.add();
    }
    private void test2() {
        int a = 0;
        {
            int b = 0;
            b = a+1;
        }
        //变量c使用之前已经销毁的变量b占据的slot位置
        int c = a+1;
    }


    private void add() {
        /**
         * 第一类问题  没有区别
         */
        int i1 = 10;
        i1++;
        int i2 = 20;
        ++i2;
        /**
         * 第二类问题
         */
        int i3 = 10;
        int i4 = i3++;  //10
        System.out.println("i4:"+i4);
        int i5 = 10;
        int i6 = ++i5;   //11
        System.out.println("i6:"+i6);
        /**
         * 第三类问题
         */
        int i7 = 10;
        i7 = i7++; //10
        System.out.println("i7:"+i7);
        int i8 = 10;
        i8 = ++i8;  //11
        System.out.println("i8:"+i8);
        /**
         * 第四类问题
         */
        int i9 = 10;
        int i10 = i9++ + ++i9;   //22
        System.out.println("i10:"+i10);
    }


}
