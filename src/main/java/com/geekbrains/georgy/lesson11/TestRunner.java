package com.geekbrains.georgy.lesson11;

import com.geekbrains.georgy.lesson11.annotation.AfterSuite;
import com.geekbrains.georgy.lesson11.annotation.BeforeSuite;
import com.geekbrains.georgy.lesson11.annotation.Test;

import java.lang.reflect.Method;
import java.util.*;

public class TestRunner {
    public static void main(String[] args) throws Exception {
    start(CustomTest.class);
    }

    public static void start(Class testClass) throws Exception {

        Method [] methods = testClass.getDeclaredMethods();
        int countAfter = 0;
        int countBefore = 0;

        LinkedList<Method> listTest = new LinkedList<>();

        Method after = null;
        Method before = null;

        for (Method method : methods){
            if (method.isAnnotationPresent(com.geekbrains.georgy.lesson11.annotation.Test.class))  {
                listTest.add(method);

            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                if (countAfter > 1) throw new RuntimeException("@AfterSuite must be present in a single instance");
                after = method;
                countAfter++;


            } else  if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (countBefore > 1) throw new RuntimeException("@BeforeSuite must be present in a single instance");
                before = method;
                countBefore++;
            }
        }

        listTest.sort(Comparator.comparing(s -> s.getAnnotation(Test.class).priority()));
        Collections.reverse(listTest);

        Object object = testClass.getConstructor().newInstance();

        if (before != null)  {
            before.setAccessible(true);
            before.invoke(object);
        }

        for (Method method : listTest) {
            method.invoke(object);
        }

        if (after != null) {
            after.setAccessible(true);
            after.invoke(object);
        }
    }
}
