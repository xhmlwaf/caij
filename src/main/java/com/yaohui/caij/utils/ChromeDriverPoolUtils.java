package com.yaohui.caij.utils;

import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.stereotype.Component;

/**
 * 对象池管理
 */
@Component
public class ChromeDriverPoolUtils {


    private static final int MAX_TOTAL = 5;
    private static final int MAX_IDLE = 5;
    private static final int MIN_IDLE = 5;
    private static final int MAX_WAIT_MILLIS = -1;

    public static GenericObjectPool pool;

    static {
        pool = new GenericObjectPool(new ChromeDriverFactory(), genericObjectPoolConfig());
        pool.setAbandonedConfig(abandonedConfig());
        pool.setTimeBetweenEvictionRunsMillis(5000); //5秒运行一次维护任务
    }


    /**
     * 对象连接池配置
     */
    private static GenericObjectPoolConfig genericObjectPoolConfig() {

        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxTotal(MAX_TOTAL); //链接池中最大连接数
        genericObjectPoolConfig.setMaxIdle(MAX_IDLE);//链接池中最大空闲的连接数
        genericObjectPoolConfig.setMinIdle(MIN_IDLE);//连接池中最少空闲的连接数

        genericObjectPoolConfig.setMaxWaitMillis(MAX_WAIT_MILLIS); //当连接池资源耗尽时，等待时间，超出则抛异常，默认为-1即永不超时
        genericObjectPoolConfig.setBlockWhenExhausted(true); //当这个值为true的时候，maxWaitMillis参数才能生效。为false的时候，当连接池没资源，则立马抛异常。默认为true

//    基本参数
//            lifo
//    GenericObjectPool 提供了后进先出(LIFO)与先进先出(FIFO)两种行为模式的池。默认为true，即当池中有空闲可用的对象时，调用borrowObject方法会返回最近（后进）的实例
//            fairness
//    当从池中获取资源或者将资源还回池中时 是否使用java.util.concurrent.locks.ReentrantLock.ReentrantLock 的公平锁机制,默认为false

//    test参数
//            testOnCreate
//    默认false，create的时候检测是有有效，如果无效则从连接池中移除，并尝试获取继续获取
//            testOnBorrow
//    默认false，borrow的时候检测是有有效，如果无效则从连接池中移除，并尝试获取继续获取
//            testOnReturn
//    默认false，return的时候检测是有有效，如果无效则从连接池中移除，并尝试获取继续获取
//            testWhileIdle
//    默认false，在evictor线程里头，当evictionPolicy.evict方法返回false时，而且testWhileIdle为true的时候则检测是否有效，如果无效则移除


//    检测参数
//            timeBetweenEvictionRunsMillis
//    空闲链接检测线程检测的周期，毫秒数。如果为负值，表示不运行检测线程。默认为-1.

//    numTestsPerEvictionRun
//    在每次空闲连接回收器线程(如果有)运行时检查的连接数量，默认为3
//    minEvictableIdleTimeMillis
//    连接空闲的最小时间，达到此值后空闲连接将可能会被移除。默认为1000L 60L 30L
//    softMinEvictableIdleTimeMillis
//    连接空闲的最小时间，达到此值后空闲链接将会被移除，且保留minIdle个空闲连接数。默认为-1.
//    evictionPolicyClassName
//    evict策略的类名，默认为org.apache.commons.pool2.impl.DefaultEvictionPolicy

        return genericObjectPoolConfig;
    }


    /**
     * 设置了抛弃时间以后还需要打开泄漏清理才会生效。泄漏判断的开启可以通过两种方式：
     *
     * 从对象池中获取对象的时候进行清理 如果当前对象池中少于2个idle状态的对象或者 active数量>最大对象数-3 的时候，在borrow对象的时候启动泄漏清理。通过
     * AbandonedConfig.setRemoveAbandonedOnBorrow 为 true 进行开启。
     *
     * 启动定时任务进行清理 AbandonedConfig.setRemoveAbandonedOnMaintenance 设置为 true
     * 以后，在维护任务运行的时候会进行泄漏对象的清理，可以通过 GenericObjectPool.setTimeBetweenEvictionRunsMillis
     * 设置维护任务执行的时间间隔。
     */
    private static AbandonedConfig abandonedConfig() {
        AbandonedConfig abandonedConfig = new AbandonedConfig();
        abandonedConfig.setRemoveAbandonedOnMaintenance(true); //在Maintenance的时候检查是否有泄漏
        abandonedConfig.setRemoveAbandonedOnBorrow(true); //borrow 的时候检查泄漏
        abandonedConfig.setRemoveAbandonedTimeout(10); //如果一个对象borrow之后10秒还没有返还给pool，认为是泄漏的对象
        return abandonedConfig;
    }


}
