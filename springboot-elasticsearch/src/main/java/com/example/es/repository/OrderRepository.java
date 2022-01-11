package com.example.es.repository;

import com.example.es.pojo.Order;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Classname OrderRepository
 * @Description TODO
 * @Date 2022/1/11 9:27 下午
 * @Created by zhaojh0912
 */
public interface OrderRepository extends ElasticsearchRepository<Order, Integer> {
}
