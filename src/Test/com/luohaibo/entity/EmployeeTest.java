package com.luohaibo.entity;

import junit.framework.TestCase;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Created by luohaibo on 2017/6/19.
 */
public class EmployeeTest extends TestCase {



    @Test
    public void test(){

        List<String> lista = new ArrayList<String>();
        for(int i=0;i<1000000;i++){
            double d = Math.random()*1000;
            lista.add(d+"");
        }
        long starta = System.nanoTime();//获取系统开始排序的时间点
        int counta= (int) ((Stream) lista.stream().sequential()).sorted().count();
        long enda = System.nanoTime();//获取系统结束排序的时间点
        long msa = TimeUnit.NANOSECONDS.toMillis(enda-starta);//得到串行排序所用的时间

//        lista.stream().sequential()
//                .filter((s)->  (Double.valueOf(s) > 500))
//                .sorted()
//                .forEach(System.out::println);
//        System.out.println("*********"+msa+"ms");


        List<String> list = new ArrayList<String>();
        for(int i=0;i<10000;i++){
            double d = Math.random()*1000;
            list.add(d+"");
        }
        long start = System.nanoTime();//获取系统开始排序的时间点
        int count = (int)((Stream) list.stream().parallel()).sorted().count();
        long end = System.nanoTime();//获取系统结束排序的时间点
        long ms = TimeUnit.NANOSECONDS.toMillis(end-start);//得到并行排序所用的时间

        list.stream().parallel()
                .filter((s)->  (Double.valueOf(s) > 500))
                .forEach(Double::valueOf)
               ;
        list.stream().forEach(System.out::println);


        list.stream().parallel().sorted();
        System.out.println("*********"+ms+"ms");
//        Persistence.createEntityManagerFactory("cn.luohaibo.jpa")

        //获取实例管理工程
//        EntityManagerFactory entityManagerFactory = null;
//        try {
//            entityManagerFactory  = Persistence.createEntityManagerFactory("cn.luohaibo.jpa");
//        }catch (Exception e){
//
//            e.printStackTrace();
//        }




    }



}