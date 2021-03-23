package com.example.swagger.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/22 5:38 下午
 * @Version : 1.0
 * @Description :Too
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "分页参数接受的实体")
public class PageParam {

    private String pageIndex;

    private String pageSize;

}
