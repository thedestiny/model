package com.destiny.model.util.redis;

import com.destiny.model.util.config.ConfigLoader;
import com.destiny.model.util.string.StringUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class RedisClient {

    private static ResourceBundle bundle = ConfigLoader.loadConfig("redis");

    /* 远程连接地址 */
    private static String ADDR;
    /* 连接端口号*/
    private static Integer PORT;
    /* 验证密码*/
    private static String AUTH;
    /* 最大连接数*/
    private static Integer MAX_ACTIVE ;
    /* 最大空閑數*/
    private static Integer MAX_IDLE ;
    /* 最长等待时间*/
    private static Integer MAX_WAIT ;
    /* 断链时间 */
    private static Integer TIME_OUT ;
    /*在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用；*/
    private static boolean TEST_ON_BORROW ;

    private static JedisPool jedisPool = null;


    /* 初始化连接池 */

    static {
        try {
            ADDR = getValue("redis.addr");
            MAX_WAIT = StringUtil.transToInteger(getValue("redis.max.wait"));
            MAX_IDLE = StringUtil.transToInteger(getValue("redis.max.idle"));
            MAX_ACTIVE = StringUtil.transToInteger(getValue("redis.max.active"));
            PORT = StringUtil.transToInteger(getValue("redis.port"));
            AUTH = getValue("redis.auth");
            TIME_OUT = StringUtil.transToInteger(getValue("redis.time.out"));
            TEST_ON_BORROW = "true".equals(getValue("redis.on.borrow"));

            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxWaitMillis(MAX_WAIT);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxTotal(MAX_ACTIVE);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, ADDR, PORT, TIME_OUT, AUTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                return jedisPool.getResource();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }


    private static String getValue(String key) {

        try {
            return bundle.getString(key).trim();
        } catch (Exception e) {
            throw new IllegalStateException("cache.properties 中未配置 " + key + " 字段");
        }
    }


}
