package com.vinc.data.test;

import com.alibaba.fastjson.JSON;
import com.mongodb.*;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 15:25 2017/3/16
 */
public class TestClazz {

//    @Test
    public void testRedisCluster() {
//        Jedis jedis = new Jedis("test.redis.in");
//        jedis.set("foo", "bar");
//        String value = jedis.get("foo");
//        print(value);
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        jedisClusterNodes.add(new HostAndPort("ads-redis1.nhorizon.in", 6391));
        JedisCluster jc = new JedisCluster(jedisClusterNodes);
        jc.set("foo", "bar");
        String value2 = jc.get("foo");
        print(value2);
    }


//    @Test
    public void testMongo() throws UnknownHostException {
        ServerAddress serverAddress = new ServerAddress("127.0.0.1",27017);
        Mongo mongo = new Mongo(serverAddress);
        List<String> databaseNames = mongo.getDatabaseNames();
        print(databaseNames);
        DB yl = mongo.getDB("yl");
        print(yl.getCollectionNames());
        DBCollection categories = yl.getCollection("categories");
        DBObject ref = new BasicDBObject("name","历史");
        DBCursor dbObjects = categories.find(ref);
        while(dbObjects.hasNext()) {
            DBObject next = dbObjects.next();
            print(next);
        }
        DBObject one = categories.findOne("58be8acc7ce0ba2d48fa9a07");
        print(one);

    }



    private void print(Object obj) {
        System.out.println(JSON.toJSONString(obj));
    }


}
