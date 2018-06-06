package com.example.springlasticsearch.repostory;


import com.example.springlasticsearch.bean.TestBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author BaoZhou
 * @date 2018/6/6
 */
public interface TestRepository extends ElasticsearchRepository<TestBean, Integer> {
    public List<TestBean> findByAuthor(String author);
}
