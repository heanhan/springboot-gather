package com.example.es.controller;

import com.alibaba.fastjson.JSON;
import com.example.es.pojo.Order;
import com.example.es.service.OrderService;
import org.elasticsearch.common.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname DocController
 * @Description TODO
 * @Date 2022/1/11 9:23 下午
 * @Created by zhaojh0912
 */
@RequestMapping("/doc/")
@RestController
public class DocController {

    @Autowired
    OrderService orderService;

    /**
     * 批量创建
     */
    @PostMapping("saveBatch")
    public String saveBatch(@RequestBody List<Order> orders) {
        if (CollectionUtils.isEmpty(orders.toArray())) {
            return "文档不能为空";
        }
        orderService.saveAll(orders);
        return "保存成功";
    }

    /**
     * 根据id删除
     */
    @GetMapping("deleteById")
    public String deleteById(@RequestParam Integer id) {
        orderService.deleteById(id);
        return "删除成功";
    }

    /**
     * 根据id更新
     */
    @PostMapping("updateById")
    public String updateById(@RequestBody Order order) {
        orderService.updateById(order);
        return "更新成功";
    }

    /**
     * 根据id搜索
     */
    @GetMapping("findById")
    public String findById(@RequestParam Integer id) {
        return JSON.toJSONString(orderService.findById(id));
    }

    /**
     * 分页搜索所有
     */
    @GetMapping("findAll")
    public String findAll(@RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
        return JSON.toJSONString(orderService.findAll(pageIndex, pageSize));
    }

    /**
     * 条件分页搜索
     */
    @GetMapping("findList")
    public String findList(@RequestBody Order order, @RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
        return JSON.toJSONString(orderService.findList(order, pageIndex, pageSize));
    }

    /**
     * 条件高亮分页搜索
     */
    @GetMapping("findHighlight")
    public String findHighlight(@RequestBody(required = false) Order order, @RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
        return JSON.toJSONString(orderService.findHighlight(order, pageIndex, pageSize));
    }
}
