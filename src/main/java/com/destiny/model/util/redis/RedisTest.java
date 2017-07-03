package com.destiny.model.util.redis;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class RedisTest {

    private Jedis jedis = null;

    @Before
    public void getRedis() {

        jedis = RedisClient.getJedis();

    }


    @Test
    public void testString() {


         /* set key -> value */
        String result = jedis.set("name2", "xinxin");
        /* key value nxxxx expx time   */
        /* nx key 不存在时进行set xx 只有key存在时进行set ex 秒 px 毫秒  */
        jedis.set("name-test","value-test","xx","ex",1000);

        System.out.println(" result is : " + result);
        System.out.println(jedis.get("name") );

        /* 在 key 对应的value 上追加 */
        jedis.append("name2", "is my lover");
        System.out.println(jedis.get("name"));

        /* 删除键 key */
        Long num = jedis.del("name");
        System.out.println(jedis.get("name"));
        System.out.println(" num is : " + num);

        jedis.mset("name", "liuling", "age", "23", "qq", "476777XXX");
        jedis.incr("age");
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));

    }

    @Test
    public void testMap(){

        Map<String,String> map = Maps.newHashMap();

        map.put("name","张三丰");
        map.put("age","16");
        map.put("address","USA");

        jedis.hmset("user",map);

        List<String> rsmap = jedis.hmget("user", "name", "age", "address");
        System.out.println(rsmap);


    }

    @Test
    public void testSet(){

        jedis.sadd("set-test","value1","value2","value3");
        jedis.sadd("set-test","value4");
        jedis.sadd("set-test","value5","value6","value7");
        /* 删除元素 value6 */
        jedis.srem("set-test","value6");
        /* 获取set的所有值 */
        System.out.println(jedis.smembers("set-test"));
        /* 判断 value6 是否属于 set-test */
        System.out.println(jedis.sismember("set-test","value6"));
        /* */
        System.out.println(jedis.srandmember("set-test"));
        /* 返回集合的个数 */
        System.out.println(jedis.scard("set-test"));



    }

    @Test
    public void testList(){
        /* 头部插入*/
        jedis.lpush("list-test","value1","value2","value3");
        /* 尾部插入 */
        jedis.rpush("list-test","A","B");
        /* 尾部弹出 */
        jedis.rpop("list-test");
        /* 头部弹出 */
        jedis.lpop("list-test");
        /* 查找第三个元素 */
        jedis.lindex("list-test",3);
        /* 查看范围内元素 */
        jedis.lrange("list-test",0,-1);
        /* 查看长度 */
        jedis.llen("list-test");

    }

    @Test
    public void testTransaction(){

         /* 清空当前db */
        // jedis.flushDB();
        /* 清空所有db */
        // jedis.flushAll();

        Transaction transaction = jedis.multi();

        List<Object> results = transaction.exec();

    }

    @Test
    public void testHash(){

        Map<String,String> map = Maps.newHashMap();
        map.put("name","张三");
        map.put("age","19");
        map.put("address","UK");
        map.put("phone","15637432654");

        /* 批量导入 key-> value*/
        jedis.hmset("hash-object",map);
        /* 获取key  hkeys*/
        Set<String> stringSet = jedis.hkeys("hash-object");
        /* 获取value */
        List<String> list = jedis.hvals("hash-object");
        /* 获取属性值 */
        String phone = jedis.hget("hash-object","phone");
        /* 删除属性 */
        Long result = jedis.hdel("hash-object","phone","age");
        /* 查看长度 */
        Long length = jedis.hlen("hash-object");
        /* 是否存在 */
        Boolean exists = jedis.hexists("hash-object","phone");
        /* 添加属性以及值*/
        jedis.hset("hash-object","phone","13233333333");
        jedis.hset("hash-object","age","50");
        jedis.hset("hash-object","age","25");
        List<String> mgetValue = jedis.hmget("hash-object","name","phone");
        /* 获取对象 */
        Map<String,String> allKeyAndValue = jedis.hgetAll("hash-object");



    }






}
