package com.vinc.data.repository.mongo;

import com.vinc.domain.mongo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 11:08 2017/3/17
 */
@Component
public class CategoryRepositroy {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Category> getCategory(Query query){
        return mongoTemplate.find(query, Category.class, MongoCollections.CATEGORY);
    }

}
