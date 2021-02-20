package com.xiaoyc.remind.service;


import org.apache.commons.lang3.time.StopWatch;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadDemo {
    /**
     *  100w  
     *  200w
     * @return
     */
    public static List<Integer> getList(){
        List<Integer> list=new LinkedList<>();
        for (int i = 0; i <5000000 ; i++) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        //创建并启动StopWatch
        StopWatch stopwatch =StopWatch.createStarted();

        List<Integer> list=getList();
      //  list.forEach(System.out::println);
        threadPrint(getList());
       stopwatch.stop();
        System.out.println(stopwatch.getTime(TimeUnit.SECONDS));
    }

    public static void threadPrint(List<Integer> list){
        //创建并启动StopWatch
        StopWatch stopwatch =StopWatch.createStarted();

        int index=list.size()/5;

        List<Integer> list1=list.subList(0,index);
        List<Integer> list2=list.subList(index,index*2);
        List<Integer> list3=list.subList(index*2,index*3);
        List<Integer> list4=list.subList(index*3,index*4);
        List<Integer> list5=list.subList(index*4,list.size());


        new Thread(new Runnable() {
            @Override
            public void run() {
                list1.forEach(x->{
                    System.out.println(Thread.currentThread().getName()+"**"+x);
                });
            }
        },"线程1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                list2.forEach(x->{
                    System.out.println(Thread.currentThread().getName()+"**"+x);
                });
            }
        },"线程2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                list3.forEach(x->{
                    System.out.println(Thread.currentThread().getName()+"**"+x);
                });
            }
        },"线程3").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                list4.forEach(x->{
                    System.out.println(Thread.currentThread().getName()+"**"+x);
                });
            }
        },"线程4").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                list5.forEach(x->{
                    System.out.println(Thread.currentThread().getName()+"**"+x);
                });
            }
        },"线程5").start();

        stopwatch.stop();
        System.out.println("时间是"+stopwatch.getTime(TimeUnit.SECONDS));

    }
}
