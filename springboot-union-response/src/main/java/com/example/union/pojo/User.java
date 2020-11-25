package com.example.union.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author :zhaojh0912
 * @Date : 2020/11/25 2:07 下午
 * @Version : 1.0
 * @Description :Too
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Long id;

    private String account;

    private String password;

    private String email;
}
