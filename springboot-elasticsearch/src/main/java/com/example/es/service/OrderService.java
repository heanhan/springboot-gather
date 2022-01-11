package com.example.es.service;

import com.example.es.dto.PageResponse;
import com.example.es.pojo.Order;

import java.util.List;

/**
 * @Classname OrderService
 * @Description TODO
 * @Date 2022/1/11 9:20 下午
 * @Created by zhaojh0912
 */
public interface OrderService {

    void saveAll(List<Order> orders);

    Order findById(Integer id);

    void deleteById(Integer id);

    void updateById(Order order);

    PageResponse<Order> findList(Order order, Integer pageIndex, Integer pageSize);

    PageResponse<Order> findAll(Integer pageIndex, Integer pageSize);

    PageResponse<Order> findHighlight(Order order, Integer pageIndex, Integer pageSize);
}
