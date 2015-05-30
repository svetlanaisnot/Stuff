
import java.io.File;
import java.io.PrintStream;
import java.util.*;
import java.util.function.Consumer;

import  java.lang.Math;
import static java.lang.System.*;
/**
 * Created by svetlana on 04/09/14.
 */
public class A extends B{

    static {
        System.out.println("Static block in A");
    }

    {
        System.out.println("Non static block in A");
    }

    protected String s = "A string";

    public A(int i) {
        super(i);
        System.out.println("s is " + s);
        System.out.println("Constructor A");
    }

    public static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list.toString());
        System.out.println(list.get(2));
        list.remove(2);
        System.out.println(list.toString());

        System.out.println(list.get(2));
    }


    public static void addGoogolElements(ArrayList<Integer> list) {
        for (int i = 0; i < 10000000; i++) {
            list.add(i, 0);
        }
    }

    public static void addGoogolElementsLL(LinkedList<Integer> list) {
        for (int i = 0; i < 10000000; i++) {
            list.addFirst(i);
        }
    }


    public void test() {
        System.out.println("A test");
    }
}

class Test<T> {
    void test(T t) {

    }
}

 class Alpha {
    Alpha doStuff() {
        return new Alpha();
    }
}

class Beta extends Alpha {
    Beta doStuff() {
        return new Beta();
    }
}

class B {
    static {
        System.out.println("Static block in B");
    }

    {
        System.out.println("Non static block in B");
    }

    protected String s = "B string";

    public B(int i) {
        System.out.println("s is " + s);
        System.out.println("Constructor B");
    }

    public void test() {
        System.out.println("B test");
    }
}



