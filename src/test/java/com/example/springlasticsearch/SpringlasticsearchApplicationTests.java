package com.example.springlasticsearch;

import com.example.springlasticsearch.bean.TestBean;
import com.example.springlasticsearch.repostory.TestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringlasticsearchApplicationTests {

    @Autowired
    TestRepository testRepository;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void contextLoads() {
        testRepository.index(new TestBean(1, "baozhou", "zuozhe"));
    }

    @Test
    public void findbook() {
        for (TestBean testBean : testRepository.findByAuthor("zuozhe")) {
            System.out.println(testBean);
        }

    }

    @Test
    public void templateTest() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
			
                .build();


        Page<TestBean> sampleEntities =
                elasticsearchTemplate.queryForPage(searchQuery, TestBean.class);

        System.out.println(searchQuery.toString());
        System.out.println(sampleEntities.toString());

    }


}
