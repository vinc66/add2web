package com.vinc.data.test;

import com.alibaba.fastjson.JSON;
import com.vinc.data.repository.mongo.CategoryRepositroy;
import com.vinc.data.repository.redis.ClusterRepository;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 15:25 2017/3/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-test.xml"})
public class SpringTestClazz {

//    @Autowired
    private ClusterRepository clusterRepository;


//    @Test
    public void testRedis(){
        print(clusterRepository.getClusterName("engine:slot:-1879326606"));
    }

//    @Autowired
    private CategoryRepositroy categoryRepositroy;

//    @Test
    public void testMongo() {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("name").in("历史");
        query.addCriteria(criteria);
        print(categoryRepositroy.getCategory(query));
    }

    private void print(Object obj) {
        System.out.println(JSON.toJSONString(obj));
    }


}
