package cn.sust.chapter16;

public class LocalVarGC {
    public void localvarGC1() {
        byte[] buffer = new byte[10 * 1024 * 1024];//10MB
        System.gc();
        //GC (System.gc()) [PSYoungGen: 14178K->10728K(76288K)]
        // 没有回收因为 buffer引用着
    }

    public void localvarGC2() {
        byte[] buffer = new byte[10 * 1024 * 1024];
        buffer = null;
        System.gc();
        //GC (System.gc()) [PSYoungGen: 14178K->960K(76288K)]
        //被回收了因为这个对象变成不可达的了
    }

    public void localvarGC3() {
        {
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        System.gc();
        //GC (System.gc()) [PSYoungGen: 14178K->10728K(76288K)]
        //没有回收，因为buffer所在的slot虽然可以被复用但是还没有变量复用，所以引用依然存在
    }

    public void localvarGC4() {
        {
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        int value = 10;
        System.gc();
        //GC (System.gc()) [PSYoungGen: 14178K->888K(76288K)]
        //被回收了，因为buffer过了作用域，且被value占用了他在slot所以byte[]对象变成不可达的了
    }

    public void localvarGC5() {
        localvarGC1();
        System.gc();
        //GC (System.gc()) [PSYoungGen: 1310K->96K(76288K)]
        //因为gc在这个方法中触发的，而方法1已经执行结束了，栈帧已经被弹出了，导致方法1中的对象变成了不可达的
    }

    public static void main(String[] args) {
        LocalVarGC local = new LocalVarGC();
        local.localvarGC5();
    }
}