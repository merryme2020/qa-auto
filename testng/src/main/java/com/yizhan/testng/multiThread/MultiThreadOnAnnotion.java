package com.yizhan.testng.multiThread;

/******
 * 注解形式实现多线程
 */

import org.testng.annotations.Test;

public class MultiThreadOnAnnotion {

    /*****
     * invocationCount 线程数默认为1，设置为10。（线程池为1个，所以是一个一个执行的打印10个1）
     * threadPoolSize 线程池
     * 多线程运行的时候执行顺序无法控制
     */
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());//打印线程id

    }

}
