package com.example.es.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Classname Order
 * @Description 订单单elasticsearch 的实体
 * @Date 2022/1/11 9:09 下午
 * @Created by zhaojh0912
 */
@Data
@Document(indexName = "order", shards = 1, replicas = 1)
public class Order implements Serializable {
    /**
     * id 主键
     */
    @Id
    private Integer id;

    /**
     * 订单编号
     */
    @Field(type = FieldType.Keyword)
    private Long orderNo;

    /**
     * 订单类型
     */
    @Field(type = FieldType.Integer)
    private Integer orderType;

    /**
     * 订单账号
     */
    @Field(type = FieldType.Long)
    private Long orderAmount;

    /**
     * 订单描述
     */
    @Field(type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    private String orderDesc;

    /**
     * 用户名称
     */
    @Field(type = FieldType.Keyword, analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    private String username;

    /**
     * 用户的手机号
     */
    @Field(type = FieldType.Keyword, analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    private String userPhone;

    /**
     * 高亮的部分
     */
    private Map<String, List<String>> highlights;
}
